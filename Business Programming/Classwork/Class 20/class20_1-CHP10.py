def parse_decimal(num):
    if isinstance(num,float):
        s = str(num)
        nums = s.split('.')
        int_num = int(nums[0])
        dec_num = int(nums[1])
    return int_num, dec_num

def prod_int(x,y):
    if isinstance(x,float):
        int_x,dec_x = parse_decimal(x)
        dec_len_x = len(str(dec_x))
    else:
        dec_len_x = 0
        
    if isinstance(y,float):
        int_y,dec_y = parse_decimal(y)
        dec_len_y = len(str(dec_y))
    else:
        dec_len_y = 0
    
    whole_x = x *(10**dec_len_x)
    whole_y = y *(10**dec_len_y)

    prod_x_y = (whole_x * whole_y)/(10**(dec_len_x +dec_len_y))
    
    return prod_x_y



    

def main():
    int_num, dec_num = parse_decimal(2.34)
    print(int_num,dec_num)
    num1 = 145.1
    num2 = -2.34
    print(prod_int(num1,num2))

main()

    
