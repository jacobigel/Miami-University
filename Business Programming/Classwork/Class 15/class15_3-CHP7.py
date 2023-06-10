'''
Write a function unzip which, given a dictionary, returns a pair of lists,
the first containing the keys and the second the corresponding values.
'''

# hard way without dictionary comprehension
def unzip(in_dict):
    key_list = []
    value_list =  []
    for k,v in in_dict.items():
        key_list.append(k)
        value_list.append(v)
    return (key_list,value_list)

def test():
    key_list = [1,2]
    val_list = ['one','two']
    zipped = zip(key_list,val_list)
    print(dict(zipped)) # dict is the important piece to include


def main():
    '''
    tel_num = {'A':4826,'B':4835, 'C':4830,'D':4940}
    k_list,v_list = unzip(tel_num)
    print(f'The keys are {k_list}')
    print(f'The values are {v_list}')
    '''
    test()
main()

print('#--------------------------')

'''
Month names  jan, feb, mar, apr

num days 31 28 31 30

-- modify test to take two parameters, key_list & val_list
-- and return a zipped dictionary

use it to call test from the main

ex. {'jan':31, 'feb':28, ...}
print in the main
'''

def test(key_list,val_list):
    zipped = zip(key_list, val_list)
    return (dict(zipped))

def main():
    key_list = ['Jan', 'Feb', 'Mar', 'Apr']
    val_list = [31, 28, 31, 30]
    print(test(key_list,val_list))
    

main()
