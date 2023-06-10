'''
map applies a function to each element of a list.
Specify the function name, and the list as parameters to the map function.
(Please use list on the result returned by map to convert to a list. Otherwise it returns an iterator )
'''

def square(x):
    return x*x

num_list = [2,3,4]

out=[]
for num in num_list:
    print(square(num))
    out.append(square(num))
    
print(out)

# result = list(map(function, input list))
# generate a list by modyifing another list via  a function

out1  = list(map(square, num_list)) # this is equal to the for loop above, same thing
print(out1)


'''
filter function allows us to select elements of a list, by applying a function to the list.
Again, specify the function name and the list as parameters to the filter function.
'''
def even(x):
#    if x%2==0:
#        return True
#    else:
#        return False
    return (x%2==0)

out2 = list(filter(even, num_list))
print(out2)

## list comprehension
# result = [transform, iteration, filter]
# transform could be a function, or some expression

out3 = [square(x) for x in range(1,10)]
print(out3)

out4 = [x*x for x in range(1,10)]
print(out4)

out5 = [x*x for x in range(1,10) if (x*x)%2==0] # incorporating the filter part
print(out5)


# Format
'''
To use formatted string literals, begin a string with f or F before the opening quotation.
Inside this string, you can write a Python expression between { and } characters that
can refer to variables or literal values.
'''
num = [10,20]
course = 'ISA 281'
fmt_str = 'The class is {} with {} students in-person and {} students online'
print(fmt_str.format(course,num[0], num[1]))

# print('The class is ' + course +  ' with ' + str(num) + ' students in person')
