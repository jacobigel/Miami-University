# Week 2, Class 2 = class 22

'''
 Return an object that produces a sequence of integers from start (inclusive)
 |  to stop (exclusive) by step.  range(i, j) produces i, i+1, i+2, ..., j-1.
 |  start defaults to 0, and stop is omitted!  range(4) produces 0, 1, 2, 3.
 |  These are exactly the valid indices for a list of 4 elements.
 |  When step is given, it specifies the increment (or decrement).
 '''
'''
# range(start, stop, increment/step)

for number in range(1,5,2):
    print(number)

## if step is negative - will not return anything since it will NEVER reach 5 (infinite loop)

for number in range(1,5,-1):
    print(number)


# With the numbers reversed, it works

for number in range(5,1,-1):
    print(number)
'''


    
def print_upto(n):
    for number in range(n):
        print(number+1, end = ' ')
    print(end = '\n')
  

print_upto(6)
print_upto(3)


def print_downto(num1, num2):
    for number in range(num1, num2, -1):
        print(number-1, end = '\t')
    print()
        

print_downto(10,5)
print_downto(20,12)

# Increase the separation between the numbers
# Change the separator to a tab

# reversed function
# define a new function - print reversed up to

def print_reversed_upto(n):
    for number in reversed(range(n)):
        print(number+1, end = '  ')
    print(end = '\n')

print_reversed_upto(6)





def print_string(mystring):
    for char in mystring:
        print(char, end=' ')
    print(end='\n')


print_string('aei  ou')



def count_spaces(mystring):
    num_spaces=0
    for char in mystring:
        if char == ' ': num_spaces = num_spaces + 1 # or num_spaces += 1
    return num_spaces


print(count_spaces('Hello World'))
print(count_spaces('Hello World, How are you?'))
print(count_spaces('Hello'))



def print_correct_string(mystring):
    numchar=0
    for char in mystring:
        numchar +=1
        if numchar !=len(mystring):
            print(char, end=' ')
        else:
            print(char)

print_string('aeiou')
print_correct_string('aeiou')

def print_spaced(s):
    for x in s:
        print(x, end=' ')


print_spaced('aeiou')






              
