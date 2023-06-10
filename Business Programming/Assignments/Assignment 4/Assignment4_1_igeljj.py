# Jacob Igel - ISA 281B

def create_dict_from_string(stmt):
    raw_lst = stmt.split() # this is used to split each word 
    
    word_lst = []
    '''
this will go through the list and return the lowercase (lower function) of every word
then append the word_lst with all lower case from the string
    '''
    for x in raw_lst:
        if x.lower() not in  word_lst:
            word_lst.append(x.lower())
            '''
this will then match the index with each item in the raw_lst and then put it into a dictionary with
the corresponding index
'''
    temp_dict = {}
    for index_of_word, word in enumerate(raw_lst):
        temp_dict[word.lower()] = index_of_word
    return temp_dict


def find_longest_word(dictionary):
    max_len = -1
    for elt in dictionary.keys():
        if len(elt) > max_len:
            max_len = len(elt)
            result = elt
    return (result, dictionary[elt]) #returns a tuple

def main():
    stmt = 'In spring 2021, I took a python class in a hybrid environment'
    dictionary = create_dict_from_string(stmt)
    longest_value = find_longest_word(dictionary) #unpacks the tuple
    print(dictionary)
    print(f'The longest word is {longest_value[0]} and is word {longest_value[1] + 1} within the string')

main()
    

