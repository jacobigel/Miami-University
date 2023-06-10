# Assignment 2 help



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

def histogram(in_list, set_list):
    out=[]
    for elt in set_list:
        out.append(in_list.count(elt))
    return out

def find_all_indexes(in_list, val):
    out = []
    for indx, elt in enumerate(in_list):
        if elt == val:
            out.append(indx)
    return out
    
def main():
    num_list = [11,12,13,11,12]
    set_list = setify(num_list)
    count_list = histogram(num_list,set_list) 
    #print(num_list)
   # print(set_list)
    #print(count_list)
    max_value = max(count_list)
   # print(max_value) # then find which indexes is equal to two
    indx_list = find_all_indexes(count_list, max_value)
    #print(indx_list)
    for indx in indx_list:
        print('The mode is ', set_list[indx]) 
        #print(set_list[indx])
        

main()
