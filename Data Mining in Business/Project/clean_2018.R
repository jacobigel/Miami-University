# ctrl + shift + C comments out large chunks of code
setwd('/Users/jacobigel/Desktop/School/ISA 491/Project')
source("/Users/jacobigel/Desktop/School/ISA 491/data summary.R")
library(tidyverse)
library(caret)
library(fastDummies)
library(DataExplorer)
library(lubridate)
library(lares)

domestic <- read.csv("domestic_data.csv")
domestic_2018 <- read.csv("updated_domestic_2018.csv") # do not need to do anything with right now
# introduce(domestic_2018)
# plot_missing(domestic_2018)
# data.summary(domestic_2018)

# 2005, 2006, 2009, 2010 were all years that Miami admission was not "normal"
# so because of that we want to consolidate the data to the "Normal" years of 
# operation. 

# We are using DateFrom to remove these dates instead of DataFrom since it 
# ranges from 2005 - 2017 instead of 2006 - 2015. They are the exact same variable
# Keep Date From

# domestic_2018 <- filter(domestic_2018, (DateFrom != "2005"))
# domestic_2018 <- filter(domestic_2018, (DateFrom != "2006"))
# domestic_2018 <- filter(domestic_2018, (DateFrom != "2009"))
# domestic_2018 <- filter(domestic_2018, (DateFrom != "2010"))

# With these variables removed, we now have 9 "Normal" years that we want to 
# compare to 2018 since it is the most recent information that we have. 
# Along those lines, we want to use 2018 as a sort of "base line" for which
# variables we find important or not


# In-Class ----------------------------------------------------------------

# correlation plot
# nums <- unlist(lapply(domestic_2018, is.numeric))
# M <- as.data.frame(domestic_2018[,nums])
# corr_cross(M, max_value = 0.05, top = 10)


# Variables to get rid of -------------------------------------------------
#KEEP DATE FROM

# Most of these variables are being dropped due to the large proportion of
# missing values that they have

domestic_2018 <-select(domestic_2018, -starts_with("TIB"), -starts_with("TOEFL"),
                       -starts_with("IELTS"), -starts_with("ACTMax"), -starts_with("TCP"),
                       -"Tag",-"InternationalFlag",-"SAT.R.ERW", -"SAT.R.Math", -"ACTWritingMax", 
                       -"GPAScale")



# Taking these out since there is about 70% missing and we feel as if 
# these would be difficult to impute with that amount missing
domestic_2018 <- select(domestic_2018, -starts_with("SAT"))




# Dummy Variables ---------------------------------------------------------
library(fastDummies)
domestic_2018 <-dummy_columns(domestic_2018, select_columns = c("AlumniConnection","Division"
                                                      ,"Major", "Status", "StateResidency",
                                                      "ApplicationType", "SpecialConsideration",
                                                      "Question", "Decision", "DecisionType",
                                                      "Harrison", "HsType", "ON",
                                                      "VisaType", "MiamiRanks"), 
                         remove_first_dummy = TRUE,
                         remove_selected_columns = TRUE)



# Getting Rid of More Variables --------------------------------------------
#if the missing values are over 61.09% then we are going to get rid of them
df <- domestic_2018[colSums(is.na(domestic_2018))/nrow(domestic_2018) > .6109]

domestic_2018 <-select(domestic_2018, -"EER", -starts_with("ApplicationDate"), 
                       -"DecisionDate", -"ACTChoice",
                       -"DisciplinaryQuestion1", -"Housing", -ends_with("_Race"), -"Bridges", -starts_with("CEEB"),-starts_with("Zip"),
                       -"Special.Consideration",-"GPAOrig", -"Parent.1.Education.Level",
                       -"Parent.2.Educational.Level",-"Hispanic",
                       -starts_with("SpecialConsideration_"), -starts_with("Question_"),
                       -starts_with("Harrison_"), -"FirstGen",
                       -"Race")

# data.summary(domestic_2018)
# plot_missing(domestic_2018)
#sapply(domestic_2018, function(x) sum(is.na(x)))

# prop.table(table(domestic_2018$ACTBest))
# prop.table(table(domestic_2018$ACTComposite))

# summary(df)

# Imputation --------------------------------------------------------------
df2 <- domestic_2018[colSums(is.na(domestic_2018))/nrow(domestic_2018) > .1594]

for(i in 1:ncol(domestic_2018)) {
  domestic_2018[ , i][is.na(domestic_2018[ , i])] <- median(domestic_2018[ , i], na.rm=TRUE)
}

