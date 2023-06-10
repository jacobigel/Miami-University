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
domestic_2018 <- read.csv("domestic_2018.csv") # do not need to do anything with right now
# introduce(domestic)
# plot_missing(domestic)
# data.summary(domestic)

# 2005, 2006, 2009, 2010 were all years that Miami admission was not "normal"
# so because of that we want to consolidate the data to the "Normal" years of 
# operation. 

# We are using DateFrom to remove these dates instead of DataFrom since it 
# ranges from 2005 - 2017 instead of 2006 - 2015. They are the exact same variable
# Keep Date From

domestic <- filter(domestic, (DateFrom != "2005"))
domestic <- filter(domestic, (DateFrom != "2006"))
domestic <- filter(domestic, (DateFrom != "2009"))
domestic <- filter(domestic, (DateFrom != "2010"))

# With these variables removed, we now have 9 "Normal" years that we want to 
# compare to 2018 since it is the most recent information that we have. 
# Along those lines, we want to use 2018 as a sort of "base line" for which
# variables we find important or not


# In-Class ----------------------------------------------------------------

# correlation plot
# nums <- unlist(lapply(domestic, is.numeric))
# M <- as.data.frame(domestic[,nums])
# corr_cross(M, max_value = 0.05, top = 10)


# Variables to get rid of -------------------------------------------------
#KEEP DATE FROM

# Most of these variables are being dropped due to the large proportion of
# missing values that they have

domestic <-select(domestic, -starts_with("TIB"), -starts_with("TOEFL"),
                  -starts_with("IELTS"), -starts_with("ACTMax"), -starts_with("TCP"),
                  -"tag",-"VentureScholar", -"RoundedGPA",
                  -"HS.Code", -"Super.ACT", -"IELL", -"IELR", -"IELW", -"IELS",
                  -"IELO", -"VisaType", -"InternationalFlag", -"NatlAch", -"NatlHisp",
                  -"CanCode", -"X__1", -"FAFSA_RECV_Date", -"Which.Test", -"Language",
                  -"DEC", -"SAT.R.ERW", -"ConfirmDate", -"SAT.R.Math", -"ACTWritingMax",
                  -"CEEB5", -"AIDY_Code", -"Act25", -"Act75", -"Retained_recode",
                  -"GPAScale", -"OriginalGPA")

# Taking this out since we can just use Miami Ranks
domestic <-select(domestic, -"FirstSchool", -"SecondSchool", -"ThirdSchool",
                  -"FourthSchool", -"FifthSchool", -"SixthSchool", -"SeventhSchool",
                  -"EighthSchool", -"TenthSchool")

# Taking these out since there is about 70% missing and we feel as if 
# these would be difficult to impute with that amount missing
domestic <- select(domestic, -starts_with("SAT"))


# Dummy Variables ---------------------------------------------------------
library(fastDummies)
domestic <-dummy_columns(domestic, select_columns = c("AlumniConnection","Division"
                                                      ,"Major", "Status", "StateResidency",
                                                      "ApplicationType", "SpecialConsideration",
                                                      "Question", "Decision", "DecisionType",
                                                      "Harrison", "HsType", "ON",
                                                      "VisaType", "MiamiRanks"), 
                         remove_first_dummy = TRUE,
                         remove_selected_columns = TRUE)



# Getting Rid of More Variables --------------------------------------------
 #if the missing values are over 61.09% then we are going to get rid of them
df <- domestic[colSums(is.na(domestic))/nrow(domestic) > .6109]

domestic <-select(domestic, -"DataFrom", -"EER", -starts_with("ApplicationDate"), 
                  -"DecisionDate", -"ACTChoice", -"Phone", -"Math",
                  -"DisciplinaryQuestion1", -"NationDesc", -"Housing", -"ACTEquivalent",
                  -"Lang", -"County", -"InitialContact", -"hs.code", -"HSClust",
                  -"EduNbrhd", -ends_with("_Race"), -"MAI", -"Bridges",
                  -"FSBDirect", -starts_with("CEEB"), -"IntlTestScoreThresholdFlag",
                  -"Com.App.Acad.Int", -"Intl.Scholarship", -"ConfirmDate_Formatted",
                  -"College.Since.9th.Grade", -"Primary_Parent_Occupation", 
                  -"Sec_Parent_Occupation", -"Parent1Degree", -"Parent2Degree",
                  -"Permanent.Home", -starts_with("Zip"), -"Special.Consideration", 
                  -"DecisionDateFormatted", -"ConfirmedDate",
                  -"MeritGPA", -"GPAOrig", -"Parent.1.Education.Level",
                  -"Parent.2.Educational.Level", -"Visa.Type",-"Hispanic",
                  -starts_with("SpecialConsideration_"), -starts_with("Question_"),
                  -starts_with("Harrison_"), -"FirstGen", -"DecisionDate_Formatted",
                  -"Race")

