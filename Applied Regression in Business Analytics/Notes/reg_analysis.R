setwd("~/Desktop/School/ISA 291")

## Let's check if the file is in the working directory
dir()

## Read the data
## what is the type of file? .txt
## separator = single space
## header = True

college = read.table("scorecard_example-1.txt", 
                     header = TRUE, sep = " ",
                     stringsAsFactors = TRUE)

## Let's print the first 10 observations
head(college,10)


## Analyze the Response
mean(college$md_earn_wne_p10)


summary(college$md_earn_wne_p10)

## Create a histogram of the median earnins
hist(college$md_earn_wne_p10, breaks = 40)


## Plot a scatter plot using the 'plot' function (x,y) to check the relationship

plot(college$Cost4_A, college$md_earn_wne_p10)


## Create a regression
## object = lm(y ~ x, data = dataset)

options(scipen = 999)
reg1 = lm(md_earn_wne_p10 ~ Cost4_A, data = college)
summary(reg1)

## Slope:

## As the cost of college increases by $1, then (on average , we predict, the mean earnings)
## the earnings post-graduation increase by $0.48

## Y-intercept
## When the cost of college is zero, then on average the earnings are $24,138.03

## The reg1 object
names(reg1)


## Let's get the coefficients
reg1$coefficients

## Let's get the residuals (print), then tell what is the residual for obs 3
reg1$residuals

## If you just want an individual residual (3)
reg1$residuals[3]


## Residual is the error of the model
## The prediction for obs 3 is off by 8373.622

## Lets look at the predicted values
reg1$fitted.values[3]
college$md_earn_wne_p10[3]

## The sum of the residuals
sum(reg1$residuals)


## Look at SSE (sum of squared estimate of errors [residuals])
anova(reg1)

sum(reg1$residuals^2)


## Matricies
X = model.matrix(reg1)
head(X)
y = college$md_earn_wne_p10

## inverse of the matrix?
b = solve(t(X)%*%X)  %*% (t(X)%*%y) ## minimizes SSE
b

## Let's plot the regression line
plot(college$Cost4_A, college$md_earn_wne_p10)
# useabline to plot the regression line
abline(reg1, col = 'red', lw = 2)

## Assumptions of the regression Model
## There are 4 assumptions

## 1) That the mean(epsilon) is zero
#* we can check the residuals to form an estimate of the epsilon 
sum(reg1$residuals)
mean(reg1$residuals)

## 2) Variance(epsilon) is constant across all x values
#* You can check the scatter plot and give your opinion
#* There seems to be a little non-constant variance

## 3) epsilon is normally distributed
#* check how the residuals look like
hist(reg1$residuals, breaks = 30)

## QQ-Plots
qqnorm(reg1$residuals)
qqline(reg1$residuals)

## That assumption 3 might not be completely true
## There are deviations to normality

## 4) The errors associated with any two different observations are independent