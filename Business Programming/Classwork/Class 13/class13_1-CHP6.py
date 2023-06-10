score = 80
name = 'John Doe'
print(name + ' scored ' + str(score) + ' in the Quiz')
print(f'{name} scored {score} in the quiz')

## Formatting for the variables
## number s for strings
## number d for integers
## f - floating point numbers

print(f'{name:20s} scored {score:5.2f} in the quiz')


## strings are usally left justtifed but you can make them right justified:
## right justified a string by rjust
print(f'{name.rjust(20)} scored {score:5.2f} in the quiz')

## zfill a number -- 80, we can 0080
# only works on strings, not numbers

print(f'{name.rjust(20)} scored {str(score).zfill(5)} in the quiz')
