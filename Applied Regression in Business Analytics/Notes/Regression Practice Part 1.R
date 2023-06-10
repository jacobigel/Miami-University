setwd("~/Desktop/School/ISA 291")

## Downloading, and Placing the file on your folder

## What is the file extension (type of file)? .txt
## Does the file have a header? TRUE
## What is the delimiter? the separator is a space

## Check if the file is in the WD
dir()

## Read the data
college = read.table("scorecard_example-1.txt", 
                     header = T,
                     sep = " ",
                     stringsAsFactors = T)

## Let's print the first 10 observations
## let me know what is the cost of college of obs 10
head(college, 10)

## Analyze the Response md_earn_wne_p10
mean(college$md_earn_wne_p10)
var(college$md_earn_wne_p10)
sd(college$md_earn_wne_p10)
summary(college$md_earn_wne_p10)

## Let's get a histogram of md_earn_wne_p10  -- use the hist()
## what does the distribution look like?
detach(college)
hist(college$md_earn_wne_p10, breaks = 30)

## Let's analyze the relationship between predictor(s) and response
## scatter plot - use the plot(x,y)
## what kind of relationship do they have?
plot(college$Cost4_A, college$md_earn_wne_p10)

## Start a Linear Regression Model
## object = lm(y ~ x, data = yourdatasetname)
## object = reg1
## summary()

## What is the estimate of the slope?
options(scipen = 999) ## gets rid of exponential notation

reg1 = lm(md_earn_wne_p10 ~ Cost4_A, data = college)
summary(reg1)


## Interpretations:

#* Slope:
#* As the cost of college increases by $1, then (on average, we predict, the mean, the expected)
#* the earnings will increase by 48c
#* 
#* Y-intercept:
#* For a cost of college of $0, then the (average, expected, predicted) earnings is $24138.03


## We saved the regression results into the reg1 object

## what's inside of reg1?
names(reg1)

## let's get the coefficients
reg1$coefficients

## What is the residual (error) for the obs 3?
reg1$residuals[3]
# That the prediction for obs 3 is off by $8373.622

# predict function (you can predict a specific value using the predict function as below:)
predict(reg1, data.frame(Cost4_A = 11540))

## The predicted are called fitted.values
reg1$fitted.values[3]

## Actual
college$md_earn_wne_p10[3]

# We need to a metric for measuring performance.
sum(reg1$residuals)

# Get SSE using anova(reg1)
anova(reg1)
sum(reg1$residuals^2)

## Matrices
X = model.matrix(reg1)
head(X)
y = college$md_earn_wne_p10

# b = (X'X)^-1 (X'y) --- results in the lowest possible SSE
b = solve(t(X) %*% X) %*% (t(X) %*% y)


## The regression line

plot(college$Cost4_A, college$md_earn_wne_p10)

## use abline to plot the line
abline(reg1, col = 'red', lw = 3)


## Assumptions

## 1) mean(epsilon) = 0
#* epsilon is a parameter
#* We do not know what is epsilon
#* we can the residuals (e) and form a guess of how epsilon works

sum(reg1$residuals)
mean(reg1$residuals)

## 2) var(epsilon) is constant across all values of x
#* variability seems to be increasing as the cost of college increases

## 3) epsilon is distributed as normal
hist(reg1$residuals, breaks = 30) ## might not give the whole picture

## QQ-Plot
qqnorm(reg1$residuals)
qqline(reg1$residuals)

## overall, mostly normal, but some departures to normality.