#plot_missing(domestic_2018)

df3 <- domestic_2018[colSums(is.na(domestic_2018))/nrow(domestic_2018) > .1156]

domestic_2018 <-select(domestic_2018, -"HighSchoolCode", -"Citizen", -"OneRace", -"ACEFlag", -"MCFlag",
                       -"SuppMajor2")



# Fixing Race -------------------------------------------------------------

domestic_2018[domestic_2018 == "AI"] <- "American Indian or Alaska Native"
domestic_2018[domestic_2018 == "AS"] <- "Asian"
domestic_2018[domestic_2018 == "HS"] <- "Hispanic/Latino"
domestic_2018[domestic_2018 == "MR"] <- "Multi Racial"
domestic_2018$FullRace[domestic_2018$FullRace == "NC"] <- "Multi Racial"
domestic_2018[domestic_2018 == "PI"] <- "Native Hawaiian or Other Pacific Islander"
domestic_2018[domestic_2018 == "SortOfIntl"] <- "Non-Resident Alien"
domestic_2018[domestic_2018 == "Two or more races"] <- "Multi Racial"
domestic_2018[domestic_2018 == "UK"] <- "Unknown"
domestic_2018[domestic_2018 == "BL"] <- "Black or African American"
domestic_2018[domestic_2018 == "WH"] <- "White"
domestic_2018$FullRace[domestic_2018$FullRace == "1"] <- "American Indian or Alaska Native"
domestic_2018$FullRace[domestic_2018$FullRace == "2"] <- "Asian"
domestic_2018$FullRace[domestic_2018$FullRace == "6"] <- "Hispanic/Latino"
domestic_2018$FullRace[domestic_2018$FullRace == "7"] <- "Multi Racial"
domestic_2018$FullRace[domestic_2018$FullRace == "7"] <- "Multi Racial"
domestic_2018$FullRace[domestic_2018$FullRace == "4"] <- "Native Hawaiian or Other Pacific Islander"
domestic_2018$FullRace[domestic_2018$FullRace == "9"] <- "Non-Resident Alien"
domestic_2018$FullRace[domestic_2018$FullRace == "7"] <- "Multi Racial"
domestic_2018$FullRace[domestic_2018$FullRace == "8"] <- "Unknown"
domestic_2018$FullRace[domestic_2018$FullRace == "3"] <- "Black or African American"
domestic_2018$FullRace[domestic_2018$FullRace == "5"] <- "White"
domestic_2018[domestic_2018 == "Hispanic/Latino, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Asian, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Black or African American, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "American Indian or Alaska Native, Hispanic/Latino, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "American Indian or Alaska Native, Black or African American"] <- "Multi Racial"
domestic_2018[domestic_2018 == "American Indian or Alaska Native, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Asian, Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Black or African American, Hispanic/Latino"] <- "Multi Racial"
domestic_2018[domestic_2018 == "American Indian or Alaska Native, Asian, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Asian, Hispanic/Latino"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Black or African American, Hispanic/Latino, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Black or African American, Hispanic/Latino, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "American Indian or Alaska Native, Hispanic/Latino"] <- "Multi Racial"
domestic_2018[domestic_2018 == "American Indian or Alaska Native, Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Asian, Native Hawaiian or Other Pacific Islander"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Hispanic/Latino, Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Asian, Hispanic/Latino, Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "American Indian or Alaska Native, Asian, Black or African American"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Asian, Black or African American, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Black or African American, Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Asian, Black or African American"] <- "Multi Racial"
domestic_2018[domestic_2018 == "American Indian or Alaska Native, Black or African American, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "Asian, Hispanic/Latino, White"] <- "Multi Racial"
domestic_2018[domestic_2018 == "NA"] <- NA
domestic_2018[domestic_2018 == "ASWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "ASWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "HSWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "BLWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIHSWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIBLWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "PIWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "ASPI"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIAS"] <- "Multi Racial"
domestic_2018[domestic_2018 == "ASHSWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "BLHSWH"] <- "Multi Racial"
domestic_2018$FullRace[domestic_2018$FullRace == "PR"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIBLHS"] <- "Multi Racial"
domestic_2018[domestic_2018 == "MAWH"] <- "Multi Racial"
domestic_2018$FullRace[domestic_2018$FullRace == "MA"] <- "Multi Racial"
domestic_2018[domestic_2018 == "ASHS"] <- "Multi Racial"
domestic_2018[domestic_2018 == "ASPIWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIHS"] <- "Multi Racial"
domestic_2018[domestic_2018 == "BLHS"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIMAWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "ASBLWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "PRWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIASMA"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIASWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "ASBL"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIBL"] <- "Multi Racial"
domestic_2018[domestic_2018 == "BLPR"] <- "Multi Racial"
domestic_2018[domestic_2018 == "ASHSPIWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIBLHSWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIASBLWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "BLPRWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "MAPI"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIASBL"] <- "Multi Racial"
domestic_2018[domestic_2018 == "ASBLPIWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "AIPIWH"] <- "Multi Racial"
domestic_2018[domestic_2018 == "ASBLHS"] <- "Multi Racial"


# Fixing Major ------------------------------------------------------------

domestic_2018[domestic_2018 == "00US"] <- "ASU1"
domestic_2018[domestic_2018 == "ASU2"] <- "ASU1"
domestic_2018[domestic_2018 == "ASU3"] <- "ASU1"
domestic_2018[domestic_2018 == "ASU4"] <- "ASU1"
domestic_2018[domestic_2018 == "ASUS"] <- "ASU1"
domestic_2018[domestic_2018 == "AP71"] <- "RC71"
domestic_2018[domestic_2018 == "AP72"] <- "AS72"
domestic_2018[domestic_2018 == "AS74"] <- "EA74"
domestic_2018[domestic_2018 == "AP87"] <- "RC87"
domestic_2018[domestic_2018 == "AP88"] <- "RC88"
domestic_2018[domestic_2018 == "APAN"] <- "ASAN"
domestic_2018[domestic_2018 == "BUAN"] <- "ASAN"
domestic_2018[domestic_2018 == "EAAN"] <- "ASAN"
domestic_2018[domestic_2018 == "FAAN"] <- "ASAN"
domestic_2018[domestic_2018 == "RCAN"] <- "ASAN"
domestic_2018[domestic_2018 == "BUEB"] <- "RCEB"
domestic_2018[domestic_2018 == "ASEN"] <- "APEN"
domestic_2018[domestic_2018 == "BUEN"] <- "APEN"
domestic_2018[domestic_2018 == "EAEN"] <- "APEN"
domestic_2018[domestic_2018 == "FAEN"] <- "APEN"
domestic_2018[domestic_2018 == "RCEN"] <- "APEN"
domestic_2018[domestic_2018 == "0056"] <- "00UH"
domestic_2018[domestic_2018 == "RCEN"] <- "APEN"
domestic_2018[domestic_2018 == "APSH"] <- "APCH"
domestic_2018[domestic_2018 == "ASEP"] <- "BUEP"
domestic_2018[domestic_2018 == "EAEP"] <- "BUEP"
domestic_2018[domestic_2018 == "FAEP"] <- "BUEP"
domestic_2018[domestic_2018 == "APEP"] <- "BUEP"
domestic_2018[domestic_2018 == "AS76"] <- "APES"
domestic_2018[domestic_2018 == "ASES"] <- "APES"
domestic_2018[domestic_2018 == "BUES"] <- "APES"
domestic_2018[domestic_2018 == "EAES"] <- "APES"
domestic_2018[domestic_2018 == "FAES"] <- "APES"
domestic_2018[domestic_2018 == "IS76"] <- "APES"
domestic_2018[domestic_2018 == "ISES"] <- "APES"
domestic_2018[domestic_2018 == "RCES"] <- "APES"
domestic_2018[domestic_2018 == "RCET"] <- "APET"
domestic_2018[domestic_2018 == "RCHT"] <- "APHT"
domestic_2018[domestic_2018 == "ASIM"] <- "APIM"
domestic_2018[domestic_2018 == "BUIM"] <- "APHT"
domestic_2018[domestic_2018 == "EAIM"] <- "APHT"
domestic_2018[domestic_2018 == "FAIM"] <- "APHT"
domestic_2018[domestic_2018 == "RCIM"] <- "APHT"
domestic_2018[domestic_2018 == "APIM"] <- "APHT"
domestic_2018[domestic_2018 == "ASIM"] <- "APHT"
domestic_2018[domestic_2018 == "RCK3"] <- "BUK3"
domestic_2018[domestic_2018 == "RCKA"] <- "BUKA"
domestic_2018[domestic_2018 == "RCKM"] <- "BUKM"
domestic_2018[domestic_2018 == "ASPM"] <- "APPM"
domestic_2018[domestic_2018 == "BUPM"] <- "APPM"
domestic_2018[domestic_2018 == "EAPM"] <- "APPM"
domestic_2018[domestic_2018 == "FAPM"] <- "APPM"
domestic_2018[domestic_2018 == "RCPM"] <- "APPM"
domestic_2018[domestic_2018 == "ASRT"] <- "APRT"
domestic_2018[domestic_2018 == "ASSU"] <- "APSU"
domestic_2018[domestic_2018 == "BUSU"] <- "APSU"
domestic_2018[domestic_2018 == "EASU"] <- "APSU"
domestic_2018[domestic_2018 == "FASU"] <- "APSU"
domestic_2018[domestic_2018 == "RCSU"] <- "APSU"
domestic_2018[domestic_2018 == "EASW"] <- "ASSW"
domestic_2018[domestic_2018 == "BU15"] <- "AS15"
domestic_2018[domestic_2018 == "RC50"] <- "BU50"
domestic_2018[domestic_2018 == "EA21"] <- "AS21"
domestic_2018[domestic_2018 == "EA21"] <- "AS21"
domestic_2018[domestic_2018 == "EA25"] <- "AS25"
domestic_2018[domestic_2018 == "EA35"] <- "AS35"
domestic_2018[domestic_2018 == "EA45"] <- "AS45"
domestic_2018[domestic_2018 == "EA46"] <- "AS46"
domestic_2018[domestic_2018 == "EA52"] <- "AS52"
domestic_2018[domestic_2018 == "FA86"] <- "AS86"
domestic_2018[domestic_2018 == "EA97"] <- "AS97"
domestic_2018[domestic_2018 == "EA67"] <- "EAGW"
domestic_2018[domestic_2018 == "RCCJ"] <- "ASCJ"
domestic_2018[domestic_2018 == "EA52"] <- "AS52"
domestic_2018[domestic_2018 == "EA93"] <- "ASEA"
domestic_2018[domestic_2018 == "EA96"] <- "EALN"
domestic_2018[domestic_2018 == "EA43"] <- "EALZ"
domestic_2018[domestic_2018 == "EA52"] <- "AS52"
domestic_2018[domestic_2018 == "FAJA"] <- "ASJA"
domestic_2018[domestic_2018 == "RCTS"] <- "APTS"
domestic_2018[domestic_2018 == "EA52"] <- "RCSU"
domestic_2018[domestic_2018 == "ASSU"] <- "APSU"
domestic_2018[domestic_2018 == "RCPC"] <- "APPC"

# Variables to edit/relevel -----------------------------------------------

domestic_2018$Citizenship[domestic_2018$Citizenship==""]<-"US"
domestic_2018$Citizenship2[domestic_2018$Citizenship2==""]<-"US"


# Fixes -------------------------------------------------------------------

# plot_missing(domestic_2018)
# plot_bar(domestic_2018) 
# plot_histogram(domestic_2018)

# CountyDesc: 1119 categories
# CountyCode: 631 categories
# FullRace: 74 categories
# HighSchoolState: 69 categories
# SuppMajor1: 250 categories
# SuppMajor3: 122 categories

library(fastDummies)
domestic_2018 <-dummy_columns(domestic_2018, select_columns = c(
                                                      "HighSchoolState",
                                                      "SuppMajor1","SuppMajor3", "FullRace",
                                                      "WhichTestBest", "DEC",
                                                      "Concentration"), 
                         remove_first_dummy = TRUE,
                         remove_selected_columns = TRUE)

# HomeState
df.home<-select(domestic_2018, starts_with("HomeState"))
df.home$Retained<-domestic_2018$Retained
lr.home<-glm(Retained ~., data=df.home, family="binomial")
imp.home<-names(which(coef(summary(lr.home))[,4]<0.1))
domestic_2018<-select(domestic_2018, -starts_with("HomeState"))
domestic_2018<-cbind(domestic_2018, df.home[,imp.home[-1]])


# CountyDesc
domestic_2018<-select(domestic_2018, -starts_with("CountyDesc"))

# CountyCode
domestic_2018<-select(domestic_2018, -starts_with("CountyCode"))



# FullRace
df.FR<-select(domestic_2018, starts_with("FullRace"))
df.FR$Retained<-domestic_2018$Retained
lr.FR<-glm(Retained ~., data=df.FR, family="binomial")
imp.FR<-names(which(coef(summary(lr.FR))[,4]<0.1))
domestic_2018<-select(domestic_2018, -starts_with("FullRace"))
domestic_2018<-cbind(domestic_2018, df.FR[,imp.FR[-1]])

# HighSchoolState
df.HSS<-select(domestic_2018, starts_with("HighSchoolState"))
df.HSS$Retained<-domestic_2018$Retained
lr.HSS<-glm(Retained ~., data=df.HSS, family="binomial")
imp.HSS<-names(which(coef(summary(lr.HSS))[,4]<0.1))
domestic_2018<-select(domestic_2018, -starts_with("HighSchoolState"))
domestic_2018<-cbind(domestic_2018, df.HSS[,imp.HSS[-1]])

# SuppMajor1
df.SM1<-select(domestic_2018, starts_with("SuppMajor1"))
df.SM1$Retained<-domestic_2018$Retained
lr.SM1<-glm(Retained ~., data=df.SM1, family="binomial")
imp.SM1<-names(which(coef(summary(lr.SM1))[,4]<0.1))
domestic_2018<-select(domestic_2018, -starts_with("SuppMajor1"))
domestic_2018<-cbind(domestic_2018, df.SM1[,imp.SM1[-1]])

# SuppMajor3
df.SM3<-select(domestic_2018, starts_with("SuppMajor3"))
df.SM3$Retained<-domestic_2018$Retained
lr.SM3<-glm(Retained ~., data=df.SM3, family="binomial")
imp.SM3<-names(which(coef(summary(lr.SM3))[,4]<0.1))
domestic_2018<-select(domestic_2018, -starts_with("SuppMajor3"))
domestic_2018<-cbind(domestic_2018, df.SM3[,imp.SM3[-1]])

domestic_2018 <-select(domestic_2018, -"AlumniConnection_D - Father, Sibling",-starts_with("Major_"),
                  -"Decision_", -"DecisionType_DN",-"DecisionType_DQ",-"DecisionType_HY",-"DecisionType_SY", -starts_with("AlumniConnection_B"))



domestic_2018 <-select(domestic_2018, -"HighSchoolState_DE",-"HighSchoolState_WV")




domestic_2018$ConfirmCode[domestic_2018$ConfirmCode==""]<-"N"
domestic_2018$WhichTestBest[domestic_2018$WhichTestBest==""]<-"NO TEST"

# domestic_2018$Retained[domestic_2018$Retained == "1"] <- "No"
# domestic_2018$Retained[domestic_2018$Retained == "0"] <- "Yes"
prop.table(table(domestic_2018$Retained))

domestic_2018 <- select(domestic_2018, -"Citizenship")

domestic_2018 <- select(domestic_2018, -"Concentration_VO",-"Concentration_SI",-"Concentration_SH",
                   -"Concentration_SG",-"Concentration_SF",-"Concentration_SE",
                   -"Concentration_SD",-"Concentration_M2",-"Concentration_HB",
                   -"Concentration_EL",-"Concentration_84",-"Concentration_IN")






domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="Multi Racial"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="Asian"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="Black or African American"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="Hispanic/Latino"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="American Indian or Alaska Native"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="MA"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="PR"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="Native Hawaiian or Other Pacific Islander"]<-"Non-White"


# plot_missing(domestic_2018)
# plot_bar(domestic_2018)
# plot_histogram(domestic_2018)


# dont do a standalone tree
# lr<-glm(Retained ~., data=domestic, family="binomial")
# imp<-names(which(coef(summary(lr))[,4]<0.2))

# RDS File ----------------------------------------------------------------

#saveRDS(domestic, "ISA491Project_clean3.RDS")

domestic <- readRDS("ISA491Project_clean2.RDS")
xgboost <- readRDS("xgboost_final2.rds")

training <- select(training, -"ConfirmCode", -"RankPercent", -"AlmostFullRace", -"ConCode", -"StudentType", -"AlumniConnection_F",
                   -"AlumniConnection_M",-"AlumniConnection_O", -"AlumniConnection_S", -"AlumniConnection_NA", -"Division_AP",
                    -"Division_AS",-"Division_BU",-"Division_CAS",-"Division_CEHS",-"Division_EA",-"Division_FA",
                    -"Status_E", -"DecisionType_K", -"DecisionType_NA", -starts_with("HsType_"), -starts_with("ON_"),
                    -"MiamiRanks_1",-"MiamiRanks_2",-"MiamiRanks_NA",-starts_with("WhichTestBest"), -starts_with("SuppMajor"),
                   -"MiamiRanks_noFAFSA")

p <- predict(xgboost, newdata = domestic_2018, type = "prob")
results <- data.frame(preds = p, domestic_2018$Retained)

write.csv(results, "results.csv")

# Creating Models ---------------------------------------------------------


# library(caret)
# trainIndex<-createDataPartition(domestic$Retained, p=0.7, list=FALSE, times=1)
# head(trainIndex)
# 
# set.seed(13)
# 
# training<-domestic[trainIndex, ]
# valid<-domestic[-trainIndex, ]
# 
# #head(training[,terms])
# 
# class.tree<-rpart(Retained~., data=training,
#                   control=rpart.control(maxdepth = 30, minsplit=20, cp=0.001, xval=10),
#                   method="class", model=TRUE)
# 
# 
# # Random Forest -----------------------------------------------------------
# 
# library(ranger)
# 
# tunegrid <- expand.grid(
#   .mtry = c(4, 10, 20),
#   .splitrule = "gini",
#   .min.node.size = c(300,400,500)
# )
# 
# y<-training$Retained
# x<-select(training, -Retained)
# cl <- makePSOCKcluster(7)
# registerDoParallel(cl)
# rforest<-train(x=x, y=y, method="ranger", tuneGrid=tunegrid, metric="ROC",
#                num.trees=1000, importance="impurity", trControl=ctrl )
# 
# 
# saveRDS(rforest, "rforest_final.RDS")
# rforest
# 
# 
# p.rforest.t<-predict(rforest, data=training, type="prob")
# rt<-roc(training$Retained,  p.rforest.t[,2])
# r.rforest.auc.t<-rt$auc
# r.rforest.auc.t
# 
# p.rforest<-predict(rforest, newdata = valid, type="prob")
# r<-roc(valid$Retained,  p.rforest[,2])
# r.rforest.auc<-r$auc
# r.rforest.auc
# 
# # Boosted Tree ------------------------------------------------------------
# 
# 
# set.seed(13)
# 
# Grid <- expand.grid( n.trees = seq(100,300,100),
#                      interaction.depth = c(20, 40),
#                      shrinkage = c(0.1, 0.01),
#                      n.minobsinnode=c(50))
# 
# cl <- makePSOCKcluster(7) #starts the cluster
# registerDoParallel(cl)
# 
# gb.tree <- train(Retained~., 
#                  data=training, 
#                  method = 'gbm', 
#                  trControl=ctrl, 
#                  tuneGrid=Grid, 
#                  metric='ROC')
# 
# stopCluster(cl)
# 
# saveRDS(gb.tree, "gbtree_final.RDS")
# 
# gb.tree
# 
# p.gbtree<-predict(gb.tree, data=training, type="prob")
# rt<-roc(training$Retained,  p.gbtree[,2])
# r.gbtree.auc.t<-rt$auc
# r.gbtree.auc.t
# 
# p.gbtree<-predict(gb.tree, newdata=valid, type="prob")
# r<-roc(valid$Retained,  p.gbtree[,2])
# r.gbtree.auc<-r$auc
# r.gbtree.auc
# 
# # XGBoost -----------------------------------------------------------------
# 
# XGrid <-  expand.grid(nrounds = 200,
#                       max_depth = c(6,12),
#                       eta = c(0.001,0.1),
#                       gamma = c(0.5, 0.75),
#                       colsample_bytree = c(0.3, 1),
#                       min_child_weight = c(0,30),
#                       subsample = c(0.3,1)
# )
# cl <- makePSOCKcluster(7) #starts the cluster
# registerDoParallel(cl)
# 
# xgboost <- train(Retained~., 
#                  data = training,
#                  method = "xgbTree",
#                  trControl=ctrl, 
#                  tuneGrid=XGrid, 
#                  metric='ROC')
# 
# stopCluster(cl)
# 
# saveRDS(xgboost, "xgboost_final.RDS")
# 
# xgboost
# 
# p.xgboost<-predict(xgboost, data=training, type="prob")
# rt<-roc(training$Retained,  p.xgboost[,2])
# r.xgboost.auc.t<-rt$auc
# r.xgboost.auc.t
# 
# p.xgboost<-predict(xgboost, newdata=valid, type="prob")
# r<-roc(valid$Retained,  p.xgboost[,2])
# r.xgboost.auc<-r$auc
# r.xgboost.auc
