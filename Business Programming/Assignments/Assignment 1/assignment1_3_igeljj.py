# Jacob Igel ISA 281 - B
# Question 3

def print_inreverse(x):
    return (x[::-1])

print(print_inreverse('ISA 281'))

def generate_palindrome(x):
    return(x+print_inreverse(x)) # this is the callback to the print_inreverse function

print(generate_palindrome('ISA 281'))
