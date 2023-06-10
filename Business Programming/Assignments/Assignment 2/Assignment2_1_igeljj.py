# Jacob Igel ISA 281 - B



user_list = []
user_input = ''
def get_list_of_words():
    '''
    this checks the user input for a string value then puts them in a list called user_list
    '''
    user_input = ''
    while user_input != 'quit':
        user_input = str(input("Please enter a word or enter 'quit': "))
        if user_input != 'quit':
            user_list.append(user_input)
    return user_list
 
get_list_of_words()


def print_sorted(in_list):
    '''
    this sorts the list and adds an ',' for every element. Once it reaches the last element,
    an empty line will be placed 
    '''
    rev_list = sorted(in_list, reverse=True)
    new_list = ''
    last_elt = len(rev_list)-1
    for i in rev_list:
        if i == rev_list[last_elt]:
            i = i + '\n' # this is so that when the loop is done, there is a space between this and list of numbers
        else:
            i = i + ' , '
        new_list = new_list + i
    print(new_list)

print_sorted(user_list)

def main():
    user_list = get_list_of_words()
    print_sorted(user_list)
    

user_list = []
user_input = ''
def get_list_of_numbers():
    '''
this funtion is almost exactly the same as the list of words above without the use of the print_sorted function
we have used
    '''
    user_input = ''
    while user_input != 'quit':
        user_input = str(input("Please enter a number or enter 'quit': "))
        '''
we have to use the 'str' above to make sure we can input the word 'quit' and numbers without
having any errors pop up. We fix the numbers being a string below when we say that
user_input = int(user_input)
        '''
        if user_input != 'quit':
            user_input = int(user_input)
            user_list.append(user_input)
        else:
            return user_list

get_list_of_numbers()


print(user_list)





    


