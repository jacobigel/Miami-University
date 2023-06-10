setwd("~/Desktop/School/ISA 291")

##install.packages('mlbench')
library(mlbench)

data("BostonHousing")


## Visual Approach
## Scatterplot matrix

plot(BostonHousing)


plot(BostonHousing$crim, BostonHousing$medv)


## SLR using crime as a predictor of medv

reg1 = lm(medv ~ crim, data = BostonHousing)
summary(reg1)


## Adding a quadratic to the crim variable

reg2 = lm(medv ~ crim + I(crim*crim), data = BostonHousing)
summary(reg2)

## INTERPRETATION
## What is the effect of crime in the medv?
## Effect is the same as the slope
## Change in y produced by a change in x
#-0.876141 + 2(0.008868)*crim

# As crime rate increases by 1% then on average the medv changes by
# -0.876141 + 2(0.008868)*crim
 
## Suppose crime rate is 1%
# As crime rate increases by 1% then on average the medv changes by
# -0.858405 or $858

## Suppose crime rate is 5%
# As crime rate increases by 1% then on average the medv changes by
# -0.787461 or $787

## Suppose crime rate is 50%
# As crime rate increases by 1% then on average the medv increases by
# 0.010659 or $10

## Regression 3 
reg3 = lm(medv ~ rm + lstat + I(rm^2) + I(lstat^2), data = BostonHousing)
summary(reg3)
