# ctrl + shift + C comments out large chunks of code
setwd('/Users/jacobigel/Desktop/School/ISA 491/Project')
source("/Users/jacobigel/Desktop/School/ISA 491/data summary.R")
library(tidyverse)
library(caret)
library(fastDummies)
library(DataExplorer)
library(lubridate)
library(lares)

readRDS("ISA491Project_clean.RDS")

domestic <- read.csv("domestic_data.csv")
domestic_2018 <- read.csv("updated_domestic_2018.csv") 
# introduce(domestic)
# plot_missing(domestic)
# data.summary(domestic)

# 2005, 2006, 2009, 2010 were all years that Miami admission was not "normal"
# so because of that we want to consolidate the data to the "Normal" years of 
# operation. 

# We are using DateFrom to remove these dates instead of DataFrom since it 
# ranges from 2005 - 2017 instead of 2006 - 2015. They are the exact same variable
# Keep Date From

domestic_2018 <- filter(domestic_2018, (DateFrom != "2005"))
domestic_2018 <- filter(domestic_2018, (DateFrom != "2006"))
domestic_2018 <- filter(domestic_2018, (DateFrom != "2009"))
domestic_2018 <- filter(domestic_2018, (DateFrom != "2010"))

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
domestic_2018 <-dummy_columns(domestic_2018, select_columns = c("Division"
                                                      ,"Major", "Status", "StateResidency",
                                                      "ApplicationType", "SpecialConsideration",
                                                      "Question", "Decision", "DecisionType",
                                                      "Harrison", "HsType", "ON",
                                                      "VisaType", "MiamiRanks", "AlumniConnection"), 
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
sapply(domestic_2018, function(x) sum(is.na(x)))

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

#plot_missing(domestic_2018)


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

domestic_2018$Citizenship[domestic_2018$Citizenship=="PR"]<-"Non-Citizen"


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






# CountyDesc
domestic_2018<-select(domestic_2018, -starts_with("CountyDesc"))

# CountyCode
domestic_2018<-select(domestic_2018, -starts_with("CountyCode"))



# FullRace
df.FR<-select(domestic_2018, starts_with("FullRace"))
df.FR$retained<-domestic$retained
lr.FR<-glm(retained ~., data=df.FR, family="binomial")
imp.FR<-names(which(coef(summary(lr.FR))[,4]<0.1))
domestic_2018<-select(domestic_2018, -starts_with("FullRace"))
domestic_2018<-cbind(domestic_2018, df.FR[,imp.FR[-1]])


# HighSchoolState
df.HSS<-select(domestic_2018, starts_with("HighSchoolState"))
df.HSS$retained<-domestic$retained
lr.HSS<-glm(retained ~., data=df.HSS, family="binomial")
imp.HSS<-names(which(coef(summary(lr.HSS))[,4]<0.1))
domestic_2018<-select(domestic_2018, -starts_with("HighSchoolState"))
domestic_2018<-cbind(domestic_2018, df.HSS[,imp.HSS[-1]])

# SuppMajor1
df.SM1<-select(domestic_2018, starts_with("SuppMajor1"))
df.SM1$retained<-domestic_2018$retained
lr.SM1<-glm(retained ~., data=df.SM1, family="binomial")
imp.SM1<-names(which(coef(summary(lr.SM1))[,4]<0.1))
domestic_2018<-select(domestic_2018, -starts_with("SuppMajor1"))
domestic_2018<-cbind(domestic_2018, df.SM1[,imp.SM1[-1]])

# SuppMajor3
df.SM3<-select(domestic_2018, starts_with("SuppMajor3"))
df.SM3$retained<-domestic_2018$retained
lr.SM3<-glm(retained ~., data=df.SM3, family="binomial")
imp.SM3<-names(which(coef(summary(lr.SM3))[,4]<0.1))
domestic_2018<-select(domestic_2018, -starts_with("SuppMajor3"))
domestic_2018<-cbind(domestic_2018, df.SM3[,imp.SM3[-1]])

domestic_2018 <-select(domestic_2018, -"AlumniConnection_D",-"AlumniConnection_D - Father, Sibling",-starts_with("Major_"), -"StateResidency_Z",
                  -"Decision_", -"DecisionType_DN",-"DecisionType_DQ",-"DecisionType_E",
                  -"DecisionType_HN",-"DecisionType_HQ",-"DecisionType_HY", -"DecisionType_KN",
                  -"DecisionType_KQ",-"DecisionType_KY",-"DecisionType_N",
                  -"DecisionType_SN",-"DecisionType_SQ",-"DecisionType_SY", -starts_with("AlumniConnection_B"))


#plot_missing(domestic_2018)


domestic_2018 <-select(domestic_2018, -"MiamiRanks_9", -"MiamiRanks_10", -"MiamiRanks_S",
                  -"HighSchoolState_AR", -"HighSchoolState_DE", -"HighSchoolState_OR", -"MiamiRanks_8",
                  -"MiamiRanks_7", -"MiamiRanks_6", -"MiamiRanks_5", -"ON_8",
                  -"ON_7", -"ON_6", -"ON_5", -"HsType_Unknown", -"HsType_Private Secular", -"HsType_Home School"
                  , -"HsType_Charter", -"HsType_4", -"DecisionType_S", -"ApplicationType_OI", -"HsType_Religious"
                  , -"Division_CCA", -"AlumniConnection_M - Mother", -"AlumniConnection_F - Father", -"AlumniConnection_C - Mother, Sibling"
                  , -"AlumniConnection_C", -"AlumniConnection_A", -"Citizenship2", -"AlumniConnection_A - Mother, Father, Sibling", -"MiamiRanks_4")


domestic_2018 <-select(domestic_2018, -"SuppMajor3_AP56", -"SuppMajor3_AS47", -"SuppMajor3_AS86", -"SuppMajor3_ASBC"
                  , -"SuppMajor3_ASBP" , -"SuppMajor3_ASEV", -"SuppMajor3_ASIN", -"SuppMajor3_ASJN", -"SuppMajor3_ASSW", -"SuppMajor3_ASU1", -"SuppMajor3_BU01"
                  , -"SuppMajor3_BUIB", -"SuppMajor3_BUIS", -"SuppMajor3_EA56", -"SuppMajor3_EAGA", -"SuppMajor3_FA03", -"SuppMajor3_FA39")


domestic_2018$ConfirmCode[domestic_2018$ConfirmCode==""]<-"N"
domestic_2018$WhichTestBest[domestic_2018$WhichTestBest==""]<-"NO TEST"

domestic_2018$retained[domestic_2018$retained == "1"] <- "No"
domestic_2018$retained[domestic_2018$retained == "0"] <- "Yes"
prop.table(table(domestic_2018$retained))


prop.table(table(domestic_2018$Citizenship))


domestic_2018 <- select(domestic_2018, -"Citizenship")

domestic_2018 <- select(domestic_2018, -"Concentration_VO",-"Concentration_SI",-"Concentration_SH",
                   -"Concentration_SG",-"Concentration_SF",-"Concentration_SE",
                   -"Concentration_SD",-"Concentration_M2",-"Concentration_HB",
                   -"Concentration_EL",-"Concentration_89",-"Concentration_84",
                   -"Concentration_76",-"Concentration_IN")



domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="Multi Racial"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="Asian"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="Black or African American"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="Hispanic/Latino"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="American Indian or Alaska Native"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="MA"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="PR"]<-"Non-White"
domestic_2018$AlmostFullRace[domestic_2018$AlmostFullRace=="Native Hawaiian or Other Pacific Islander"]<-"Non-White"


plot_missing(domestic_2018)
plot_bar(domestic_2018)
plot_histogram(domestic_2018)


# dont do a standalone tree
# lr<-glm(retained ~., data=domestic, family="binomial")
# imp<-names(which(coef(summary(lr))[,4]<0.2))

# RDS File ----------------------------------------------------------------

saveRDS(domestic, "ISA491Project_clean_2018.RDS")




# Cleaning 2018 -----------------------------------------------------------


