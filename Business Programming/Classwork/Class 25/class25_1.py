import sqlite3
conn = sqlite3.connect('music.db')
cur = conn.cursor()

sql_str = '''
        SELECT Track.title as 'Title', track.len, Artist.name as 'Artist Name', Album.title,Genre.name as 'Genre Name' , Track.rating, Track.count
        FROM Artist 
        JOIN Album on Album.artist_id = Artist.id
        JOIN Track on album.id = track.album_id
        JOIN Genre on Genre.id = Track.genre_id;
                '''

cur.execute(sql_str)
rows = cur.fetchall()
# cur description - for every column it has some metadata, the first element in that meta data is the
# title for the coulmn
column_names = [column[0] for column in cur.description]
print(f'{column_names[0]:20s} {column_names[1]:10s} {column_names[2]:20s} {column_names[3]:10s} \
      {column_names[4]:20s} {column_names[5]:10s} {column_names[6]:10s}')
print(f"{'-'*100:100s}")
for row in rows:
    Title, Length, Artist, Album, Genre, Rating, Count = row
    print(f'{Title:20s} {Length:4d} {Artist:20s} {Album:20s} {Genre:20s} {Rating:4d} {Count:4d} ')

cur.close()
conn.close()
