## Functions on lists

# len(list) - returns the length of the function
# max(list) - returns the maximum value of the items in the list
# min(list) - returns the item from the list with the minimum value

primes = [2,3,5,7,11,13]
print(max(primes), min(primes), len(primes))

# if you want to change the value of an element
# you must use the index

indx = primes.index(7)
primes[indx] = 17

print(primes)

for counter, value in enumerate(primes):
    print(counter,value)
