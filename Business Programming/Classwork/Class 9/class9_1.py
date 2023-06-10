x = [ 2,3,5]
y = x # shallow copy
z = x.copy() # deep copy
print(x,z,y)
x.append(7)
print(x,y,z) # notice how z does not show a seven

'''
notice how z does not show a seven. A deep copy is a copy of the list that you had orignally without
the append. The y value copies everything and every append made to the original
'''

z.sort(reverse = True)
print(z)

'''
x = x.append(7) ## NOT RIGHT
print(x) # Makes this appear as 'None'
'''
num = max(z)
print(num)


print(z)
if 5 in z:
    print(True)
    
if 10 in z:
    print(True)
else:
    print(False)

print()

# membership within a string
course = 'ISA 281'
if 'IS' in course:
    print(True)

course_list = ['ISA 281', 'ISA 245', 'ISA 401', 'ISA 406']
if 'ISA 291' in course_list:
    print(True)
else:
    print(False)

print()



def contain_allwords(sentence, word_list):
    all_words = True
    for word in word_list:
        if word not in sentence:
            all_words=False
            break
    return all_words


def main():
    sentence = 'The quick brown fox jumped over the lazy dog'
    word_list = ['The', 'quick', 'hen']
    all_words = contain_allwords(sentence,word_list)
    if all_words:
        print('All the words are in the sentence')
    else:
        print('Not all words were found in the sentence')

    newsentence = 'Hello this is not correct'
    new_words = ['this', 'correct']
    all_words = contain_allwords(newsentence,new_words)
    if all_words:
        print('All the words are in the sentence')
    else:
        print('Not all words were found in the sentence')


main()
    
