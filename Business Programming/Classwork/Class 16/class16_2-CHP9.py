'''
def main():
    # 'with' ALWAYS closes the reading of the file, no need to explicitly do it or f.close
    with open('gregor.txt', 'r') as fn_in, open ('out.txt','w') as fn_out:
        print(f'{list(fn_in)}', file=fn_out)

main()
'''

def main():
    with open('gregor.txt', 'r') as fn_in, open ('out.txt','w') as fn_out:
        line_list = list(fn_in)
        count = 0
        for line in line_list:
            count +=1
            print(f'{line}', file=fn_out, end = '')
            if count == 3: break
              
main()

