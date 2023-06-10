value = 99
print('The value is ', value)

def change_me(arg):
    global value
    print('I am changing the value from ', value)
    arg = 0
    value = 5 # this is a new variable - local to change_me
    print('The value is',value)

change_me(value)
print('The value is', value)



## Arguments are passed by value
## (a copy of the variable is made in the function)
