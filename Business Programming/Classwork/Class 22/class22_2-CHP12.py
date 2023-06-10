import sys
import textstat


def main():
    args = sys.argv
    print(args[0])
    print(args[1])
    filename = args[1]
    if len(args)> 2:
        print(args[2])
    with open(filename) as f:
        lines = textstat.count_lines(f)
    print(f'Num of lines {lines}')
        
    


main()
