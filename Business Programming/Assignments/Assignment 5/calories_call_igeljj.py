# Jacob Igel ISA 281

import sys
import calories_igeljj


def main():
    cmd = sys.argv[1]
    print (cmd)
    if cmd == 'list':
        name = sys.argv[2]
        date = sys.argv[3]
        row1 = calories_igeljj.list(name, date)
        print(row1)
    elif cmd == 'total':
        name = sys.argv[2]
        date = sys.argv[3]
        row2 = calories_igeljj.total(name, date)
        print(row2)
    elif cmd == 'eaten':
        name = sys.argv[2]
        food = str(sys.argv[3])
        amount = int(sys.argv[4])
        calories_igeljj.eaten(name, food, amount)

main()
