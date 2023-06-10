## normal plot for saturated models

library(DoE.base)

df<-read.csv("I:\\Classes\\ISA 365\\Datasets\\Datasets\\Chapter 5_Data\\CreditCard1.csv")
reg<-lm(resprate~price*promo*duration, data=df)
hncoeff<-halfnormal(reg)$coef
pse<-ME.Lenth(hncoeff)$PSE
abline(a=0, b=1/pse)

## this gets all the points to be labeled by cheating and making alpha really large
hncoeff<-halfnormal(reg, alpha=0.95)$coef
pse<-ME.Lenth(hncoeff)$PSE
abline(a=0, b=1/pse)


#you can view a big interaction plot to get an idea of what is going on
library(FrF2)
IAPlot(reg)

#fit the reduced model
reg2<-lm(resprate~price+promo+duration+price:duration, data=df)
summary(reg2)

#check assumptions
plot(reg2$residuals, reg2$fitted.values) #check for a pattern
plot(reg2$residuals) #check for a trend
qqnorm(reg2$residuals) #check for normality
qqline(reg2$residuals)

#interaction plot
library(sjPlot)
plot_model(reg2, type=c("int"))


#main effects plot
library(FrF2)
MEPlot(reg2)


#more interaction plots
library(FrF2)
IAPlot(reg2)



