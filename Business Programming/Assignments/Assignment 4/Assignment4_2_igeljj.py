# Jacob Igel - ISA 281B

import csv

def get_names(filename):
    with open(filename, 'r') as f:
        names = csv.reader(f)
        header = next(names)
        grade_indx = header.index('grade')
        grade_list = []
        '''
this for statement looks in grade_indx for grades that equal 100 and puts the entire row of information
into a list that we can then use in our function write_names
        '''
        for grade in names:
            if grade[grade_indx] == '100.0':
                grade_list.append(grade)
    return grade_list

def write_names(lst):
    with open('gradedata.csv','r') as fn_in, open("namelist.txt",'w') as fn_out:
        for indx in lst:
            '''
the split with the index returns the 7th row/address and finds the point after the first comma for city
and after the second comma for state.
            '''
            city = indx[7].split(', ')[1]
            state = indx[7].split(', ')[2]
            statement = (f'{indx[0]} {indx[1]} of {city}, {state[0:2]} scored a {float(indx[6]):.0f}')
            print(statement, file = fn_out)
            
    
def main():
    filename = 'gradedata.csv'
    top_scorers = get_names(filename)
    write_names(lst = top_scorers)

main()


