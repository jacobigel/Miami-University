### Jacob Igel ISA 291 A igeljj ###

## Setting the working directory
setwd("~/Desktop/School/ISA 291")

# The creation of the Blood Pressure/bp table
bp = read.table("Blood_Pressure.txt", header = TRUE, sep = '\t', stringsAsFactors = TRUE)

head(bp)


# These are the types of variables for each column including the overall data frame
class(bp)
class(bp$Drug)
class(bp$Subj)
class(bp$Gender)
class(bp$SBP)
class(bp$DBP)


## Starting Bar plots for Drugs and Gender (factor variables)

# Table and bar plot for the Drug variable
drugtable = table(bp$Drug)
barplot(drugtable)

# For the Drug bar plot:
# Shape - slightly skewed left
# Outliers - no noticeable outliers
# Spread - 19 Drug A, 19 Drug B, 16 Placebo
drugtable
# Center - 
mean(drugtable) # 18
median(drugtable) # 19

# Table and bar plot for the Gender variable
gendertable = table(bp$Gender)
barplot(gendertable)


# For the Gender bar plot:
# Shape - skewed towards the left (more female than male)
# Outliers - no noticeable outliers
# Spread - 28 F, 26 M
gendertable
# Center - 
mean(gendertable) # 27
median(gendertable) # 27


## Starting Histograms for SBP and DBP

# SBP table and histogram
sbptable = table(bp$SBP)
hist(sbptable)

## For the SBP Histogram:
# Shape - Highly skewed left with majority of data points on 1
# Outliers - no noticeable outliers
# Spread - Ranges from 1 - 6
sbptable
# Center -
mean(sbptable) # 2.571
median(sbptable) # 2

# DBP table and histogram
dbptable = table(bp$DBP)
hist(dbptable)

## For the DBP Histogram:
# Shape - Skewed left with majority of the points in the 1-2 range
# Outliers - a few outliers towards 7-10
# Spread - Ranges from 1 - 10
dbptable
# Center -
mean(dbptable) # 4.15
median(dbptable) # 3


## Creation of scatter plot of SBP and DBP
plot(bp$DBP,bp$SBP)

# Shape - no real shape or trend line, just a fair bit of scattered plots
# Outliers - No significant outliers
# Spread - there's is quite a spread all over the board on this plot
# Center - the center is between 80 and 85

## Creation of the bp_F data frame and summary

bp_F <- subset(bp, bp$Gender == "F")
data.frame(bp_F)
head(bp_F)

summary(bp_F)



