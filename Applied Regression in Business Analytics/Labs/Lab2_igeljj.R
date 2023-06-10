## Jacob Igel ISA 291 A - Lab 2
setwd("~/Desktop/School/ISA 291")
dir()

NBA = read.csv("LAB2.csv", header = TRUE, stringsAsFactors = TRUE)
NBA

# Question 1
plot(NBA$Height,NBA$Weight)
plot(NBA$Age, NBA$Weight)

## Height is the stronger predictor


options(scipen = 999) 


# Height vs Weight
whreg = lm(Weight ~ Height, data = NBA)
summary(whreg)
anova(whreg)

# Age vs Weight
ahreg = lm(Weight ~ Age, data = NBA)
summary(ahreg)
anova(ahreg)

# Predictions
predict(whreg, data.frame(Height = 70))
predict(ahreg, data.frame(Age = 21))


# beta_hat 
X = model.matrix(ahreg)
y = NBA$Weight
beta_hat = solve(t(X) %*% X) %*% (t(X) %*% y) 
beta_hat