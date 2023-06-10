#  Jacob Igel ISA 281 - B
# Question 2

tip_amount = 0
percentage = 0

def calc_tip(amount, percentage):
    '''
    Using the equation tip_amount will make sure that I get the correct percentage to multpily to 50.
    Calculate the tip given amount and percentage
    Does integer arithmetic amount and percentage are both int
    '''
    tip_amount = int(amount*(percentage/100))
    if percentage <10: # under 10, print the following
        print('You should really tip a higher percentage')
    elif percentage > 20: # Over 20, print the following
        print('You are too generous')
    else:
        print(end ='') # if the tip is between 10 and 20, it prints nothing
    print('Tip Amount: ' ,end = ' ')
    return(tip_amount)


print(calc_tip(50,8))
print(calc_tip(50,14))
print(calc_tip(50,30))


def standard_tip(amount):
    '''
    in order to call back to calc_tip, we must put the range it understands (amount and percentage).
    Since only the 'percentage' is fixed, we have to explicitly define that.
    '''
    return calc_tip(amount, percentage=18)

print(standard_tip(50))
