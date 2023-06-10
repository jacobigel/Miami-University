def sign(x):
    if x  > 0:
        return 1
    elif x <0:
        return -1
    else:
        return 0

print(sign(10))
print(sign(-10))
print(sign(0))


def is_vowel (x):
    if (x == 'a'):
        return True
    elif(x == 'e'):
        return True
    elif(x == 'i'):
        return True
    elif(x == 'o'):
        return True
    elif(x == 'u'):
        return True
    else:
        return False

print(is_vowel('a'))
print(is_vowel('e'))
print(is_vowel('i'))

def is_vowel(x):
    if (x == 'a' or x== 'e'):
        return True
    else:
        return False

# Using is_vowel, write a function is_consonant

def is_consonant(x):
    return( not (is_vowel(x)))

print(is_consonant('b'))
print(is_consonant('e'))
print(is_vowel('j'))
print(is_vowel('a'))

