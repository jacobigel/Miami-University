def palindromic(s):
    return(s==s[::-1])

print(palindromic('1221'))

str_list = ['1221','122','133','1331']

palindrome_list = list(map(palindromic,str_list))
filtered_list = list(filter(palindromic,str_list))

print(palindrome_list)
print(filtered_list)


num_list = [str(x) for x in range (100,1000)]
palindromic_numbers = list(filter(palindromic,num_list))
print(palindromic_numbers)


def clip(num):
    if num > 10:
        num =10
    if num < 0:
        num =1
    return(num)

new_nums = [x for x in range(-10,20)]
clip_nums = list(map(clip,new_nums))
print(clip_nums)

clip_list = [clip(x) for x in new_nums]
print(clip_list)


sentence = 'The class started without audio to the group of online students'
words = sentence.split()
words.sort()
print(words)
## Upper case alphabet have lower Ascii values than lowercase alphabet

