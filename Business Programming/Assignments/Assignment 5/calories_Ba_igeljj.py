import sqlite3

def list_eaten(name, date):

    conn = sqlite3.connect('calories.db')
    cur = conn.cursor()

    sql_str = '''
            SELECT Food, FoodEaten.Amount
            FROM Food
            JOIN FoodEaten ON Food.FoodID = FoodEaten.FoodID
            JOIN User on FoodEaten.UserID = User.UserID
            WHERE User.Name = :Name AND FoodEaten.Date = :Date 
            '''

    cur.execute(sql_str,{'Name':name, 'Date':date})
    
    rows = cur.fetchall()
    column_names = [column[0] for column in cur.description]
    print(f'{column_names[0]:30s} {column_names[1]}')
    print(f"{'-'*30:30}")
    for row in rows:
        Name, Amount = row
        print(f'{Name:30} {Amount}')
        
    cur.close()
    conn.close()

list_eaten('Robert', '01/01/2020')
