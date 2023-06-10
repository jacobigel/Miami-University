import datetime

def date_today():
    d = datetime.date.today()
    # d.year, d.day, d.month will produce the time respectfully
    # yyyy-mm-dd
    #print(f'{d.year:4d}-{d.month:2d}-{d.day:2d}')
    print(d) # international format
    print(f'{d.month:02d}/{d.day:02d}/{d.year:4d}') # US format
    return d
    

#date_today()



def main():
    jan012000 = datetime.date(2000,1,1)
    curr_date = date_today()
    print(curr_date - jan012000)
    curr_time = datetime.datetime.now()
    print(curr_time)
    # hour, minute
    print(curr_time.hour, curr_time.minute, curr_time.second)

main()
