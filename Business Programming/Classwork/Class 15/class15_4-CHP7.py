'''
Write the function union(a, b) which forms the union of two dictionaries.
The union of two dictionaries is the dictionary containing all the entries
in one or other or both. In the case that a key is contained in
both dictionaries, the value in the first should be preferred.
'''

import copy

def union(d1,d2):
    d_out =  copy.deepcopy(d1)
    for k,v in d2.items():
        if k not in d_out:
            d_out[k] = v
    return d_out

def reverse(d1):
    d_out = {v:k for k,v in d1.items()}
    return d_out

def main():
    days_in_month1 = {'Jan': 31, 'Feb': 28, 'Mar': 31, 'Apr': 30}
    days_in_month2 = {'Jan': 31, 'Sep': 30, 'May': 31, 'Apr': 30}
    days_in_cal_month = union(days_in_month1,days_in_month2)
    print(days_in_cal_month)
    print(reverse(days_in_cal_month)) # updates the values with newer keys
    #updates 31 with May from Jan, Feb stays the same, 30 with Sep from Apr etc.

main()
    
