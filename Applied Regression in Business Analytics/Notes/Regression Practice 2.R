setwd("~/Desktop/School/ISA 291")


## Read the data
college = read.table("scorecard_example-1.txt", 
                     header = T,
                     sep = " ",
                     stringsAsFactors = T)


## Create Regression
options(scipen = 999) ## gets rid of exponential notation

reg1 = lm(md_earn_wne_p10 ~ Cost4_A, data = college)
summary(reg1)

plot(college$Cost4_A, college$md_earn_wne_p10)
abline(reg1, col = 'red', lw = 3)

## ANOVA of reg1
anova(reg1)


## n - 2 is equal to 3846
## SSE is 336061060359

## s^2 ----- s^{y|X} ----- MSE
## The estimate of sigma^2 is 87379371 (average squared error)

## Residuals can be obtained from the reg1 object
reg1$residuals

## average residual
mean(reg1$residuals)

## average squared residual
mean(reg1$residuals^2)

sqrt(mean(reg1$residuals^2))


## Assumption 1 (mean(epsilion))
## We do not need to check

## Assumption 2 (var(epsilion) is constant)
## var(residuals) is 87379371
## you can plot the residuals on the y-axis and x variable, y value, yhat
## on the x axis

## plot 1: yhat(x-axis) and residuals (y-axis)
plot(reg1$fitted.values, reg1$residuals, main = "Residuals versus Fitted Values")
## draw the line at zero
abline(0,0, col = 'red')

## plot 2: cost(x-axis) and residuals (y-axis)
plot(college$Cost4_A, reg1$residuals, main = "Residuals versus Cost Values")
## draw the line at zero
abline(0,0, col = 'red')

## Assumption 3
