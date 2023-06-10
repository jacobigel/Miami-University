import sqlite3
#Connecting to sqlite
#Here I have assumed my database name is example.db
conn = sqlite3.connect('example.db')
#Creating a cursor object using the cursor() method
cursor = conn.cursor()

def list_eaten(name,date):
''' I have joined three tables and copied the result into Destination table for ease '''
sql = "CREATE TABLE Destination AS SELECT * from FoodEaten LEFT JOIN User ON FoodEaten.Userid = User.UserID LEFT JOIN Food ON FoodEaten.FoodID = Food.FoodID"
cursor.execute(sql)
rows = cursor.execute("SELECT Food,Amount FROM Destination WHERE Name = ? AND Date = ? ",(name,date)).fetchall()
print(rows)
cursor.execute("DROP TABLE Destination")


def total(name,date):
sql = "CREATE TABLE Destination AS SELECT * from FoodEaten LEFT JOIN User ON FoodEaten.Userid = User.UserID LEFT JOIN Food ON FoodEaten.FoodID = Food.FoodID"
cursor.execute(sql)
rows = cursor.execute("SELECT Name,Data,SUM((amount*calories)/weight) FROM Destination WHERE Name = ? AND Date = ?",(name,date)).fetchall()
print(rows)
cursor.execute("DROP TABLE Destination")

  
def eaten(name,food,weight):
getFoodId = cursor.execute("SELECT FoodID FROM FOOD WHERE FOOD = ?",(food)).fetchall()
getUserId = cursor.execute("SELECT UserID FROM User WHERE Name = ?",(name)).fetchall()

'''It is not gievn how the date is 04/18/2021 hence I am adding the this date statically'''
date = "04/18/2021"
query = "INSERT INTO FoodEaten VALUES(?,?,?,?)"
tuples = (getUserId,date,getFoodId,weight)
cursor.execute(query,tuples)
  
conn.commit()
#Closing the connection
conn.close()
