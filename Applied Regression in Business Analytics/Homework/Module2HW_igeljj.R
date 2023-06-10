setwd("~/Desktop/School/ISA 291")

dir()
# read.table('example.csv', header = T/F, sep = ",", stringsAsFactors = T)

PGADRIVER = read.csv("PGADRIVER.csv", header = TRUE, stringsAsFactors = TRUE)

plot(PGADRIVER$DISTANCE, PGADRIVER$ACCURACY, main = 'Distance vs Accuracy')

cor(PGADRIVER$DISTANCE,PGADRIVER$ACCURACY)

options(scipen = 999)
reg1 = lm(ACCURACY ~ DISTANCE, data = PGADRIVER)
summary(reg1)

mean(reg1$residuals)
var(reg1$residuals)

hist(reg1$residuals, breaks = 30)

anova(reg1)


confint(reg1, level = .95)


predict(reg1, newdata = data.frame(DISTANCE=300), interval = "confidence")
predict(reg1, newdata = data.frame(DISTANCE=300), interval = "prediction")
