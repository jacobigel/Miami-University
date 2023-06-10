import sys
import class24_2

def main():
#    row = class24_2.get_person('Alice')
#    print(row)
    cmd = sys.argv[1]
    if cmd == 'get':
        name = sys.argv[2]
        row = class24_2.get_person(name)
        print(row)
    elif cmd == 'add':
        name = sys.argv[2]
        age = int(sys.argv[3])
        height = int(sys.argv[4])
        weight = float(sys.argv[5])
        class24_2.insert_person(name,age,height,weight)

main()
