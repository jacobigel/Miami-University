# Author: Jacob Igel
# Email: igeljj@miamioh.edu
# Section B 
'''
The purpose of this task is to create a calculator that can add, subtract, multiply,and divide.
These operations will define the different opertations in the code:
'''


print("Select operation.")
print("   1.Add")
print("   2.Subtract")
print("   3.Multiply")
print("   4.Divide")

choice = int(input("Enter choice(1/2/3/4): "))

num1 = int(input("Enter first number: "))
num2 = int(input("Enter second number:"))

if choice == 1:
    print(num1, "+",num2, "=", num1+num2)

elif choice == 2:
    print(num1, "-" ,num2, '=', num1-num2)

elif choice ==3:
    print(num1, '*' ,num2, '=', num1*num2)

elif choice == 4:
    print(num1, '/' ,num2, '=', num1/num2)

else:
    print("Invalid Choice")

