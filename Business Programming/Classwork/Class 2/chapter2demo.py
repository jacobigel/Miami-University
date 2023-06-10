# Chapter 2 1/27

def cube(x):
    '''
    1. Cube Function
    This calculates the cube of a given nummber
    '''
    y = x*x*x
    return y     # return the value in y

num = 100
print(cube(num))


def sum_two_numbers(x,y):
    print (x)
    print (y)
    return x+y

num1 = 10
num2 = 20

sum_num1_num2 = sum_two_numbers(num1,num2)
print(sum_num1_num2)
sum_num2_num1 = sum_two_numbers(num2,num1)
print(sum_num2_num1)

'''
my example without the print x and y (the print x and y was just to show
what numbers are going into the function.
'''
def product_num(a,b):
    return a+b

one = 69
two = 420

productone = product_num(one,two)
print(productone)
producttwo = product_num(two,one)
print(producttwo)


def pow_two_numbers(x,y):
    return x**y

print(pow_two_numbers(10,3))
print(pow_two_numbers(3,10))


def mycube(x):
    return pow_two_numbers(x,3)


# converts Farh to centigrade
def fahr_to_centigrade(temp):
    return (temp-32)*(5/9)

print(fahr_to_centigrade(33))