# data.summary(domestic)
# plot_missing(domestic)
sapply(domestic, function(x) sum(is.na(x)))

# prop.table(table(domestic$ACTBest))
# prop.table(table(domestic$ACTComposite))

# summary(df)

# Imputation --------------------------------------------------------------
df2 <- domestic[colSums(is.na(domestic))/nrow(domestic) > .1594]

for(i in 1:ncol(domestic)) {
  domestic[ , i][is.na(domestic[ , i])] <- median(domestic[ , i], na.rm=TRUE)
}

#plot_missing(domestic)

df3 <- domestic[colSums(is.na(domestic))/nrow(domestic) > .1156]

domestic <-select(domestic, -"HighSchoolCode", -"Citizen", -"OneRace",
                  -"USStateRegion", -"Geomkt", -"Ethn_HS_YN", -"FullEthn",
                  -"FullEthn.Race", -"OhioCountyRegion", -"ACEFlag", -"MCFlag",
                  -"SuppMajor2", -"MeritGPAThresholdFlag")

#plot_missing(domestic)


# Fixing Race -------------------------------------------------------------

domestic[domestic == "AI"] <- "American Indian or Alaska Native"
domestic[domestic == "AS"] <- "Asian"
domestic[domestic == "HS"] <- "Hispanic/Latino"
domestic[domestic == "MR"] <- "Multi Racial"
domestic$FullRace[domestic$FullRace == "NC"] <- "Multi Racial"
domestic[domestic == "PI"] <- "Native Hawaiian or Other Pacific Islander"
domestic[domestic == "SortOfIntl"] <- "Non-Resident Alien"
domestic[domestic == "Two or more races"] <- "Multi Racial"
domestic[domestic == "UK"] <- "Unknown"
domestic[domestic == "BL"] <- "Black or African American"
domestic[domestic == "WH"] <- "White"
domestic$FullRace[domestic$FullRace == "1"] <- "American Indian or Alaska Native"
domestic$FullRace[domestic$FullRace == "2"] <- "Asian"
domestic$FullRace[domestic$FullRace == "6"] <- "Hispanic/Latino"
domestic$FullRace[domestic$FullRace == "7"] <- "Multi Racial"
domestic$FullRace[domestic$FullRace == "7"] <- "Multi Racial"
domestic$FullRace[domestic$FullRace == "4"] <- "Native Hawaiian or Other Pacific Islander"
domestic$FullRace[domestic$FullRace == "9"] <- "Non-Resident Alien"
domestic$FullRace[domestic$FullRace == "7"] <- "Multi Racial"
domestic$FullRace[domestic$FullRace == "8"] <- "Unknown"
domestic$FullRace[domestic$FullRace == "3"] <- "Black or African American"
domestic$FullRace[domestic$FullRace == "5"] <- "White"
domestic[domestic == "Hispanic/Latino, White"] <- "Multi Racial"
domestic[domestic == "Asian, White"] <- "Multi Racial"
domestic[domestic == "Black or African American, White"] <- "Multi Racial"
domestic[domestic == "Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic[domestic == "American Indian or Alaska Native, Hispanic/Latino, White"] <- "Multi Racial"
domestic[domestic == "American Indian or Alaska Native, Black or African American"] <- "Multi Racial"
domestic[domestic == "American Indian or Alaska Native, White"] <- "Multi Racial"
domestic[domestic == "Asian, Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic[domestic == "Black or African American, Hispanic/Latino"] <- "Multi Racial"
domestic[domestic == "American Indian or Alaska Native, Asian, White"] <- "Multi Racial"
domestic[domestic == "Asian, Hispanic/Latino"] <- "Multi Racial"
domestic[domestic == "Black or African American, Hispanic/Latino, White"] <- "Multi Racial"
domestic[domestic == "Black or African American, Hispanic/Latino, White"] <- "Multi Racial"
domestic[domestic == "American Indian or Alaska Native, Hispanic/Latino"] <- "Multi Racial"
domestic[domestic == "American Indian or Alaska Native, Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic[domestic == "Asian, Native Hawaiian or Other Pacific Islander"] <- "Multi Racial"
domestic[domestic == "Hispanic/Latino, Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic[domestic == "Asian, Hispanic/Latino, Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic[domestic == "American Indian or Alaska Native, Asian, Black or African American"] <- "Multi Racial"
domestic[domestic == "Asian, Black or African American, White"] <- "Multi Racial"
domestic[domestic == "Black or African American, Native Hawaiian or Other Pacific Islander, White"] <- "Multi Racial"
domestic[domestic == "Asian, Black or African American"] <- "Multi Racial"
domestic[domestic == "American Indian or Alaska Native, Black or African American, White"] <- "Multi Racial"
domestic[domestic == "Asian, Hispanic/Latino, White"] <- "Multi Racial"
domestic[domestic == "NA"] <- NA
domestic[domestic == "ASWH"] <- "Multi Racial"
domestic[domestic == "AIWH"] <- "Multi Racial"
domestic[domestic == "ASWH"] <- "Multi Racial"
domestic[domestic == "HSWH"] <- "Multi Racial"
domestic[domestic == "BLWH"] <- "Multi Racial"
domestic[domestic == "AIHSWH"] <- "Multi Racial"
domestic[domestic == "AIBLWH"] <- "Multi Racial"
domestic[domestic == "PIWH"] <- "Multi Racial"
domestic[domestic == "ASPI"] <- "Multi Racial"
domestic[domestic == "AIAS"] <- "Multi Racial"
domestic[domestic == "ASHSWH"] <- "Multi Racial"
domestic[domestic == "BLHSWH"] <- "Multi Racial"
domestic$FullRace[domestic$FullRace == "PR"] <- "Multi Racial"
domestic[domestic == "AIBLHS"] <- "Multi Racial"
domestic[domestic == "MAWH"] <- "Multi Racial"
domestic$FullRace[domestic$FullRace == "MA"] <- "Multi Racial"
domestic[domestic == "ASHS"] <- "Multi Racial"
domestic[domestic == "ASPIWH"] <- "Multi Racial"
domestic[domestic == "AIHS"] <- "Multi Racial"
domestic[domestic == "BLHS"] <- "Multi Racial"
domestic[domestic == "AIMAWH"] <- "Multi Racial"
domestic[domestic == "ASBLWH"] <- "Multi Racial"
domestic[domestic == "PRWH"] <- "Multi Racial"
domestic[domestic == "AIASMA"] <- "Multi Racial"
domestic[domestic == "AIASWH"] <- "Multi Racial"
domestic[domestic == "ASBL"] <- "Multi Racial"
domestic[domestic == "AIBL"] <- "Multi Racial"
domestic[domestic == "BLPR"] <- "Multi Racial"
domestic[domestic == "ASHSPIWH"] <- "Multi Racial"
domestic[domestic == "AIBLHSWH"] <- "Multi Racial"
domestic[domestic == "AIASBLWH"] <- "Multi Racial"
domestic[domestic == "BLPRWH"] <- "Multi Racial"
domestic[domestic == "MAPI"] <- "Multi Racial"
domestic[domestic == "AIASBL"] <- "Multi Racial"
domestic[domestic == "ASBLPIWH"] <- "Multi Racial"
domestic[domestic == "AIPIWH"] <- "Multi Racial"
domestic[domestic == "ASBLHS"] <- "Multi Racial"


# Fixing Major ------------------------------------------------------------

domestic[domestic == "00US"] <- "ASU1"
domestic[domestic == "ASU2"] <- "ASU1"
domestic[domestic == "ASU3"] <- "ASU1"
domestic[domestic == "ASU4"] <- "ASU1"
domestic[domestic == "ASUS"] <- "ASU1"
domestic[domestic == "AP71"] <- "RC71"
domestic[domestic == "AP72"] <- "AS72"
domestic[domestic == "AS74"] <- "EA74"
domestic[domestic == "AP87"] <- "RC87"
domestic[domestic == "AP88"] <- "RC88"
domestic[domestic == "APAN"] <- "ASAN"
domestic[domestic == "BUAN"] <- "ASAN"
domestic[domestic == "EAAN"] <- "ASAN"
domestic[domestic == "FAAN"] <- "ASAN"
domestic[domestic == "RCAN"] <- "ASAN"
domestic[domestic == "BUEB"] <- "RCEB"
domestic[domestic == "ASEN"] <- "APEN"
domestic[domestic == "BUEN"] <- "APEN"
domestic[domestic == "EAEN"] <- "APEN"
domestic[domestic == "FAEN"] <- "APEN"
domestic[domestic == "RCEN"] <- "APEN"
domestic[domestic == "0056"] <- "00UH"
domestic[domestic == "RCEN"] <- "APEN"
domestic[domestic == "APSH"] <- "APCH"
domestic[domestic == "ASEP"] <- "BUEP"
domestic[domestic == "EAEP"] <- "BUEP"
domestic[domestic == "FAEP"] <- "BUEP"
domestic[domestic == "APEP"] <- "BUEP"
domestic[domestic == "AS76"] <- "APES"
domestic[domestic == "ASES"] <- "APES"
domestic[domestic == "BUES"] <- "APES"
domestic[domestic == "EAES"] <- "APES"
domestic[domestic == "FAES"] <- "APES"
domestic[domestic == "IS76"] <- "APES"
domestic[domestic == "ISES"] <- "APES"
domestic[domestic == "RCES"] <- "APES"
domestic[domestic == "RCET"] <- "APET"
domestic[domestic == "RCHT"] <- "APHT"
domestic[domestic == "ASIM"] <- "APIM"
domestic[domestic == "BUIM"] <- "APHT"
domestic[domestic == "EAIM"] <- "APHT"
domestic[domestic == "FAIM"] <- "APHT"
domestic[domestic == "RCIM"] <- "APHT"
domestic[domestic == "APIM"] <- "APHT"
domestic[domestic == "ASIM"] <- "APHT"
domestic[domestic == "RCK3"] <- "BUK3"
domestic[domestic == "RCKA"] <- "BUKA"
domestic[domestic == "RCKM"] <- "BUKM"
domestic[domestic == "ASPM"] <- "APPM"
domestic[domestic == "BUPM"] <- "APPM"
domestic[domestic == "EAPM"] <- "APPM"
domestic[domestic == "FAPM"] <- "APPM"
domestic[domestic == "RCPM"] <- "APPM"
domestic[domestic == "ASRT"] <- "APRT"
domestic[domestic == "ASSU"] <- "APSU"
domestic[domestic == "BUSU"] <- "APSU"
domestic[domestic == "EASU"] <- "APSU"
domestic[domestic == "FASU"] <- "APSU"
domestic[domestic == "RCSU"] <- "APSU"
domestic[domestic == "EASW"] <- "ASSW"
domestic[domestic == "BU15"] <- "AS15"
domestic[domestic == "RC50"] <- "BU50"
domestic[domestic == "EA21"] <- "AS21"
domestic[domestic == "EA21"] <- "AS21"
domestic[domestic == "EA25"] <- "AS25"
domestic[domestic == "EA35"] <- "AS35"
domestic[domestic == "EA45"] <- "AS45"
domestic[domestic == "EA46"] <- "AS46"
domestic[domestic == "EA52"] <- "AS52"
domestic[domestic == "FA86"] <- "AS86"
domestic[domestic == "EA97"] <- "AS97"
domestic[domestic == "EA67"] <- "EAGW"
domestic[domestic == "RCCJ"] <- "ASCJ"
domestic[domestic == "EA52"] <- "AS52"
domestic[domestic == "EA93"] <- "ASEA"
domestic[domestic == "EA96"] <- "EALN"
domestic[domestic == "EA43"] <- "EALZ"
domestic[domestic == "EA52"] <- "AS52"
domestic[domestic == "FAJA"] <- "ASJA"
domestic[domestic == "RCTS"] <- "APTS"
domestic[domestic == "EA52"] <- "RCSU"
domestic[domestic == "ASSU"] <- "APSU"
domestic[domestic == "RCPC"] <- "APPC"

# Variables to edit/relevel -----------------------------------------------

domestic$OhioCountyRegion[domestic$OhioCountyRegion==""]<-"None"
domestic$USStateRegion[domestic$USStateRegion==""]<-"Other"
domestic$Citizenship[domestic$Citizenship==""]<-"US"
domestic$Citizenship2[domestic$Citizenship2==""]<-"US"
domestic$Citizenship[domestic$Citizenship=="PR"]<-"Non-Citizen"


# Fixes -------------------------------------------------------------------

# plot_missing(domestic)
# plot_bar(domestic) 
# plot_histogram(domestic)

# CountyDesc: 1119 categories
# CountyCode: 631 categories
# FullRace: 74 categories
# HighSchoolState: 69 categories
# SuppMajor1: 250 categories
# SuppMajor3: 122 categories

library(fastDummies)
domestic <-dummy_columns(domestic, select_columns = c("HomeState",
                                                      "CountyDesc", "CountyCode", 
                                                      "HighSchoolState",
                                                      "SuppMajor1","SuppMajor3", "FullRace",
                                                      "WhichTestBest", "DEC",
                                                      "Concentration"), 
                         remove_first_dummy = TRUE,
                         remove_selected_columns = TRUE)

# HomeState
df.home<-select(domestic, starts_with("HomeState"))
df.home$retained<-domestic$retained
lr.home<-glm(retained ~., data=df.home, family="binomial")
imp.home<-names(which(coef(summary(lr.home))[,4]<0.1))
domestic<-select(domestic, -starts_with("HomeState"))
domestic<-cbind(domestic, df.home[,imp.home[-1]])


# CountyDesc
domestic<-select(domestic, -starts_with("CountyDesc"))

# CountyCode
domestic<-select(domestic, -starts_with("CountyCode"))



# FullRace
df.FR<-select(domestic, starts_with("FullRace"))
df.FR$retained<-domestic$retained
lr.FR<-glm(retained ~., data=df.FR, family="binomial")
imp.FR<-names(which(coef(summary(lr.FR))[,4]<0.1))
domestic<-select(domestic, -starts_with("FullRace"))
domestic<-cbind(domestic, df.FR[,imp.FR[-1]])

# HighSchoolState
df.HSS<-select(domestic, starts_with("HighSchoolState"))
df.HSS$retained<-domestic$retained
lr.HSS<-glm(retained ~., data=df.HSS, family="binomial")
imp.HSS<-names(which(coef(summary(lr.HSS))[,4]<0.1))
domestic<-select(domestic, -starts_with("HighSchoolState"))
domestic<-cbind(domestic, df.HSS[,imp.HSS[-1]])

# SuppMajor1
df.SM1<-select(domestic, starts_with("SuppMajor1"))
df.SM1$retained<-domestic$retained
lr.SM1<-glm(retained ~., data=df.SM1, family="binomial")
imp.SM1<-names(which(coef(summary(lr.SM1))[,4]<0.1))
domestic<-select(domestic, -starts_with("SuppMajor1"))
domestic<-cbind(domestic, df.SM1[,imp.SM1[-1]])

# SuppMajor3
df.SM3<-select(domestic, starts_with("SuppMajor3"))
df.SM3$retained<-domestic$retained
lr.SM3<-glm(retained ~., data=df.SM3, family="binomial")
imp.SM3<-names(which(coef(summary(lr.SM3))[,4]<0.1))
domestic<-select(domestic, -starts_with("SuppMajor3"))
domestic<-cbind(domestic, df.SM3[,imp.SM3[-1]])

domestic <-select(domestic, -"AlumniConnection_D",-"AlumniConnection_D - Father, Sibling",-starts_with("Major_"), -"StateResidency_Z",
                  -"Decision_", -"DecisionType_DN",-"DecisionType_DQ",-"DecisionType_E",
                  -"DecisionType_HN",-"DecisionType_HQ",-"DecisionType_HY", -"DecisionType_KN",
                  -"DecisionType_KQ",-"DecisionType_KY",-"DecisionType_N",
                  -"DecisionType_SN",-"DecisionType_SQ",-"DecisionType_SY", -starts_with("AlumniConnection_B"))


#plot_missing(domestic)


domestic <-select(domestic, -"MiamiRanks_9", -"MiamiRanks_10", -"MiamiRanks_S",
                  -"HighSchoolState_AR", -"HighSchoolState_DE", -"HighSchoolState_OR", -"MiamiRanks_8",
                  -"MiamiRanks_7", -"MiamiRanks_6", -"MiamiRanks_5", -"ON_8",
                  -"ON_7", -"ON_6", -"ON_5", -"HsType_Unknown", -"HsType_Private Secular", -"HsType_Home School"
                  , -"HsType_Charter", -"HsType_4", -"DecisionType_S", -"ApplicationType_OI", -"HsType_Religious"
                  , -"Division_CCA", -"AlumniConnection_M - Mother", -"AlumniConnection_F - Father", -"AlumniConnection_C - Mother, Sibling"
                  , -"AlumniConnection_C", -"AlumniConnection_A", -"Citizenship2", -"AlumniConnection_A - Mother, Father, Sibling", -"MiamiRanks_4")


domestic <-select(domestic, -"SuppMajor3_AP56", -"SuppMajor3_AS47", -"SuppMajor3_AS86", -"SuppMajor3_ASBC"
                  , -"SuppMajor3_ASBP" , -"SuppMajor3_ASEV", -"SuppMajor3_ASIN", -"SuppMajor3_ASJN", -"SuppMajor3_ASSW", -"SuppMajor3_ASU1", -"SuppMajor3_BU01"
                  , -"SuppMajor3_BUIB", -"SuppMajor3_BUIS", -"SuppMajor3_EA56", -"SuppMajor3_EAGA", -"SuppMajor3_FA03", -"SuppMajor3_FA39")


domestic$ConfirmCode[domestic$ConfirmCode==""]<-"N"
domestic$WhichTestBest[domestic$WhichTestBest==""]<-"NO TEST"

domestic$retained[domestic$retained == "1"] <- "No"
domestic$retained[domestic$retained == "0"] <- "Yes"
prop.table(table(domestic$retained))


prop.table(table(domestic$Citizenship))

domestic <- select(domestic, -"TermCode")
domestic <- select(domestic, -"Citizenship")

domestic <- select(domestic, -"Concentration_VO",-"Concentration_SI",-"Concentration_SH",
                   -"Concentration_SG",-"Concentration_SF",-"Concentration_SE",
                   -"Concentration_SD",-"Concentration_M2",-"Concentration_HB",
                   -"Concentration_EL",-"Concentration_89",-"Concentration_84",
                   -"Concentration_76",-"Concentration_IN")

domestic <- select(domestic, -"WhichTestBest_TIE")
domestic <- select(domestic, -"Dec")



domestic$AlmostFullRace[domestic$AlmostFullRace=="Multi Racial"]<-"Non-White"
domestic$AlmostFullRace[domestic$AlmostFullRace=="Asian"]<-"Non-White"
domestic$AlmostFullRace[domestic$AlmostFullRace=="Black or African American"]<-"Non-White"
domestic$AlmostFullRace[domestic$AlmostFullRace=="Hispanic/Latino"]<-"Non-White"
domestic$AlmostFullRace[domestic$AlmostFullRace=="American Indian or Alaska Native"]<-"Non-White"
domestic$AlmostFullRace[domestic$AlmostFullRace=="MA"]<-"Non-White"
domestic$AlmostFullRace[domestic$AlmostFullRace=="PR"]<-"Non-White"
domestic$AlmostFullRace[domestic$AlmostFullRace=="Native Hawaiian or Other Pacific Islander"]<-"Non-White"


plot_missing(domestic)
plot_bar(domestic)
plot_histogram(domestic)


# dont do a standalone tree
# lr<-glm(retained ~., data=domestic, family="binomial")
# imp<-names(which(coef(summary(lr))[,4]<0.2))

# RDS File ----------------------------------------------------------------

saveRDS(domestic, "ISA491Project_clean2.RDS")



# Creating Models ---------------------------------------------------------


library(caret)
trainIndex<-createDataPartition(domestic$retained, p=0.7, list=FALSE, times=1)
head(trainIndex)

set.seed(13)

training<-domestic[trainIndex, ]
valid<-domestic[-trainIndex, ]

#head(training[,terms])

class.tree<-rpart(retained~., data=training,
                  control=rpart.control(maxdepth = 30, minsplit=20, cp=0.001, xval=10),
                  method="class", model=TRUE)

