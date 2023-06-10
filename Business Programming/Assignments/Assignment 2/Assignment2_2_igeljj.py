# Jacob Igel ISA 281 - B


option_a_numbers = [18, 21, 11, 21, 15, 19, 17, 21, 17]
option_b_numbers = [18, 21, 17, 11 ,21, 15, 19, 17, 21, 17]
option_c_numbers = [18, 21, 17, 11, 15, 19]


def setify(in_list):
    '''
    removes duplicates by copying into a new list
    and checking if it already exists in the new list
    '''
    out=[]
    for elt in in_list:
        if elt not in out:
            out.append(elt)
    return out

def histogram(in_list, in_set):
    out=[]
    for elt in in_set:
        out.append(in_list.count(elt))
    return out
    

def find_all_indexes(in_list, val):
    out = []
    for indx, elt in enumerate(in_list):
        if elt == val:
            out.append(indx)
    return out

#----------------------------------
'''
this is the main specific for option a
with this, we can go through finding the amount of times each index value shows up,
then finding the max value of that to then output our actual value from the index
'''
def main():
    num_list = option_a_numbers
    set_list = setify(num_list)
    count_list = histogram(num_list,set_list)
    '''
the blocked out code is just to keep track of what exactly is coming out so that I can explain each part of my
code and the output associated with it.
    '''
    #print(num_list)
    #print(set_list)
    #print(count_list)
    max_value = max(count_list)
   # print(max_value)
    indx_list = find_all_indexes(count_list, max_value)
    #print(indx_list)
    print('Testing Option A')
    for indx in indx_list:
        print('The mode is ', set_list[indx]) 
        
        
main()


#----------------------------------

def main():
    num_list = sorted(option_b_numbers)
    set_list = setify(num_list)
    count_list = histogram(num_list,set_list) 
    max_value = max(count_list)
    indx_list = find_all_indexes(count_list, max_value)
    print('Testing Option B')
    full_list = []
    '''
the code below finds all of the code that has as max value of occurances from option b
and then puts them in a list. Once they are in a list, we can then print those values.
    '''
    for indx in indx_list:
        full_list.append(set_list[indx])
    print('The mode is ', full_list)
        
        
main()


#----------------------------------

def main():
    num_list = option_c_numbers
    full_list = []
    set_list = setify(num_list)
    count_list = histogram(num_list,set_list) 
    max_value = max(count_list)
    indx_list = find_all_indexes(count_list, max_value)
    print('Testing Option C')
    '''
if all of the values are the same/the max value of each element is one then we just have to
return that no mode exists
    '''
    if max_value == 1:
        print('The mode is No mode exists: All numbers have equal frequencies')

main()
