'''
A few things about tuples:

Lists are ordered and mutable. (changable)
In contrast, tuples are *immutable*.
*Fixed-length* collection of values
Can be passed around like a variable.
A tuple consists of a number of values separated by commas, for instance:
Indexing and slicing operators are allowed.
'''

# Tuples are created with regular parentheses

t = (12345, 54321, 'Hello') # able to mix element types, can even have lists in them

print(t[0])
print(t[1:])
print(t[-1])
## immutability - implies i cannot replace the values of an element

# t[0] = 8888 - this returns an error (TypeError: 'tuple' object does not support item assignment)

t1 = (1234, 4321, 'Hello', [1,2,3])
print(t1)
t1[3][1] = 42
print(t1)
#t1.append = 'world' - does not work

t2=(1,(1,2))
print(type(t2),type(t2[1])) # two tuples inside of a tuple

## iterate through each element
for elem in t1:
    print(elem)

## more often, we unpack the tuple
t3 = (1234, 4321, 'Hello', [1,2,3])

## unpack t - assign appropriate variable names to the elements
num1,num2, txt1,lst1 = t3
print(num1,num2, txt1,lst1)

# we can also pass a tuple to a function and then unpack the values in the tuple
def sum_tuple(tpl):
    a,b = tpl
    return a+b

pair = (1,2)
print(sum_tuple(pair))

## If there is only a single element in a tuple, it must have a trailing comma
t4 = (1,) # vs t4 = (1)
t5 = (1)
print(type(t4), type(t5))

