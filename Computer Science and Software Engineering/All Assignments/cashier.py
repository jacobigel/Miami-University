# supply program prolog
# Prolog
# Author: Jacob Igel
# Email: igeljj@miamioh.edu
# Section: B
# Date: 9/18/19

# Purpose: In this lab, we are creating a program that will calulate change that the user will get back from the cashier


print("Change Calculator") # Descriptor of program 

# Requesting input of proce from the cashier in cents
price = 100 * float(input("Enter the price of the item bought: "))

# Requesting input of amount of money given to the cashier in cents
pay = 100 * float(input("Enter the amount of money you can give the cashier: "))

change = pay - price
dollar=100
quarter=25
dime=10
nickel=5
penny=1

num_dollars = int(change  / dollar)
change = change % dollar


num_quarters = int(change / quarter)
change = change % quarter

num_dimes = int(change / dime)
change = change % dime

num_nickels = int(change / nickel)
change = change % nickel

num_pennies = int(change/ penny)


print("Your change:")
print("   Dollars:    ", num_dollars)
print("   Quarters:   ", num_quarters)
print("   Dimes:      ", num_dimes)
print("   Nickels:    ", num_nickels)
print("   Pennies:    ", num_pennies)

print("Thank you for your business")

