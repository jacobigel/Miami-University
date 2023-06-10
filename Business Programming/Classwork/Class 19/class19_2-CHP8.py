def main():
    filename = 'gregor.txt' #type gregory.txt instead and see what happens
    try:
        with open(filename) as f:
            contents = f.read()
    except FileNotFoundError:
        print(f'Sorry the file {filename} does not exist.')
    else:
        words = contents.split()
        num_words = len(words)
        print(f'The file {filename} has {num_words} words')


main()


