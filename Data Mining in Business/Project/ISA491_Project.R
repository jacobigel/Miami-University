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
#domestic2 <- read.csv("domestic_data.csv")
domestic_2018 <- read.csv("domestic_2018.csv") # do not need to do anything with right now

introduce(domestic)
plot_missing(domestic)
data.summary(domestic)

# 2005, 2006, 2009, 2010 were all years that Miami admission was not "normal"
# so because of that we want to consolidate the data to the "Normal" years of 
# operation. 

# We are using DateFrom to remove these dates instead of DataFrom since it 
# ranges from 2005 - 2017 instead of 2006 - 2015. They are the exact same variable
#table(domestic$DateFrom)

domestic <- filter(domestic, (DateFrom != "2005"))
domestic <- filter(domestic, (DateFrom != "2006"))
domestic <- filter(domestic, (DateFrom != "2009"))
domestic <- filter(domestic, (DateFrom != "2010"))

# With these variables removed, we now have 9 "Normal" years that we want to 
# compare to 2018 since it is the most recent information that we have. 
# Along those lines, we want to use 2018 as a sort of "base line" for which
# variables we find important or not


# In-Class ----------------------------------------------------------------


## In-Class work
# These two are the exact same variable KEEP DATE FROM
# table(domestic$DataFrom)
# table(domestic$DateFrom)

# correlation plot
nums <- unlist(lapply(domestic, is.numeric))
M <- as.data.frame(domestic[,nums])
corr_cross(M, max_value = 0.05, top = 10)



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

data.summary(domestic)
plot_missing(domestic)
sapply(domestic, function(x) sum(is.na(x)))


summary(df)

# Imputation --------------------------------------------------------------
df2 <- domestic[colSums(is.na(domestic))/nrow(domestic) > .1594]

for(i in 1:ncol(domestic)) {
  domestic[ , i][is.na(domestic[ , i])] <- median(domestic[ , i], na.rm=TRUE)
}

plot_missing(domestic)

df3 <- domestic[colSums(is.na(domestic))/nrow(domestic) > .1156]

domestic <-select(domestic, -"HighSchoolCode", -"Citizen", -"OneRace",
                  -"USStateRegion", -"Geomkt", -"Ethn_HS_YN", -"FullEthn",
                  -"FullEthn.Race", -"OhioCountyRegion", -"ACEFlag", -"MCFlag",
                  -"SuppMajor2", -"MeritGPAThresholdFlag")
plot_missing(domestic)


# Fixing Major ------------------------------------------------------------

# df.maj<-select(domestic, starts_with("Major_"))
# df.maj$retained <-domestic$retained
# 
# 
# lr<-glm(retained~., data=df.maj, family="binomial")
# summary(lr)
# 
# imp<-names(which(coef(summary(lr))[,4]<0.1))
# domestic <-select(domestic, -starts_with("Major_"))
# domestic<-cbind(domestic, df.maj[,imp[-1]])
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

# Fixing Race -------------------------------------------------------------

domestic[domestic == "AI"] <- "American Indian or Alaska Native"
domestic[domestic == "AS"] <- "Asian"
domestic[domestic == "HS"] <- "Hispanic/Latino"
domestic[domestic == "MR"] <- "Multi Racial"
domestic[domestic == "NC"] <- "Multi Racial"
domestic[domestic == "PI"] <- "Native Hawaiian or Other Pacific Islander"
domestic[domestic == "SortOfIntl"] <- "Non-Resident Alien"
domestic[domestic == "Two or more races"] <- "Multi Racial"
domestic[domestic == "UK"] <- "Unknown"
domestic[domestic == "BL"] <- "Black or African American"
domestic[domestic == "WH"] <- "White"
domestic[domestic == "1"] <- "American Indian or Alaska Native"
domestic[domestic == "2"] <- "Asian"
domestic[domestic == "6"] <- "Hispanic/Latino"
domestic[domestic == "7"] <- "Multi Racial"
domestic[domestic == "7"] <- "Multi Racial"
domestic[domestic == "4"] <- "Native Hawaiian or Other Pacific Islander"
domestic[domestic == "9"] <- "Non-Resident Alien"
domestic[domestic == "7"] <- "Multi Racial"
domestic[domestic == "8"] <- "Unknown"
domestic[domestic == "3"] <- "Black or African American"
domestic[domestic == "5"] <- "White"
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
domestic[domestic == "PR"] <- "Multi Racial"
domestic[domestic == "AIBLHS"] <- "Multi Racial"
domestic[domestic == "MAWH"] <- "Multi Racial"
domestic[domestic == "MA"] <- "Multi Racial"
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

# Variables to edit/relevel -----------------------------------------------

domestic$OhioCountyRegion[domestic$OhioCountyRegion==""]<-"None"
domestic$USStateRegion[domestic$USStateRegion==""]<-"Other"
domestic$Citizenship[domestic$Citizenship==""]<-"Other"
domestic$Citizenship2[domestic$Citizenship2==""]<-"Other"



domestic$Major[domestic$Major=="American Indian or Alaska Native"] <- "1"

# RDS File ----------------------------------------------------------------

saveRDS(domestic, "ISA491Project_clean.RDS")


