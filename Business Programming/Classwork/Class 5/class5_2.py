for i in range(1,5):
    for j in range(0,4):
        print(i,j, i+j)
    print('value of i ' + str(i))
        

def times_table(n):
    for i in range(1,n):
        for j in range(1,n):
            print(i*j, end='\t')
        print()

times_table(5)


## \t - is a tab
## \n - is a new line


def print_pattern(n):
    for i in range(1,n+1):
        for j in range(i):
            print('*', end=' ')
        print()

print_pattern(7)


'''
print_pattern(3)
i ranges from 1 through 4 -- 1,2, or 3
i =1

1st iteration i =1 
    j is 1,2
1
2nd iternation i = 2
2 2
'''



# Ask a user for a number
# Run the times table till that number

entered = ' '
while entered != quit:
    user_num = int(input('Please enter a number '))
    times_table(user_num)
    entered = input('Again - enter quit to leave ')





