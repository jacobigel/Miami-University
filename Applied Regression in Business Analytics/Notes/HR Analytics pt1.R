## HR Analytics Part 1
setwd("~/Desktop/School/ISA 291")

dir()



HR = read.csv("HR_Analysis.csv", stringsAsFactors = T)

# Correlation Matrix
cor(HR) # Does not work when there are non-numeric variables (categorical variables)

## Subset the variables so that we can access only numeric variables

## Install a package named dplyr
## helpful in data manipulation
install.packages('dplyr')

## Load dplyr
library(dplyr)

## Dplyr can help in subsetting data
HR_num = HR %>% select(where(is.numeric))

## Correlation Matrix
cor(HR_num)

## Install the package corrplot
## load it
install.packages('corrplot')
library(corrplot)

corrplot(cor(HR_num))

## Check the response
hist(HR$satisfaction_level)
summary(HR$satisfaction_level)



## These are the variables we should recode
## Work_accident
## left
## promotion


## Let's recode these variables
HR$Work_accident = as.factor(HR$Work_accident)
HR$left = as.factor(HR$left)
HR$promotion_last_5years = as.factor(HR$promotion_last_5years)

## lm(satisfaction_level ~ last_evaluation + ...)
## lm(satisfaction_level ~ ., data = HR)

## How to drop a variable
#HR = HR[,-7]

# This approach is preferred
#HR$left = NULL

## Can check the levels by using the levels
levels(HR$Department)
## The number of MODEL DF of a categorical variables
## is the number of levels minus 1

## R automatically encodes variables for us using the lm function
## object = lm(satisfaction_level ~ Department, data = HR)
reg1 = lm(satisfaction_level ~ Department, data = HR)
summary(reg1)



