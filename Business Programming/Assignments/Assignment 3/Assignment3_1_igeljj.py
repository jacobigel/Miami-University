# Jacob Igel - ISA 281 B

def c2f(x):
    '''
A simple function that converts Celsius to Fahrenheit
    '''
    fahrenheit = (x * 9/5) + 32
    return fahrenheit


def clip(temperature):
    '''
This will help make sure the temperature is above 20 degrees
    '''
    if temperature < 20:
        return False
    else:
        return True
    
f_temp= []
f_temp2=[]
def main():
    c_temp =  [12,21,15,32,45]
    # Using loop - Fahrenheits
    '''
Uses a loop to convert everything in the list from C to F
    '''
    for elt in c_temp:
        f_temp.append(c2f(elt))
    print('Using loop - Fahrenheits')
    print(f_temp)

    
    #Using map - Fahrenheits
    '''
Uses a map to convert everything in the list from C to F
    '''
    result = (list(map(c2f,c_temp)))
    print('Using map - Fahrenheits')
    print(result)

    
    #Filtered input list
    '''
This uses the clip function from above to only get the C values over 20
    '''
    filtered_input = list(filter(clip, c_temp))
    print('Filtered Input List')
    print(filtered_input)

    
    #Mapping to Fahrenheits Filtered Input List
    '''
This reults from the clip function from above to only get the C values over 20 and convert
them in to Fahrenheits using map 
    '''
    filtered_map = list(map(c2f,filtered_input))
    print('Mapping to Fahrenheits Filtered Input List')
    print(filtered_map)

    #Using List Comprehension - Fahrenheits Filtered
    '''
This reults from the clip function from above to only get the C values over 20 and convert
them in to Fahrenheits using list comprehension 
    '''
    for elt in filtered_input:
        f_temp2.append(c2f(elt))
    print('Using List Comprehension - Fahrenheits Filtered')
    print(f_temp2)
    

main()

'''
I feel like using mapping is way easier and less complicated. Rather than having to make/define
new lists, you can jsut do all you need to do in one line of code.
'''
