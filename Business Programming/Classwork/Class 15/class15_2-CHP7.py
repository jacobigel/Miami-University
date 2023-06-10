tel_num = {'A':4826,'B':4835, 'C':4830,'D':4940}

# iterating though the dictionary

## for loop using .items() - if you want both keys and values

for key,value in tel_num.items():
    print(key,value)

# if you just want keys = .keys()
for k in tel_num.keys():
    print(k)

# if you just want values = .values()
for v in tel_num.values():
    print(v)

# we can use keys to lookup values of the dictionary items, but not vice versa
# given a value, we cannot find a key directly
# easier to do with .items

for k in tel_num.keys():
    print(k, tel_num[k])
