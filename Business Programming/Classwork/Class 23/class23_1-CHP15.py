import sqlite3


'''
connect()
|
connection object
|
cursor()
|
cursor object
|
excecute(query)
|
results

'''
## Set up connection and cursor
conn = sqlite3.connect('person.db')
cur =  conn.cursor()

## Ensure your SQL string is written correctly
sql_str = '''
                SELECT name, age
                FROM person;
                '''
## Execute and retrieve results
cur.execute(sql_str)
rows = cur.fetchall()
print("Persons:")
for person in rows:
    name, age = person
    print(name, age, sep = '\t') # unpacking the Tuple

## Close the cursor and connection
print(rows)
cur.close()
conn.close()
