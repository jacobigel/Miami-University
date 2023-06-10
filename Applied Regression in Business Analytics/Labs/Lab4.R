setwd("~/Desktop/School/ISA 291")

weather = read.csv('weatherHistory.csv', stringsAsFactors = TRUE)
weather

summary(weather$Visibility)
hist(weather$Visibility)

cor(weather)

reg1 = lm(Visibility ~ ., data =weather)
summary(reg1)
anova(reg1)

cor(weather)

weather[, 3:7]

cor(weather[,3:7])
corrplot(cor(weather[,3:7]))

model.matrix(reg1)

options(scipen =999)
weather$Summary = as.factor(weather$Summary)
levels(weather$Summary)

weather$Precip_Type = as.factor(weather$Precip_Type)
levels(weather$Precip_Type)

anova(weather$Summary)

-7.66318880 +5.22635677

weather$Summary = relevel(weather$Summary, ref = "Clear")
reg1 = lm(Visibility ~ ., data =weather)
summary(reg1)
anova(reg1)

reg2 = lm(Visibility ~ Temperature_Celcius + Humidity + Precip_Type 
          + (Humidity*Precip_Type) + I(Temperature_Celcius*Temperature_Celcius),
          data = weather)
summary(reg2)
anova(reg2)


10.3420427 + -6.8066304

predict.lm(weather, data.frame(Temperature_Celcius=30, Humidity=0.72, 
                            Precip_Type = "null"))

12.0207675 + -9.3430083
((30 *0.3709320) + 12.0207675)

newdata = data.frame(Temperature_Celcius = 30, Humidity = 0.72,Precip_Type = "null" )
predictions = predict.lm(reg2, newdata)
predictions
