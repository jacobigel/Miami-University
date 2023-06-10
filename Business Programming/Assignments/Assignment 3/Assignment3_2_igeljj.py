# Jacob Igel - ISA 281 B

input_str = 'Two pounds of plain flour, mixed with three pounds of self raising flour and six ounces of butter'


def find_all(search_str, target_str):
    '''
This is used to find all of the instances of the target within the search
    '''
    start_position = 0
    out = []
    while start_position <= len(search_str):
        start_position = search_str.find(target_str, start_position)
        if start_position == -1:
            return out
        else:
            out.append(start_position)
            start_position += 1
    return out


        
def main():
    with open ('assign3_2.txt', 'w') as fn:
        '''
This puts every print statement ending with ',file = fn' into a txt document called assign3_2.txt
        '''
        print('Content of assign3_2.txt', file=fn)
        print('Content of assign3_2.txt')# puts output in shell
        x = find_all(search_str = input_str, target_str = 'flour')
        print(f'The word flour was found at positions {x} in the given string',file=fn)
        print(f'The word flour was found at positions {x} in the given string') # puts output in shell
        start = x[0] + len('flour')
        end = x[1]
        between = input_str[start:end]
        print (f'The extracted text is: {between}',file=fn)
        print (f'The extracted text is: {between}')# puts output in shell


main()
