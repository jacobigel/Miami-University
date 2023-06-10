setwd("~/Desktop/School/ISA 291")

#Importing the data and making a scatter plot with Lot.Size and Work.Hours
macys = read.table('LAB1.csv', header = T, sep = ",", stringsAsFactors = T)

plot(macys$Lot.Size,macys$Work.Hours)

# The histogram of Work.Hours
hist(macys$Work.Hours)

#The Linear Regression and summary of the regression
reg1 = lm(Lot.Size ~ Work.Hours, data = macys)

summary(reg1)

# Creating a model matrix
x = model.matrix(reg1)
x

# Creating the y vector
y = macys$Work.Hours
y
