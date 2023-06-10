import pickle

def write_dict_to_file(dictionary, filename):
    with open(filename, 'w') as fn:
        for k, v in dictionary.items():
            print(k,file=fn)
            print(v,file=fn)

def read_dict_from_file(filename):
    dictionary = {}
    with open(filename, 'r') as fn:
        my_list = list(fn)
    for i in range(0,len(my_list),2):
        temp_k = my_list[i].strip()
        k = int(temp_k)
        v = my_list[i+1].strip()
        dictionary[k] = v
    return dictionary

def write_to_file(dictionary,filename):
    # use pythons pickle operator
    # note theb or binary write
    # cannot be opened in notepad or an editor
    with open(filename, 'wb') as fn:
        pickle.dump(dictionary,fn)

def read_from_file(filename):
    with open(filename, 'rb') as fn:
        stored_dict = pickle.load(fn)
    return stored_dict

def main():
    in_dict = {1:'oak', 2:'ash',3:'lime'}
    filename = 'out_92.txt'
    write_dict_to_file(in_dict,filename)
    new_dict = read_dict_from_file(filename)
    print(new_dict)
    write_to_file(in_dict,'out92a.bin')#.bin = binary
    returned_dict = read_from_file('out92a.bin')
    print(returned_dict)

main()

