# Using Lists
# Lists CAN have any type (string, int, etc.) but usually don't in practice.

# l = [zero element, first element, second element, ...]
l =[1,4,2]

l2 = [1, 'Igel', 2, 'ISA']
print(l2[1], l[0])
print(len(l2), len(l))
print(l2[0:2])
print(l2[-1], l2[-3])
print(l2[5]) # this is not an error, it is just telling you its out of range
