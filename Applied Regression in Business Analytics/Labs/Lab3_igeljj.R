setwd("~/Desktop/School/ISA 291")

X = matrix(c(1,1,1,1,1,1,1,3032,22221,2058,22912,1780,21345,1638,17342,2196,21786,1966,18902,2216,18639),nrow = 7)
X
dim(X)

y = matrix(c(360000,340000,250000,205500,275500,248000,229900), nrow = 7)
print(y)
length(y)


reg1 = lm(y ~ X)

print(y)

print(X)


XTX = solve((t(X)%*% X))
print(XTX)
dim(XTX)

XTY = (t(X)%*% y)
print(XTY)
dim(XTY)

beta_hat = XTX %*% XTY
print(beta_hat)
dim(beta_hat)

summary(lm(y ~ 0+X))