#import decimal

from decimal import Decimal

#declare a variable
principal = Decimal('1000.00')
# use a string to help instantiate (assign a value)
#x = Decimal('145.1')
#y = Decimal('2.34')

#print(f'{x*y:10.6}') # 10 puts ten digits to the left, 6 puts up to 6 decimals if needed


rate = Decimal('.05')
amount = Decimal('0')

for year in range(1,11):
    amount = principal*(1+rate)**year
    print(f'{year:>2d} {amount:>20.2f}')

#right align is the >
#left align is the <
