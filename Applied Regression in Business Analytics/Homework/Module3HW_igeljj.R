setwd("~/Desktop/School/ISA 291")

cars = read.csv("Cars.csv", header = TRUE, stringsAsFactors = TRUE)
cars

options(scipen = 999)
reg1 = lm(Price ~ Liter + Doors, data = cars)
reg1
summary(reg1)

plot(cars$Liter, cars$Price)
abline(lm(Price ~ Liter, data = cars), col = 'red')
cor(cars$Liter, cars$Price)

plot(cars$Doors, cars$Price)
abline(lm(Price ~ Doors, data = cars), col = 'red')
cor(cars$Doors, cars$Price)

avg_yhat = 10291.1 + (4923.0*3.1) - (1105.8*4)
avg_yhat

confint(reg1,newdata = data.frame(Liter), level = .95)

summary(reg1)$adj.r.squared 

anova(reg1)

predict(reg1,newdata=data.frame(Liter = 3.1,Doors=2),interval="confidence",level = 0.95)
predict(reg1,newdata=data.frame(Liter = 3.1,Doors=2),interval="prediction",level = 0.95)

plot(reg1$fitted.values, reg1$residuals)
abline(0,0, col = 'red')


hist(reg1$residuals, breaks = 30)

qqnorm(reg1$residuals)
qqline(reg1$residuals)