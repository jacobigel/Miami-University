
def factorial(n):
    ''' Calculate the factorial.

    Using recursion calculates factorial
    '''
    # n==1 is my stop condition
    if n==1: return 1
    else:
        return factorial(n-1)*n


print(factorial(5))


def power(x,n):
    if n==0: return 1
    elif n==1: return x
    else:
        return power(x,n-1)*x

print(power(10,3))


def cube(number):
    return power(number, n=3)

print(cube(2))





def full_name(first,last):
    ''' Generate full name.

    concatenate the first & last name if neither is empty
    expects both to be strings 
    '''
    if first == '':
        name = last
    elif last =='':
        name = first
    else:
        name = first + ' ' + last
    return name

print(full_name('','Igel'))
print(full_name('Jacob',''))
print(full_name('Jacob','Igel'))


def volume(depth,width,height):
    ''' Calculate the volume.
    
    prodcut of width, height, & depth which are intergers
    '''
    print('Width is ', width)
    return depth*width*height

print(volume(10,20,30))

def volume_ten_deep (width, height):
    '''volume _ten_deep - depth is fixed

    Calls volume with fixed depth, height, width intergers
    '''
  
    return volume(width=10,height=20,depth=10)

print(volume_ten_deep(10,20))
