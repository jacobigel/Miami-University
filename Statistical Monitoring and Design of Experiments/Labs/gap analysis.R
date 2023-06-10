#gap analysis

df<-read.csv("I:\\Classes\\ISA 365\\Class Activities\\GAP analysis\\gap.csv")

library(tidyverse)
df_long <- df %>% pivot_longer(!Day,
                               names_to="treatment",
                               values_to="spend")
mod<-aov(spend~treatment+Day, data=df_long)
summary(mod)
TukeyHSD(mod)$treatment

ggplot(df_long, aes(x=treatment, y=spend, color=treatment))+geom_boxplot()+
  facet_grid(~Day)+theme_bw()+ylab("User Spend")+xlab("Offer")+
  scale_color_manual(values=c("#999999", "#56B4E9", "#999999"))+
  theme(legend.title=element_blank())+
  theme(axis.text.x=element_text(size=8))
