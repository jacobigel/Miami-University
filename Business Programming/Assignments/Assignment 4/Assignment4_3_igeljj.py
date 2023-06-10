# Jacob Igel - ISA 281B

import csv
def get_average(filename):
    with open(filename) as f:
        names = csv.reader(f)
        header = next(names)
        '''
this is to get all of the different headers to point them out easily with the index function
        '''
        grade_indx = header.index('grade')
        gender_indx = header.index('gender')
        male = []
        female = []
        for row in names:
            if row[gender_indx] == 'female':
                female.append(float(row[grade_indx]))
            else:
                male.append(float(row[grade_indx]))
        '''
The next two lines are for finding the average of both male and female scores
        '''
        female_avg = sum(female)/len(female)
        male_avg =sum(male)/len(male)
        print(f'The average grade for women is {female_avg:.1f}.')
        print(f'The average grade for men is {male_avg:.1f}.')
        print(f'There were {len(female)} women and {len(male)} men in the data.')

def main():
    get_average("gradedata.csv")
    
main()
