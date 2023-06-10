import csv

def main():
    filename = 'tips.csv'
    with open(filename, newline ='') as f:
        tipsreader = csv.reader(f)
        header = next(tipsreader) # 'next' commands reads the next line
        print(header)
        tips_indx = header.index('tip')
        time_indx = header.index('time')
        print(tips_indx)
        tips_list = []
        time_list = []
        #next_line = next(tipsreader)
        #print(next_line)
        #print(next_line[tips_indx])
        for next_line in tipsreader:
            # I know tips is numeric, so converting to float
            tips_list.append(float(next_line[tips_indx]))
            time_list.append(next_line[time_indx])
        print(tips_list)
        print(time_list)
        print(f' Average tip is {round(sum(tips_list)/len(tips_list),2):4.2f}')

main()
