# Split a strinf into a list of its letters, each as a string using the built in list funtion
s= 'tumultous'
str_list = list(s)
print(str_list)

# Split method: splits a given string into a list of strings, one for each word in the original:
str_split = s.split()
print(str_split)

# Splitting the word on 'u'
str_split = s.split('u')
print(str_split)

'''
s.split(sep) will split the string s into a list of substrings separated by sep.
The sep argument is optional, and if it isomitted the string is split with respect to whitespace.
as shown above. However, if it is given then it will split using the separator. Here the colon is used.
'''
s1 = 'Berlin: 18.4 C at 4 pm'
s1_split = s1.split(':') # when split on a colon, it kept the empty spaces
print(s1_split)

s2 = '   Once  upon  a  time   '
s2_split = s2.split() # did not keep any empty spaces
print(s2_split)

# all splits of strings lead to a list


# join is a string operator
joined_str = ''.join(s2_split)
print(joined_str)

joined_str = '  '.join(s2_split)
print(joined_str)


## strip() - strip the leading and lagging spaces
s3 = s2.strip()
print(s3)

## rstrip and lstrip - that removes the spaces on the right or left
## of the string
s4 = s2.rstrip()
print(s4)
s5 = s2.lstrip()
print(s5)

s6 = ':'.join(s1_split)
print(s6)


strings = ['ISA', '281', 'Sec B']
section = ':'.join(strings)
print(section)
