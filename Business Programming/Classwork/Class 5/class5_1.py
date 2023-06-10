count = 0
for indx in reversed( range (1,5)):
    count +=1
    print(indx,count, sep = ' ', end='\n')
print(count, end='\n')


count = 0
for indx in reversed('CHARLES'):
    count +=1
    if count < len('CHARLES'):
        print(indx, count, sep=' ', end=' ')
    else:
        print(indx,count, sep = ' ', end='\n')
print(count, end='\n')
