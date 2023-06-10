# using 'continue'
while True:
    s = input('Enter something : ')
    if s == 'quit':
        break
    if len(s) < 3:
            print('Too small')
            continue
    print('Input is of sufficient length')


# using 'pass'
while True:
    s = input('Enter something : ')
    if s == 'quit':
        break
    if len(s) < 3:
        print('Too small')
        pass 
    print('Input is of sufficient length')


# There is no compulsion for the block to execute.
# ‘continue’ always goes back to the top of the loop however
#‘pass’ keeps moving on with the code flow during the processing.
