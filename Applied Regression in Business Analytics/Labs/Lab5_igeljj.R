setwd("~/Desktop/School/ISA 291")


credit = read.csv('Credit.csv', stringsAsFactors = T)


cor(credit)


plot(credit)

reg1 = lm(Balance ~ ., data = credit)
summary(reg1)
anova(reg1)

library(car)

vif(reg1)

reg2 = lm(Balance ~ Income, data = credit)
summary(reg2)


credit_predict = read.csv('Credit_Predict.csv')

predict(reg1, data.frame(credit_predict), level = .95, interval = 'prediction')

predict(data.frame(reg1), prediction)
