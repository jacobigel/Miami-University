#Jacob Igel ISA 281 - B

names = ['John', ' ', 'Amanda', 5]

alphabet = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'
# instead of using .isalpha, we can use this to check the list if it contains letters from this instead

word= []
out_word = ''
def contains_onlyletters(word):
                if type(word) is str:
                        for alpha in word:
                                if alpha not in alphabet:
                                    '''
                                this will help us check if the word has letters in it from 'alphabet'
                                    '''
                                    return(False)
                        return(True)
                else:
                        return(False)


def main():
        for word in names: 
                chk_str = contains_onlyletters(word)
                if chk_str ==True: # if the word from contains only letters is true then it will print the word
                        print(word)

main()
