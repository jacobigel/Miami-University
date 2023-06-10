setwd("~/Desktop/School/ISA 291")

##Predictive Models Instructions

#* We are learning how top build models to predict new datat
#* Read the data

umbrellas_data = read.csv('umbrellas.csv')
umbrellas_data

reg1 = lm(Umbrellas ~ Rainfall, data = umbrellas_data)
summary(reg1)
anova(reg1)


plot(umbrellas_data$Rainfall, umbrellas_data$Umbrellas)
abline(reg1, col = 'red')
#* This is an example of a "likely" underfit model
#* We might be better off with a higher order polynomial

#* Run a second order polynomial model
#* What is the fraction of percentage of explained variation?
reg2 = lm(Umbrellas ~ Rainfall + I(Rainfall*Rainfall), data = umbrellas_data)
summary(reg2)
# abline(reg2, col = 'red') does not work for quadratic

fake_rainfall = seq(0, 170, 0.1)
predictions = predict(reg2, data.frame(Rainfall = fake_rainfall))
lines(fake_rainfall,predictions, col = 'blue', lwd = 3)

#* I like this, better Adj-R2, better performance
#* Model doesnt seem to be overfit
#* Let's keep going - 3rd order model

reg3 = lm(Umbrellas ~ Rainfall + I(Rainfall*Rainfall)+I(Rainfall^3)
          , data = umbrellas_data)
summary(reg3)
options(scipen = 999)
# Adj R2 got worse
fake_rainfall = seq(0, 170, 0.1)
predictions = predict(reg3, data.frame(Rainfall = fake_rainfall))
lines(fake_rainfall,predictions, col = 'brown', lwd = 3)

## Scatter plot
plot(umbrellas_data$Rainfall, umbrellas_data$Umbrellas, xlim = c(80,250), ylim = c(10,100))
abline(reg1, col = 'red')

# 2nd-Order Model
fake_rainfall = seq(0, 250, 0.1)
predictions = predict(reg2, data.frame(Rainfall = fake_rainfall))
lines(fake_rainfall,predictions, col = 'blue', lwd = 3)

# 2nd-Order Model
fake_rainfall = seq(0, 250, 0.1)
predictions = predict(reg3, data.frame(Rainfall = fake_rainfall))
lines(fake_rainfall,predictions, col = 'brown', lwd = 3)