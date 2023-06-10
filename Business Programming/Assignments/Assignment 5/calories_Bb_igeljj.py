import sqlite3

def total(name, date):

    conn = sqlite3.connect('calories.db')
    cur = conn.cursor()

    sql_str = '''
            SELECT Name, Date, sum(FoodEaten.amount*Food.calories/Food.weight) AS 'totalcalories'
            FROM Food
            JOIN FoodEaten ON Food.FoodID = FoodEaten.FoodID
            JOIN User on FoodEaten.UserID = User.UserID
            WHERE User.Name = :Name AND FoodEaten.Date =:Date
            GROUP BY Name, Date
            '''

    cur.execute(sql_str,{'Name':name, 'Date':date})
    rows = cur.fetchall()
    
    column_names = [column[0] for column in cur.description]
    print(f'{column_names[0]:25} {column_names[1]:30} {column_names[2]} ')
    print(f"{'-'*60:60}")
    for row in rows:
        Name, Date, TotalCalories = row
        print(f'{Name:20} {Date:20} {TotalCalories:20}')
    cur.close()
    conn.close()

total('Robert', '01/01/2020')
