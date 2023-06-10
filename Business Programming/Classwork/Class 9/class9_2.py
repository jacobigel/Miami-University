
# num_range = range(2,150,5)
num_list = list(range(2,150,5))
print(num_list)


num_list1 = [1,1,2,2,3,4,4]
num_set = set(num_list1) # do not use this in assignment 2
print(num_set)

'''
enumerate(num_list1)
0   1
1   1
2   2
3   2
4   3
5   4
6   4
'''
## To modify a list
# need to find the index of that number
# then change that indexes value to a new number

indx = num_list.index(32)
print(indx)
num_list[indx] = 33
print(num_list)

indx = num_list1.index(2)
print(indx)


def find_all(in_list,value):
    for i, elt in enumerate(in_list):
        if elt == value:
            print(i,elt)


def main():
    num_list1 = [1,1,2,2,3,4,4]
    find_all(num_list1,2)


main()

