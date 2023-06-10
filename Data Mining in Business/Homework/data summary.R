#function to output a nice summary statistics table.  Input is a data frame.  
#Output is a dataframe of numeric summary and factor summary.


data.summary<-function(data)
  {
  
  nums <- unlist(lapply(data, is.numeric)) 
  data.nums<-data[,nums]
  m<-data.frame(mean=sapply(data.nums, function(x) mean(x, na.rm=TRUE)), 
               sd=sapply(data.nums, function(x) sd(x, na.rm = TRUE)), 
               min=sapply(data.nums, function(x) min(x, na.rm=TRUE)), 
               max=sapply(data.nums, function(x) max(x, na.rm=TRUE)), 
               median=sapply(data.nums, function(x) median(x, na.rm=TRUE)), 
               length=sapply(data.nums, length) ,
               missing=sapply(data.nums, function(x) sum(length(which(is.na(x))))))
  
  
  facs<-unlist(lapply(data, is.factor))
  data.facs<-data[,facs, drop=F]
  p<-data.frame(levels=sapply(data.facs, function(x) nlevels(x)),
             mode=sapply(data.facs, function(x) names(which.max(table(x)))),
             missing=sapply(data.facs, function(x) sum(length(which(is.na(x))))))
  print(m)
  print(p)
}
