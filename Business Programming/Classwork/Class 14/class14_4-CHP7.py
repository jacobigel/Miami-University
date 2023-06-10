## dictionaries - create with braces - key:value
tel_extn = {'Igel':2657, 'Rajkumar':4830, 'Fang':1390, 'Skip':4835}

## retrieve  using the key
print(tel_extn['Fang'])

## Add a new entry by specifiying a key and a value
tel_extn['Havelka'] = 4836
print(tel_extn)

# delete an entry by using the del with the key value
del tel_extn['Rajkumar']
print(tel_extn)

# updates are done by simply changing the value associated with the key
tel_extn['Skip'] = 4826
print(tel_extn)

# if a key does not exist, it will return an error
# print(tel_extn['Rajkumar']) - KeyError: 'Rajkumar' bascially saying "key not found"

# to retrieve just the keys in sorted fashion
print(sorted(list(tel_extn)))


# property called .values
print(tel_extn.values())
# property called .keys
print(tel_extn.keys())
