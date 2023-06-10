num_list = list(range(1,15,3))
print(num_list)

primes = []
primes.append(2)
primes.append(3)
primes.append(5)
primes.append(7)
primes.append(11)
primes.append(13)

print(primes)
primes.reverse()
print(primes)

new_primes = [2,3,5,7,11,13,19]
# primes = primes + new_primes

primes.extend(new_primes)
print(primes)
primes.sort()
print(primes)
primes.sort(reverse=True)
print(primes)
print(primes.count(13))
print(primes.index(13))

# find and remove all instances of 13
num_times = primes.count(13)
for i in range(num_times):
    primes.remove(13)

print(primes)
x = primes.pop(-3)
print(x, primes)
y = primes.pop()
print(y)


