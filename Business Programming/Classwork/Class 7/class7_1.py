primes = [2,3,5,7,11,13]

print(primes[-1])

course = 'ISA 281'

print(course[-1])

print(len(primes))
print(len(course))

print(primes[0:2]) #prints '2' and '3' but not '5'
print(course[0:2]) #prints 'IS' but not' A 281'

# Neither of these will run because they are both errors
# print(primes[6])
# print(course[7])

print(primes[3:8]) #this will print 7,11,13 but stop there without an error

print(primes[2:]) #omits anything before two
print(primes[:2]) #omits anything after two

print(course[2:])
print(course[:2])

# lists have start, slice, step just like ranges
print(primes[2::2])

x = primes[:] #shallow copy


course2 = course[:] #another shallow copy
print(course2)


y = primes[::-1]
print(y)
course3 = course[::-1]
print(course3)


print(course + course2)
print(primes+y)

print(course * 3)
print(primes*4)

