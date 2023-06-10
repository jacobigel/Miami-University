import sqlite3

def get_next_id():
    conn = sqlite3.connect('person.db')
    cur = conn.cursor()

    sql_str = '''
            select max(id)+1
            from person
            '''
    cur.execute(sql_str)

    row = cur.fetchone()
    (nextid,) = row
    #print(row)

    cur.close()
    conn.close()
    return nextid


def insert_person(i, n, a, h, w):
    conn = sqlite3.connect('person.db')
    cur = conn.cursor()


    sql_str = '''
            insert into person (id, name, age, height, weight)
            values(?,?,?,?,?)
            '''

    cur.execute(sql_str,(i, n, a, h, w))

    row = cur.fetchone()
    #print(row)
    
    conn.commit()
    cur.close()
    conn.close()
    return None


def main():
    nextid = get_next_id()
    print(nextid)
    insert_person(4, 'John', 20, 69, 150)
    insert_person(5, 'Doe', 30, 60, 150)
    
    
if __name__ == '__main__':
    main()
