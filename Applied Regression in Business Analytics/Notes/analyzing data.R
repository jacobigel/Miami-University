setwd("~/Desktop/School/ISA 291")

#Read Data
dir()

WP50 = read.table("WPOWER50.txt", header = TRUE, sep = '\t', stringsAsFactors = TRUE)

# WP50
class(WP50)

# ACCESS VARIABLES
WP50$AGE

# printing some observations to chack the dataset
head(WP50)
head(WP50,10)

tail(WP50)
tail(WP50,10)

# Analyze the variable AGE
WP50$AGE

## What is the average executive age?
mean(WP50$AGE)

# median 
median(WP50$AGE)


# Plots

# which plot is approproate for the variable age?
# a) Histogram (yes)
# b) bar chart (no, this is for categorical variables)
# c) scatter plot (no, this is for variables pairs)
# d) box plot (yes)


# histogram
hist(WP50$AGE)

# option main for title
hist(WP50$AGE, main = "Histogram of Age")
hist(WP50$AGE, main = "Histogram of Age", xlab = "AGE")
hist(WP50$AGE, main = "Histogram of Age", xlab = "AGE", col = "light blue")

# boxplot
boxplot(WP50$AGE)

# Categorical Variables
print(WP50$TITLE)
levels(WP50$TITLE)

# table() prints a summary
table(WP50$TITLE)

# barplot() needs GROUPED by category data
mytable = table(WP50$TITLE)
barplot(mytable)

# SUBSETTING OBSERVATIONS

# BY INDEX
# dataset[row,variables/columns]

# Print the second column
WP50[,2]


# Print obs number 10
WP50[10,]


# What is the name of the executive in obs 43
WP50[43,]

## SLICING
# dataset[from_row:to_row, from_col:to_col]

# Let's print obs from 5 to 10 and variables 1 to 3
WP50[5:10,1:3]
WP50[5:10,1:3]
WP50[,1:3]

# PRACTICE
# What are the ages of executives on obs 25 to 27?
WP50[25:27,3]

# SPECIFIC SELECTION
# WP50[c(obs1, obs7, ...),c(...)]

# print obs 10 and 20 (all vars)
WP50[c(10,20), ]

# SUBSETTING
# subset(dataframe, condition)
# e,g, WP50$AGE < 40
# WP50$AGE == 40

# print the executives less than 50
subset(WP50, WP50$AGE < 50)

# print the executives less than 40
WP50_LESS40 = subset(WP50, WP50$AGE < 40)

WP50_LESS40


# PRACTICE
table(WP50$TITLE)

# What is the name and age of the only exec with COO title?

subset(WP50, WP50$TITLE == 'COO')

# READ CSV FILES

hospital = read.csv("https://instruction.bus.wisc.edu/jfrees/jfreesbooks/regression%20modeling/bookwebdec2010/CSVData/HospitalCosts.csv", stringsAsFactors = T)


# str() function
str(hospital)

plot(hospital$LOS, hospital$TOTCHG)
