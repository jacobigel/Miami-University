import sqlite3

conn = sqlite3.connect('person.db')
cur = conn.cursor()

sql_str = '''
    Select name, age
    from person
    where name = :person_name
    '''

cur.execute(sql_str,{'person_name':'Bob'})

row = cur.fetchone()
print (row)

cur.close()
conn.close()
