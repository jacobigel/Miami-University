## csv files
s1 = 'John Doe, 20,10,20,20,15'

def calc_score(student):
    st = student
    st_list = st.split(',')
    # print(st_list)
    name = st_list.pop(0)
    # print(name, st_list)
    total = 0
    for score in st_list:
        total+= int(score)
    print(name + ' has a score of ' + str(total) + '.')


def main():
    s1 = 'John Doe, 20,10,20,20,15'
    s2 = 'Jane Doe, 20,20,20,20,20'
    student_list = [s1,s2]
    for student in student_list:
        calc_score(student)
main()
