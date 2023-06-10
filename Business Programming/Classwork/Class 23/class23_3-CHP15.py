import sqlite3
def retrieve_person(ind_name):
    ## Set up connection and cursor
    conn = sqlite3.connect('person.db')
    cur =  conn.cursor()

    ## Ensure your SQL string is written correctly
    sql_str = '''
                    SELECT *
                    FROM person
                    WHERE name = :person_name
                    '''
    ## Execute and retrieve results
    cur.execute(sql_str, {'person_name':ind_name})
    #rows = cur.fetchall()
    print("Person:")
    for person in cur:
        id, name, age,height, weight = person
        print(id, name, age,height, weight, sep = '\t') # unpacking the Tuple

    ## Close the cursor and connection
    #print(rows)
    cur.close()
    conn.close()
    return person

def main():
    retrieve_person('Freddie')

main()
