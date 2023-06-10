def times_table(n):
    for i in range (1,n+1):
        for j in range(1,11):
            print(f'{i*j:4d}' ,end=' ')
        print()

def write_times_table(n,filename):
    with open (filename, 'w') as fn:
        print('Demo in class by Igel', file=fn)
        for i in range (1,n+1):
            for j in range(1,11):
                print(f'{i*j:4d}' ,end='  ',file=fn)
            print()


def main():
    times_table(5)
    write_times_table(5,'timestable.txt')

main()
