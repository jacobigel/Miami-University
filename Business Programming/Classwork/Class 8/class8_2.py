primes = [2,3,5,7,11,13,19]

def reverse_list(in_list):
    out = []
    length = len(in_list)
    for i in range(1,length+1):
        out.append(in_list[-i])
    return out

rev_primes = reverse_list(primes)
print(rev_primes)

## Setify
# [1,2,3,2,1]
# [],[1],[1,2],[1,2,3]

'''
    removes duplicates by copying into a new list
    and checking if it already exists in the new list
     | | |
    VVV
'''

def setify(in_list):
    out=[]
    for elt in in_list:
        if elt not in out:
            out.append(elt)
    return out
    
dup_list=[1,3,3,4,2,1]
set_list=setify(dup_list)
print(set_list)
