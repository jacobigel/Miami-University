# supply program prolog
# Author: Jacob Igel
# Email: igeljj@miamioh.edu
# Section: B
# Date: 9/27/19
'''
Purpose:To use math functions to create a calculator that will calculate the center and radius of a cirlce using three differnt points.
Input: Three different (x,y) points.
Output: The center and radius of a cirlce using those three points
'''


print("****Lighthouse Location Calculator****"); end='/n'
print(" ")


# These are all of the instances where the user inputs numbers split by a comma.

first_a, first_b = input("Enter the x and y of the first observer: " ).split(',')

first_a=float(first_a)
first_b=float(first_b)

second_c, second_d = input("Enter the x and y of the second observer: ").split(',')

second_c=float(second_c)
second_d=float(second_d)

third_e, third_f = input("Enter the x and y of the third observer: ").split(',')

third_e=float(third_e)
third_f=float(third_f)

print("The three observers are at")
print("(", first_a, ",", first_b,")")
print("(", second_c, ",", second_d, ")")
print("(", third_e, ",", third_f,")")

# This part of the code are the equations for the x and y vaules of the center of the circle.

import math

equation_x =(1/2)*((math.pow(first_a,2)+math.pow(first_b,2))*(third_f-second_d)+(math.pow(second_c,2)+math.pow(second_d,2))*(first_b-third_f) + (math.pow(third_e,2)+math.pow(third_f,2))*(second_d-first_b))/(first_a*(third_f-second_d)+second_c*(first_b-third_f) + third_e*(second_d-first_b))
equation_y =(1/2)*((math.pow(first_a,2)+math.pow(first_b,2))*(third_e-second_c)+(math.pow(second_c,2)+math.pow(second_d,2))*(first_a-third_e)+(math.pow(third_e,2)+math.pow(third_f,2))*(second_c-first_a))/(first_b*(third_e-second_c)+second_d*(first_a-third_e)+third_f*(second_c-first_a))

a_minus_x = first_a - equation_x
b_minus_y = first_b - equation_y
radius = math.sqrt(math.pow(a_minus_x,2)+math.pow(b_minus_y,2))

print("The center of the cirlce is at: ","(", equation_x, ",", equation_y,")")
print("The radius of the cirlce is: ",radius)






