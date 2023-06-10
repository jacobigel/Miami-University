setwd("~/Desktop/School/ISA 291")

## Read the data
college = read.table("scorecard_example-1.txt", 
                     header = T,
                     sep = " ",
                     stringsAsFactors = T)

options(scipen = 999) ## gets rid of exponential notation

## Create Regression
reg1 = lm(md_earn_wne_p10 ~ Cost4_A, data = college)
summary(reg1)

plot(college$Cost4_A, college$md_earn_wne_p10)

## The anova table contains the sums of squares
## also the degrees of freedom for the sums of squares
anova(reg1)

## 3846 corresponds to n - 2, which are the df associated with SSE
## 336061060359 is SSE

## 336061060359 / 3846


## ASSUMPTIONS

## Assumption 1: mean(epsilon) = 0
mean(reg1$residuals)
sum(reg1$residuals)

## Assumption 2: var(epsilon) = constant (call this constant sigma^2)
## what is sigma^2? we don't know. We can estimate it
## The estimate is MSE (s^2, s^2{y|x}) 87379371

## var(reg1$residuals) this number is going to be off, b/c divide by n-1
## mean(reg1$residuals^2) this number is off b/c divides by n

## MSE does not have an interpretation in the language of the problem
## RMSE $9348 (the estimated error of the prediction is about $9,348)

## Sometimes the scatterplot does not show non-constant variance
## What if you have more than one predictor?
## In those cases it is better to plot the residuals vs (yhat, x-values, y)

## Residual plot # 1 (residuals (y axis) vs yhat (x - axis))
plot(reg1$fitted.values,reg1$residuals, title = "Residuals versus Fitted")
## draw the horizontal line around zero
abline(0,0, col = 'red')


## correlation and R2

## SSR is 119954813942   (EXPLAINED VARIATION)
## The df associated with SSR is the number of predictors 1

## SSE is 336061060359    (UNEXPLAINED VARIATION)

## SST = SSR + SSE = 456015874301   (TOTAL VARIATION)
119954813942 + 336061060359


## R2 = SSR / SST = 0.263


SSR = 119954813942 # explained by the variable Cost4_A
SSE = 336061060359


SST = SSR + SSE

R2 = SSR / SST
R2



