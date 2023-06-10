import csv

def get_records(tipsreader):
        header = next(tipsreader) # 'next' commands reads the next line
        tips_indx = header.index('tip')
        time_indx = header.index('time')
        tips_time_list = [(float(next_line[tips_indx]), next_line[time_indx]) for next_line in tipsreader]
        return tips_time_list

def calc_averages(tips_time_list):
    tips_list = [tips for tips,time in tips_time_list]
    time_list = [time for tips,time in tips_time_list]
    largest_tip = max(tips_list)
    indx = tips_list.index(largest_tip)
    '''
    print(f'The largest tip was made during {time_list[indx]}')
    print(f'The largest tip is {largest_tip}')
    print(f'Average tip is {round(sum(tips_list)/len(tips_list),2):4.2f}')
    '''
    return largest_tip, time_list[indx], round(sum(tips_list)/len(tips_list),2)
    
def main():
    filename = 'tips.csv'
    with open(filename, newline ='') as f:
        tipsreader = csv.reader(f)
        tips_time_list = get_records(tipsreader)
        largest_tip, time, avg = calc_averages(tips_time_list)
        print(f'The largest tip was {largest_tip:5.2f} made during {time}.')#4.2f four characters long,
        print(f'The average tip however was only {avg:4.2f}') #two decimals to the right
       
main()
