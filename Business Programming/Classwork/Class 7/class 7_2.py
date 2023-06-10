# reverses using the notion that a -1 step selects elements from end
# to beginning

def reverse_list(in_list):
    return (in_list[::-1])

# Write a function First the retrieves the first element of a list, and returns the first element
# Write a function Last that will return the last element

def first (in_list):
    return(in_list[0])


def last(in_list):
    return(in_list[-1])
    # or -- > return(in_list[len(in_list)-1])

def main():
    mylist=['zero','one','two','three','four']
    x = first(mylist)
    print(x[:2])

main()

primes = [2,3,5,7,11,13]

for n in primes:
    print(n)

# returns the minimum value of a given list of numbers 
def min_list(in_list):
    minvalue = in_list[0]
    for n in in_list:
        if n < minvalue: minvalue = n
    return (minvalue)

# returns the maximum value of a given list of numbers
def max_list(in_list):
    maxvalue = in_list[0]
    for n in in_list:
        if n > maxvalue: maxvalue = n
    return (maxvalue)

def main():
    primes = [13,11,5,7,3,2]
    min_value = min_list(primes)
    max_value = max_list(primes)
    print('The minimum value is ' +  str(min_value))
    print('The maximum value is ' + str(max_value))
    mylist=['zero','one','two','three','four']
    print('Minimum value is ' + min_list(mylist))
    print('Maximum value is ' + max_list(mylist))
    print(reverse_list(mylist))



main()

    

