def check_errors():
    #print('in check error')
    
    try:
        #f = open('nosuchfile.txt')
        num1 = int(input('Enter a number: '))
        num2 = int(input('Enter a second number: '))
        
        total = num1+ num2
        result = num1/num2
        #print(total)
    except TypeError:
        print('One if the numbers is not an integer')
        total =  None #if not here, will cause a unboundlocalerror
    except ZeroDivisionError as e:
        print(f'The divisor is {num2}.')
        raise e #reraise bc you want program to stop with this 
        #result = None
    except FileNotFoundError:
        print('File does not exist')
    except Exception as e: # will handle ALL errors
        print(e)
        #total = None
        #result = None

    else:
        '''
Else executes when the try is completed without an error
        '''
        return total,result


    finally: # used to clean up the code - mostly for closing the file. Won't use a lot.
        # this will always execute, regardless of whats above being True or False
        print('In finally')
        
    


def main():
    while True:
        returned_tuple = check_errors()
        if returned_tuple is not None:
            total, result = returned_tuple
            print(total, result)
        another = input('Another one ')
        if another == 'q':
            break

main()
