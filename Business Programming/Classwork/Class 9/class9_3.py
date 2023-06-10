num_list1 = [1,1,2,2,3,4,4]
print(num_list1[2:6:2])

print(num_list1[::-1])



# histogram
# 1 - 2, 2 - 2, 3 -1, 4 - 2
## setify the list
## use the items in the setified list - to count how many times each element
## occurs in the num_list1

def setify(in_list):
    out_list=[]
    for elt in in_list:
        if elt not in out_list:
            out_list.append(elt)
    return out_list

def histogram(in_list, in_set):
    for elt in in_set:
        print(elt, in_list.count(elt))

def main():
    num_list = [1,1,2,2,3,4,4]
    num_set = setify(num_list)
    print(num_set)
    histogram(num_list, num_set)
    

main()



str1 ='Hello'
def chk_str(in_str):
    if type(in_str) is not str:
        print('Error')
    else:
        print(True)

chk_str(str1)
chk_str(1000)
