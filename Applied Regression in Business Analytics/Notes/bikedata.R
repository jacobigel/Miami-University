## Practice with Variable Screening Methods
# Capital Bikeshare
setwd("~/Desktop/School/ISA 291")

#import the training dataset
bike_train = read.csv('BikeTraining.csv')

# import the validation dataset
# you do not build models with this dataset
bike_valid = read.csv('BikeValidation.csv')


# understand the data
hist(bike_train$cnt, breaks = 100)

mean(bike_train$cnt)

#cor(bike_train[,c(1,4,5,6,7,8,9,10,11,12)])
plot(bike_train$cnt, bike_train$registered)
plot(bike_train$cnt, bike_train$casual)
plot(bike_train$casual, bike_train$weathersit)
plot(bike_train$registered, bike_train$weathersit)

#install.packages('dplyr')
library(dplyr)
cor(bike_train%>% select(where(is.numeric)))

# Structure (variable types)
str(bike_train)


# Recoding variables as factors
bike_train$season = as.factor(bike_train$season)
bike_train$yr = as.factor(bike_train$yr)
#bike_train$weathersit = as.factor(bike_train$weathersit)

# Drop Date as a variable since we have the months/year
bike_train$dteday = NULL

cor(bike_train %>% select(where(is.numeric)))

## MultiCol.
#*atemp and temp
#*cnt and registered

# PRELIMINARY ANALYSIS
# Construct SLR (weathersit, cnt)
exp1 = lm(cnt ~ weathersit, data = bike_train)
summary(exp1)

# 1: good weather
# 2: some cloudy
# 3: some rain, snow
# 4: bad weather


exp2 = lm(cnt ~ as.factor(weathersit), data = bike_train)
summary(exp2)

boxplot(cnt ~ weathersit, data = bike_train)

# Analyze by causual and registered
exp3 = lm(casual ~ as.factor(weathersit), data = bike_train)
summary(exp3)

exp4 = lm(registered ~ as.factor(weathersit), data = bike_train)
summary(exp4)

# corr
reg1 = lm(cnt ~ weekday + weathersit + temp + atemp + hum + windspeed
          , data = bike_train)
summary(reg1)

#cor(bike_train[,-2])


## Variable Screening
## best Subsets
## An idea of which varaibles you are going to consider

# leaps
#install.packages('leaps')
library(leaps)

bestreg = regsubsets(cnt ~ weekday +
                          weathersit +
                          temp +
                          atemp +
                          hum +
                          windspeed,
                        data = bike_train, nbest = 2)
summary_best_reg = summary(bestreg)


# With this package, you can see the different models according
# to different statistics
#* Cp: remember <= k + 1, the lower the better
#* Adj-R2: the higher the better
#* BIC


bestreg2 = regsubsets(cnt ~ 
                        (weekday + 
                           weathersit + 
                           temp + 
                           atemp + 
                           hum + 
                           windspeed)^2,
                      data = bike_train, nbest = 2, nvmax = 12)
summary_best_reg2 = summary(bestreg2)

#install.packages('DataExplorer')
library(DataExplorer)
#install.packages('colorspace')

plot_missing(bike_train)


bike_sample = bike_train[sample(1:nrow(bike_train), 10000),]


null_model = lm(cnt ~ 1, data = bike_sample)
summary(null_model)

full_model = lm(cnt ~ (weekday + 
                           weathersit + 
                           temp + 
                           atemp + 
                           hum + 
                           windspeed)^2,
                      data = bike_sample)
summary(full_model)

step.reg = step(null_model, scope = list(lower = null_model, upper = full_model),
                direction = "both", trace = 1, k =2)
summary(step.reg)

step.reg$call

can1 = lm(formula = cnt ~ temp + hum + atemp + windspeed + weathersit + 
            temp:hum + temp:atemp + atemp:windspeed + hum:weathersit + 
            hum:windspeed + windspeed:weathersit, data = bike_sample)
summary(can1)

can1_predict = predict(can1, newdata = bike_valid)
summary(can1_predict)

options(scipen = 300)
can2 = lm(formula = cnt ~ temp + hum + atemp + windspeed +temp:atemp + 
            atemp:windspeed + hum:atemp, data = bike_sample)

summary(can2)

can2_predict = predict(can2, newdata = bike_valid)

can3 = lm(formula = cnt ~ temp + hum + atemp + windspeed + casual+ 
            as.factor(weathersit) +temp:atemp + 
     atemp:windspeed + hum:atemp, data = bike_sample)

summary(can3)

# FINAL ALL

can4 = lm(formula = cnt ~ temp + hum + atemp + windspeed  +
          +temp:atemp + atemp:windspeed + hum:atemp, data = bike_sample)
summary(can4)

anova(can4)

plot(can4)

#Registered Users
full_model2 = lm(cnt ~ (weekday + 
                         weathersit + 
                         temp + 
                         atemp + 
                         hum + 
                         windspeed+
                          registered)^2,
                data = bike_sample)

summary(full_model2)

step.reg2 = step(null_model, scope = list(lower = null_model, upper = full_model),
                direction = "both", trace = 1, k =2)
summary(step.reg2)

step.reg2$call

# FINAL REGISTERED
regregist = lm(cnt ~ temp + hum + atemp + windspeed + registered + temp:atemp + 
                 atemp:windspeed + hum:windspeed + hum:atemp, data = bike_sample)

summary(regregist)

plot(regregist)

predictions2 = predict(regregist, newdata =bike_valid)
head(predictions2)

residuals2 = bike_valid$cnt - predictions2
sqrt(sum(residuals2^2)/ nrow(bike_valid))


expregs = lm(cnt ~ as.factor(weathersit) + registered + as.factor(weathersit):registered, data = bike_train)
summary(expregs)

# Casual
full_model3 = lm(cnt ~ (weekday + 
                          weathersit + 
                          temp + 
                          atemp + 
                          hum + 
                          windspeed+
                          casual)^2,
                 data = bike_train)

summary(full_model3)

step.reg3 = step(null_model, scope = list(lower = null_model, upper = full_model),
                 direction = "both", trace = 1, k =2)
summary(step.reg3)

step.reg3$call

#FINAL CASUAL
regcas = lm(cnt ~ temp + hum + atemp + windspeed + casual+ temp:atemp + 
              atemp:windspeed + hum:windspeed + hum:atemp, data = bike_sample)
summary(regcas)
expregs = lm(cnt ~ as.factor(weathersit) + casual + as.factor(weathersit):casual, data = bike_train)
summary(expregs)

plot(regcas)

     