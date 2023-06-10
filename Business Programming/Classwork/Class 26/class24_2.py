import sqlite3

def get_person(name):
    conn = sqlite3.connect('person.db')
    cur = conn.cursor()

    sql_str = '''
        Select name, age
        from person
        where name = :person_name
        '''

    cur.execute(sql_str,{'person_name':name})

    row = cur.fetchone()
#   print (row)

    cur.close()
    conn.close()
    return row

def get_next_id():
    conn = sqlite3.connect('person.db')
    cur = conn.cursor()

    sql_str = '''
        Select max(id)+1
        from person 
        '''

    cur.execute(sql_str)

    row = cur.fetchone()
    (nextid,) = row
    print (row)

    cur.close()
    conn.close()
    return nextid

def insert_person(n,a,h,w):
    conn = sqlite3.connect('person.db')
    cur = conn.cursor()
    nextid = get_next_id()
    sql_str = '''
        insert into person (id,name,age,height,weight)
        values (?,?,?,?,?)
         '''

    cur.execute(sql_str,(nextid,n,a,h,w))

    conn.commit()
    cur.close()
    conn.close()
    return None

def main():
    get_person('Alice')
    get_person('Bob')


if __name__ == '__main__':
    main()
