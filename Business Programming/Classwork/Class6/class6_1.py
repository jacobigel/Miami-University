# Starting out with review from last class
'''
def get_name():
    name = input('What is your name: ')
    return name

def get_multiple_times():
     entered = ' '
     while entered != 'Done':
         print(get_name())
         entered =  input("Enter another or type 'Done' to quit: ")


def main():
    numtimes = input('How many times? ')
    numtimes = int(numtimes)
    for i in range(numtimes):
        print('Running for the ' +  str(i)  + ' time')
        entered = ' '
        while entered != 'Done':
            print(get_name())
            entered =  input("Enter another or type 'Done' to quit: ")
            get_multiple_times()

main()
'''
# Now onto the class 
def get_name():
    name = input('What is your name: ')
    return name

def get_multiple_times():
     entered = ' '
     while True:
         print(get_name())
         entered =  input("Enter another or type 'Done' to quit: ")
         if entered == 'Done':
             break;


def main():
    numtimes = input('How many times? ')
    numtimes = int(numtimes)
    for i in range(numtimes):
        print('Running for the ' +  str(i)  + ' time')
        get_multiple_times()

main()
