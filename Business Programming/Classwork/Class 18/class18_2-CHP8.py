def add(num1,num2):
    total = num1 + num2
    return total # do not put print(total), only do return

def main():
    safe_division()
    '''
    try:
        x = int(input('Enter a number: '))
        y = int(input('Enter a second number: '))
        sum_xy = add(x,y)
        print(sum_xy)
        #print(total) - does not have a life in main so it will return an error
    except ValueError as e:
        print('Strings not allowed, please enter a digit')
    demo_dict()
    
def demo_dict():
    d = {'ISA 281':'Programming','ISA 245':'Database'}
    print(d['ISA 281'], d.get('ISA 281'))
    print(d.get('ISA 406')) # d.get is more forgiving and will just print 'None'
    try:
        print(d['ISA 406'])
    except KeyError as e:
        print('No corresponding key in this dictionary')
    '''
def safe_division():
    try:
        x = int(input('Enter numerator: '))
        y = int(input('Enter denominator: '))
        z = x/y
    except ZeroDivisionError as e:
        print(f'The denominator {y} cannot be zero.')
        return 0
    return z
main()
