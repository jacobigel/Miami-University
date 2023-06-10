import sqlite3
import datetime

def food_id(food):
    conn = sqlite3.connect('calories.db')
    cur = conn.cursor()

    sql_str = '''
            SELECT Food.FoodID
            FROM Food
            JOIN FoodEaten ON Food.FoodID = FoodEaten.FoodID
            JOIN User on FoodEaten.UserID = User.UserID
            WHERE Food =  :Food
            '''
    
    cur.execute(sql_str,{'Food':food})
    conn.commit()
    rows = cur.fetchone()
    for row in rows:
        FoodID = row
    return row
   
    cur.close()
    conn.close()


def user_id(name):
    conn = sqlite3.connect('calories.db')
    cur = conn.cursor()

    sql_str = '''
            SELECT User.UserID
            FROM Food
            JOIN FoodEaten ON Food.FoodID = FoodEaten.FoodID
            JOIN User on FoodEaten.UserID = User.UserID
            WHERE Name = :Name
            '''
    cur.execute(sql_str,{'Name':name})
    conn.commit()
    rows = cur.fetchone()
    for row in rows:
        UserID = row
    return row
   
    cur.close()
    conn.close()

def date_today():
    date = datetime.date.today()
    date = (f'{date.month:02d}/{date.day:02d}/{date.year:4d}') # Correlates with date in DB
    return date

def eaten(name, food, amount):
    conn = sqlite3.connect('calories.db')
    cur = conn.cursor()
    
    Date = date_today()
    UserID = user_id(name)
    FoodID = food_id(food)
    
    sql_str = '''
            insert into FoodEaten (UserID,Date, FoodID, amount)
            values(?,?,?,?)
            '''
    
    cur.execute(sql_str,(UserID, Date, FoodID, amount))
    conn.commit()
    row = cur.fetchone()
    cur.close()
    conn.close()
    return row


eaten('Robert','Peas',100)
