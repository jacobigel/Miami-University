'''
Write a function to add the numbers in a tuple. For example, sum_all(1, (1, 2), 3) should yield 7.
You will need to distinguish between integers and tuples by
using the test type(x) == int, which is True if the type of x is int.
'''

def sum_all(tpl):
    total = 0
    for elem in tpl:
        if type(elem) == int:
            total += elem
        elif type(elem) == tuple:
            total += sum_all(elem)
    return total


            
def main():
    t = (1,(1,2),3)
    ttl = sum_all(t)
    print(ttl)

main()
