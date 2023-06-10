# Jacob Igel ISA 281

import sqlite3
import datetime

#1
def list(name, date):

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
    column_names = [column[0] for column in cur.description] # this gets the headers to use in the next print
    print(f'{column_names[0]:30s} {column_names[1]}')
    print(f"{'-'*50:50}") # this is used to put a line between the headers and the information found
    for row in rows:
        Name, Amount = row
        print(f'{Name:30} {Amount}')
    print() # I put this print in to separate the two functions
    cur.close()
    conn.close()
    
#----------------------------------------------------------------------------
#2
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
    
    column_names = [column[0] for column in cur.description] # this gets the headers to use in the next print
    print(f'{column_names[0]:25} {column_names[1]:30} {column_names[2]} ')
    print(f"{'-'*80:80}")  # this is used to put a line between the headers and the information found
    for row in rows:
        Name, Date, TotalCalories = row
        print(f'{Name:20} {Date:20} {TotalCalories:20}')
    cur.close()
    conn.close()
    
#----------------------------------------------------------------------------
#3
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
'''
I use the three funcitons food_id, user_id, and date_today to insert the specific values needed into
the final function eaten. This helps make things a little easeir and it also helps to break up the function eaten
into different parts so I am not doing all of that in that function.
'''
#----------------------------------------------------------------------------
    
def main():
    list('Robert', '01/01/2020')
    total('Robert', '01/01/2020')
    #eaten('Robert','Peas',100)

if __name__ == '__main__':
    main()
