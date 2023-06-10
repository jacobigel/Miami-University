def safe_int(string):
    try:
        result = int(string)
    except ValueError as e:
        print(f'{string} not convertible to interger')
        result = None
    return result

# if inpt is none, returns false, otherwise true
def not_none(inpt):
    return inpt is not None

'''
print(safe_int('10'))
print(safe_int('Tree'))
'''

def main():
    s =['1','10','ten','tree']
    '''
    int_list = []
    for elt in s:
        if safe_int(elt) is not None:
            int_list.append(elt)
    '''
#    int_list = [safe_int(elt) for elt in s if safe_int(elt) is not None]
    int_list = list(filter(not_none,map(safe_int,s)))
    print(int_list)
    
main()
