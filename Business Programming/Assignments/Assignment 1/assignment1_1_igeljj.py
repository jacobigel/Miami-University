# Jacob Igel ISA 281 - B
# Question 1

def times_table(n):
    '''
    This is used for the rest of the question so we can properly get a times table that goes
    to the number inputted on the y axis and the number 10 on the x axis
    '''
    for i in range(1,n+1):
        for j in range(1,11):
            print(i*j, end='\t')
        print() 

user_num = ' '
count = 0

while user_num != 0:
    count = count +1
    user_num = int(input('How many numbers do you want to print the tables for? User enters: '))
    if user_num > 5:
        '''
        This is for the instance that the user enters anything over 5
        '''
        print('Times Till 5')
        times_table(5)
    elif user_num == 0:
        print(end='')
    else:
        print('Times Till ' + str(user_num))
        times_table(user_num)
        
print('Thanks for using Times Table ' + str(count-1) + ' times')



