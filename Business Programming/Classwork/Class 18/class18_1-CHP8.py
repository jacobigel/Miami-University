## Dictionary
d={}
#d[key]=value
d['course']= 'ISA 281' 
print(d) # returns {'course': 'ISA 281'}
d['course'] ='ISA 406'
print(d) # returns {'course': 'ISA 406'} - updates the course

courses = ['ISA 281', 'ISA 245', 'ISA 406']
course_names = ['Programming', 'Database', 'Project Management']
x = zip(courses,course_names)
print (x) # returns <zip object at 0x7ffa76081dc0>
#d1=dict(x)
#print(d1) # returns {'ISA 281': 'Programming', 'ISA 245': 'Database', 'ISA 406': 'Project Management'}
#l1 = list(x)
#print(l1) # returns [('ISA 281', 'Programming'), ('ISA 245', 'Database'), ('ISA 406', 'Project Management')]

# using dictionary comprehension 
new_dict = {course:course_name for course, course_name in list(zip(courses,course_names))}
print(new_dict)

for k in new_dict.keys():
    print(k)

for v in new_dict.values():
    print(v)

print(list(new_dict.values()))

for k,v in new_dict.items():
    print(k,v)


##csv module
#csv.reader -- object then you have to know the index of each column
#csv.DictReader -- more simpler, because key is the could name for each row.
