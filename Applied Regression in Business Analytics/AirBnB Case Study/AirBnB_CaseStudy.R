setwd("~/Desktop/School/ISA 291")

## Read the AirBnB dataset
airbnb = read.csv('airbnb_training.csv', stringsAsFactors = T)
airbnb

s
## Structure the dataset
str(airbnb)


## Response price
#* price per night
hist(airbnb$price, breaks = 100)

## Transformation of price
## Natural log transformation
## Log turns right skewed data into a normal distribution
airbnb$logprice = log(airbnb$price)

hist(airbnb$logprice,breaks = 30)
## One of the drawbacks of using the log price as a response
## is that the units are now changed
#* to undo the natrual log transformation you need to raise the estimate to 
#* the power of e
#* For example, if you get an estimate of 4.5
#* exp(4.5)

#* The log10 transformation
#* Log base 10 transformation
airbnb$log10price = log10(airbnb$price)
hist(airbnb$log10price, breaks = 30)


## Removing lodgings with Price = $0
airbnb = airbnb[which(airbnb$price!=0),]

## Check levels 
levels(airbnb$neighbourhood_group)

## Create a regression to predict price using neighbourhood group
reg1 = lm(price ~ neighbourhood_group, data = airbnb)
summary(reg1)
# price for lodging in Manhattan --> 111.079 + 87.124 = 198.203

## room_type
levels(airbnb$room_type)

## Create a regression with two predictors
reg2 = lm(price ~ neighbourhood_group + room_type, data = airbnb)
summary(reg2)
anova(reg2)

#neighbourhood_group contributes 4 DF

## Relevel the variable
## lets set the 'Shared Room' to be the base or reference level
airbnb$room_type = relevel(airbnb$room_type, ref = "Shared room")
levels(airbnb$room_type)

## The Estimated price for an entire home/apt in the Bronx $160.9222 (from reg 1)
# in reg2:

135.1988 + 25.7235
summary(reg2)
## Regression #3
#* Interaction: neighbourhood_group:room_type (multiplication of the two)
reg3 = lm(price ~ neighbourhood_group + room_type + 
            neighbourhood_group:room_type, data = airbnb)
summary(reg3)
anova(reg3)

# whats the estimated price of a private room in queens?
68.3571 + 0.2026 + -5.9580 + 11.0213
# = 73.623

#* y-intercept: 68.3571
#* This is the estimated price of an AirBnB:
#* In the Bronx
#* Shared Room

reg4 = lm(price ~ neighbourhood_group + room_type + minimum_nights +
            minimum_nights:neighbourhood_group, data = airbnb)
summary(reg4)
anova(reg4)

## y-intercept
## Estimated price of AirBnB
#*In the Bronx
#*Shared Room
#*Minimum Nights = 0


## Not asking for slope anymore
#* Asking for the effect of changing the minimum nights
#* If we increase the min nights by 1
#* what happens to the price?
#* 
#* the effect of min nights depends on the neighborhood
#* -0.3932 is the change in the price, holding everything else constant,
#* in the bronx

-0.3932 +
  0.5740*neighbourhood_groupBrooklyn +
  0.6478*neighbourhood_groupManhattan +
  2.5651*neighbourhood_groupQueens +
  1.5700*neighbourhood_groupStaten Island
