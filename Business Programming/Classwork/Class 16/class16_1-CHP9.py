'''
def main():
    f = open('gregor.txt','r') # defult mode is read or r
    content = f.read(12) #reads the entire file
    print(f'{content}')
    content1 = f.read(10)
    print(f'{content1}')
    
    f.close() # as soon its done reading, close the file
    
main()



def main():
    f = open('gregor.txt','r') # defult mode is read or r
    line = f.readline() #reads the entire file
    print(f'{line}', end = '') # automatically will put a '\n' so to have no space use end = ''
    line = f.readline()
    print(f'{line}',end = '')
    
    f.close() # as soon its done reading, close the file


## line has a type str
def main():
    f = open('gregor.txt','r') # defult mode is read or r
    for line in f: # another way to read through the entire file
        print(f'{line}', end = '')
    f.close()
'''
def main():
    f = open('gregor.txt','r') # defult mode is read or r
    line_list= f.readlines()
    print(f'{line_list}')
    f.close()
# produces a \n since everything is in a list so it cannot make new lines so its shows you
# where the new lines are supposed to be located
main()


