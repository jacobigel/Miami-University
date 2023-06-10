setwd("~/Desktop/School/ISA 291")


diamonds = read.csv('diamonds_training.csv', stringsAsFactors = T)
diamonds_valid = read.csv('diamonds_validation.csv', stringsAsFactors = T)

# First Columns
diamonds = diamonds[,-c(1,2)]

# Print obs
head(diamonds)

#Price
hist(diamonds$price, breaks = 30)
summary(diamonds$price)

# Correlation Matrix
cor(diamonds)
#* Select the variables that are numeric using subsetting
cor(diamonds[,c(3,7,8,9,10,11,12)])
#* Select the variables that are numeric using dplyr
library(dplyr)
cor(diamonds[,-c(1,2)] %>% select(where(is.numeric)))

# Relationship between the predictors
# to check Mulicollinearity
# ScatterPlot Matrix
plot(diamonds)

# Correlation plot
library(corrplot)
corrplot(cor(diamonds[,-c(1,2)] %>% select(where(is.numeric))))

# Relationship between carat and Price
plot(diamonds$carat, diamonds$price)
plot(diamonds$x, diamonds$price)
plot(diamonds$y, diamonds$price)
plot(diamonds$z, diamonds$price)

# Predictive Models
# Candidate Model 1
reg1 = lm(price ~ carat+cut+color+clarity+depth+table, data = diamonds)
summary(reg1)

# Candidate Model 2
reg2 = lm(price ~ carat+cut+color+clarity+depth+table+I(carat^2), data = diamonds)
summary(reg2)

# Predictive Power #1
predictions1 = predict(reg1, newdata = diamonds_valid)
head(predictions1)


# RMSE
residuals1 = diamonds_valid$price - predictions1
sqrt(sum(residuals1^2)/ nrow(diamonds_valid))

