def get_names():
    name_list=[]
    for i in range(1,3):
        name = input(' Your name ')
        name_list.append(name)
    return name_list

def reverse(input_list,fname):
    with open (fname, 'w') as fn:
        for name in input_list:
            names = name.split()
            print(f'Reversed name is {names[1]}, {names[0]}', file=fn)
        
def main():
   name_list = get_names()
   reverse(name_list,'names.txt')

main()
 
