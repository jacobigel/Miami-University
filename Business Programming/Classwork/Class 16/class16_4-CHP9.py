import csv

def main():
    filename = 'tips.csv'
    with open(filename, newline ='') as f:
        rdr = csv.DictReader(f)
        largest = 0
        for row in rdr:
            if float(row['tip']) > largest:
                largest = float(row['tip'])
        print(f'Largest tip is {largest}')
            #print(f"Tip is: {row['tip']} at {row['time']}")
            
main()
