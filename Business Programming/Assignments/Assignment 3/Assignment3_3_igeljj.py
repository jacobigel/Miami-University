# Jacob Igel - ISA 281

hrs1 = 'John,10,20'
hrs2 = 'Jane,10,25'
hrs3 = 'Jess,12,10'
hrs4 = 'James,8,10'
hours_worked = [hrs1,hrs2,hrs3,hrs4]



def print_salary(person):
    '''
defines every part of the salary for specific people and converts it into formatting to make things easier.
    '''
    per = person
    per_list = per.split(',')
    name = per_list.pop(0)
    hours = per_list.pop(1)
    hourly_rate = per_list.pop(-1)
    tot_sal = int(hours)*int(hourly_rate)
    print (f'{name} worked {str(hours)} at a ${str(hourly_rate)} hourly rate. The total salary is {str(tot_sal).zfill(5)}.')



def main():
    '''
This incorporates the print_salary function to put hrs 1-4 for every worker into
the print statement automatically using formatting
    '''
    print_salary(hrs1)
    print_salary(hrs2)
    print_salary(hrs3)
    print_salary(hrs4)

main()
    
