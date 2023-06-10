setwd("~/Desktop/School/ISA 291")

dir()

HR = read.csv('HR_DAE.csv')
HR
HR = HR[which(HR$EmploymentStatus == "Active"),]

HR$EmploymentStatus = NULL
HR$DateofTermination = NULL
HR$TermReason = NULL
HR$DOB = NULL
HR$DateofHire = NULL
HR$EmpID = NULL
HR$Employee_Name = NULL
HR$ManagerName = NULL
HR$State =NULL
HR$Zip = NULL

str(HR)
## Do not know step one at the moment
reg1 = lm(EmpSatisfaction ~ Department, data = HR)
summary(reg1)
levels(Department)

  
reg2 = lm(EmpSatisfaction ~ RecruitmentSource, data = HR)
summary(reg2)
HR$RecruitmentSource = as.factor(HR$RecruitmentSource)
levels(HR$RecruitmentSource)

reg3 = lm(EmpSatisfaction ~ Position, data = HR)
summary(reg3)
HR$PerformanceScore = as.factor(HR$PerformanceScore)
levels(HR$PerformanceScore)
cor(HR$Position, HR$EmpSatisfaction)

reg4 = lm(EmpSatisfaction ~ RaceDesc, data = HR)
summary(reg4)

reg5 = lm(EmpSatisfaction ~ PayRate + PerformanceScore, data = HR)
summary(reg5)
anova(reg5)

confint(reg5, level = .90)

########## Higher order regression

reg6 = lm(EmpSatisfaction ~ PayRate + CitizenDesc + PerformanceScore 
          + SpecialProjectsCount + I(SpecialProjectsCount*SpecialProjectsCount) + PayRate:SpecialProjectsCount, data = HR)
summary(reg6)
anova(reg6)

reg7 = lm(EmpSatisfaction ~ PayRate + Sex + CitizenDesc +
            PerformanceScore + EngagementSurvey + SpecialProjectsCount, data = HR)
summary(reg7)
anova(reg7)



