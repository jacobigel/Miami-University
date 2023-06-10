tel_num = {'A':4826,'B':4835, 'C':4830,'D':4940}

## membership in dictionary
## key part of the dictionary

print('A' in tel_num) # prints true
print('Z' in tel_num) # prints false

## dict - keyword - create dictionary from a list of tuples
## tuples - itself will have k:v (key, value)

tel_new = dict([('A',4826),('B', 4835)])

## Alternately use key=value format (without the quotes for the string in keys)
tel_2 = dict(A=4826,B=4835)

print(tel_new)
print(tel_2)

## Dictionary Comprehensions

##{k:v for var k,var v in an iterator}

sqr = {x:x*x for x in range (1,10)}
print(sqr)
