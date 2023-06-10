txt = 'but soft what light in yonder window breaks'
# creating a list of tuples with each tuple being the work length and then the word
# tuple for 'but' would be (3,but) and soft would be (4,soft) and so on

word_list = txt.split()
print(word_list)

## list comprehension
list_tuples = [(len(word),word) for word in word_list]
print(list_tuples)
list_tuples.sort(reverse = True)
print(list_tuples)

