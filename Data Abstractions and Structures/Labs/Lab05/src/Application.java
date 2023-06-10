/* 
Copyright Notice: This file is created by Seyed Mahdi Ghamkhari. All rights are reserved.
The file is provided to the students enrolled in sections E and F of the CSE 274 class in Fall 2022 semester. 
These students can use the file during the Fall 2022 semester for their education. 
Other uses of the file or distribution of the file is not permitted.
*/

/**
 * 
 * @author jacobigel
 *
 */

class HashTable

{

    private String[] InternalArray;

    private int arraySize;

    private int num;

    public HashTable(int size)

    {

        num = 0;

        arraySize = size;

        InternalArray = new String[arraySize];

        for (int j = 0; j < arraySize; j++) {
            InternalArray[j] = "**";
        }

    }

    public void displayTable()

    {

        System.out.println("Table: ");

        for (int j = 0; j < arraySize; j++)

        {

            System.out.print(InternalArray[j] + " ");

            if (j == Math.floor(arraySize / 2) - 1)
                System.out.print("\n");

        }

        System.out.println("");

    }

    public int hashFunc(String key)

    {

        int result = LetterToNumber(key.charAt(0))
                + LetterToNumber(key.charAt(1));

        return result % arraySize;

    }

    public void ProbeANDinsertNotForever(String key) {

        if (num == arraySize - 1)
            return;

        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].equals("**")) {
            if (InternalArray[hashIndex].equals(key))
                return;
            ++hashIndex;
            hashIndex = hashIndex % arraySize;

        }
        InternalArray[hashIndex] = key;
        num = num + 1;

        return;
    }

    public void ProbeANDdeleteButNoGapNotForever(String key)

    {

        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].equals("**"))

        {

            if (InternalArray[hashIndex].equals(key))

            {

                num = num - 1;

                while (!InternalArray[hashIndex].equals("**")) {

                    int NextIndex = (hashIndex + 1) % arraySize;
                    InternalArray[hashIndex] = InternalArray[NextIndex];
                    hashIndex = hashIndex + 1;
                    hashIndex = hashIndex % arraySize;

                }

                return;

            }

            ++hashIndex;

            hashIndex = hashIndex % arraySize;

        }

        return;

    }

    public void ProbeANDdeleteButNoGapNotForeverwithGap(String key)

    {

        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].equals("**"))

        {

            if (InternalArray[hashIndex].equals(key))

            {

                num = num - 1;

                while (!InternalArray[hashIndex].equals("**")) {

                    int NextIndex = (hashIndex + 1) % arraySize;

                    if (!InternalArray[NextIndex].equals("**"))
                        if (hashFunc(InternalArray[NextIndex]) == NextIndex) {
                            InternalArray[hashIndex] = "**";
                            return;
                        }

                    InternalArray[hashIndex] = InternalArray[NextIndex];
                    hashIndex = hashIndex + 1;
                    hashIndex = hashIndex % arraySize;

                }

                return;

            }

            ++hashIndex;

            hashIndex = hashIndex % arraySize;

        }

        return;

    }

    public boolean ProbeANDfind(String key)

    {

        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].equals("**"))

        {

            if (InternalArray[hashIndex].equals(key))

                return true;

            ++hashIndex;

            hashIndex = hashIndex % arraySize;

        }

        return false;

    }

    public int LetterToNumber(char ch)

    {

        int digit = 0;
        if (ch == 'A')
            digit = 0;

        if (ch == 'B')
            digit = 1;

        if (ch == 'C')
            digit = 2;

        if (ch == 'D')
            digit = 3;

        if (ch == 'E')
            digit = 4;

        if (ch == 'F')
            digit = 5;

        if (ch == 'G')
            digit = 6;

        if (ch == 'H')
            digit = 7;

        if (ch == 'I')
            digit = 8;

        if (ch == 'J')
            digit = 9;

        if (ch == 'K')
            digit = 10;

        if (ch == 'L')
            digit = 11;

        if (ch == 'M')
            digit = 12;

        if (ch == 'N')
            digit = 13;

        if (ch == 'O')
            digit = 14;

        if (ch == 'P')
            digit = 15;

        if (ch == 'Q')
            digit = 16;

        if (ch == 'R')
            digit = 17;

        if (ch == 'S')
            digit = 18;

        if (ch == 'T')
            digit = 19;

        if (ch == 'U')
            digit = 20;

        if (ch == 'V')
            digit = 21;

        if (ch == 'W')
            digit = 22;

        if (ch == 'X')
            digit = 23;

        if (ch == 'Y')
            digit = 24;

        if (ch == 'Z')
            digit = 25;
        return digit;
    }

    public void deleteMinus(String key) {
        int hashIndex = hashFunc(key);
        while (!InternalArray[hashIndex].equals("**")) {
            if (InternalArray[hashIndex].equals(key)) {
                InternalArray[hashIndex] = "--";
                return;
            }
            ++hashIndex;
            hashIndex = hashIndex % arraySize;
        }
        return;
    }

    public void insertMinus(String key) {
       
            
        int hashIndex = hashFunc(key);
        while (!InternalArray[hashIndex].equals("**")) {
            num++;
            if (InternalArray[hashIndex].equals(key)) {
                return;
            }
            ++hashIndex;
            hashIndex = hashIndex % arraySize;
        }

        hashIndex = hashFunc(key);
        while (!(InternalArray[hashIndex].equals("**"))
                && !(InternalArray[hashIndex].equals("--"))) {
            ++hashIndex;
            hashIndex = hashIndex % arraySize;
        }

        if(arraySize - num != 1) {
            InternalArray[hashIndex] = key;
            return;
        }
        
        
        return;
    }
    
    public boolean findMinus(String key) {
        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].equals("**"))

        {

            if (InternalArray[hashIndex].equals(key))

                return true;

            ++hashIndex;

            hashIndex = hashIndex % arraySize;

        }

        return false;

    }

}

class Application

{

    public static void main(String[] args)

    {

//        HashTable myhashtable = new HashTable(52);
//        myhashtable.ProbeANDinsertNotForever("FL");
//        myhashtable.ProbeANDinsertNotForever("CO");
//        myhashtable.ProbeANDinsertNotForever("ME");
//        myhashtable.ProbeANDinsertNotForever("MI");
//        myhashtable.ProbeANDinsertNotForever("SC");
//        myhashtable.ProbeANDinsertNotForever("NH");
//        myhashtable.displayTable();

//        HashTable myhashtable = new HashTable(52);
//        myhashtable.ProbeANDinsertNotForever("FL");
//        myhashtable.ProbeANDinsertNotForever("CO");
//        myhashtable.ProbeANDinsertNotForever("ME");
//        myhashtable.ProbeANDinsertNotForever("MI");
//        myhashtable.ProbeANDinsertNotForever("SC");
//        myhashtable.ProbeANDinsertNotForever("NH");
//        myhashtable.ProbeANDinsertNotForever("ND");
//        myhashtable.displayTable();

//        HashTable myhashtable = new HashTable(52);
//        myhashtable.ProbeANDinsertNotForever("FL");
//        myhashtable.ProbeANDinsertNotForever("CO");
//        myhashtable.ProbeANDinsertNotForever("ME");
//        myhashtable.ProbeANDinsertNotForever("MI");
//        myhashtable.ProbeANDinsertNotForever("SC");
//        myhashtable.ProbeANDinsertNotForever("NH");
//        myhashtable.ProbeANDinsertNotForever("ND");
//        myhashtable.ProbeANDdeleteButNoGapNotForever("ME");
//        myhashtable.displayTable();

//        HashTable myhashtable = new HashTable(52);
//        myhashtable.ProbeANDinsertNotForever("FL");
//        myhashtable.ProbeANDinsertNotForever("CO");
//        myhashtable.ProbeANDinsertNotForever("ME");
//        myhashtable.ProbeANDinsertNotForever("MI");
//        myhashtable.ProbeANDinsertNotForever("SC");
//        myhashtable.ProbeANDinsertNotForever("NH");
//        myhashtable.ProbeANDinsertNotForever("ND");
//        myhashtable.ProbeANDdeleteButNoGapNotForever("ME");
//        myhashtable.ProbeANDdeleteButNoGapNotForever("MI");
//        myhashtable.displayTable();

//        HashTable myhashtable = new HashTable(52);
//        myhashtable.insertMinus("FL");
//        myhashtable.insertMinus("CO");
//        myhashtable.insertMinus("ME");
//        myhashtable.insertMinus("MI");
//        myhashtable.insertMinus("SC");
//        myhashtable.insertMinus("NH");
//        myhashtable.insertMinus("ND");
//        myhashtable.deleteMinus("CO");
//        myhashtable.deleteMinus("MI");
//        myhashtable.displayTable();

//        HashTable myhashtable = new HashTable(52);
//
//        myhashtable.insertMinus("AL");
//        myhashtable.insertMinus("AK");
//        myhashtable.insertMinus("AZ");
//        myhashtable.insertMinus("AR");
//        myhashtable.insertMinus("CA");
//        myhashtable.insertMinus("CO");
//        myhashtable.insertMinus("CT");
//        myhashtable.insertMinus("DE");
//        myhashtable.insertMinus("DC");
//        myhashtable.insertMinus("FL");
//        myhashtable.insertMinus("GA");
//        myhashtable.insertMinus("HI");
//        myhashtable.insertMinus("ID");
//        myhashtable.insertMinus("IL");
//        myhashtable.insertMinus("IN");
//        myhashtable.insertMinus("IA");
//        myhashtable.insertMinus("KS");
//        myhashtable.insertMinus("KY");
//        myhashtable.insertMinus("LA");
//        myhashtable.insertMinus("ME");
//        myhashtable.insertMinus("MD");
//        myhashtable.insertMinus("MA");
//        myhashtable.insertMinus("MI");
//        myhashtable.insertMinus("MN");
//        myhashtable.insertMinus("MS");
//        myhashtable.insertMinus("MO");
//        myhashtable.insertMinus("MT");
//        myhashtable.insertMinus("NE");
//        myhashtable.insertMinus("NV");
//        myhashtable.insertMinus("NH");
//        myhashtable.insertMinus("NJ");
//        myhashtable.insertMinus("NM");
//        myhashtable.insertMinus("NY");
//        myhashtable.insertMinus("NC");
//        myhashtable.insertMinus("ND");
//        myhashtable.insertMinus("OH");
//        myhashtable.insertMinus("OK");
//        myhashtable.insertMinus("OR");
//        myhashtable.insertMinus("PA");
//        myhashtable.insertMinus("PR");
//        myhashtable.insertMinus("RI");
//        myhashtable.insertMinus("SC");
//        myhashtable.insertMinus("SD");
//        myhashtable.insertMinus("TN");
//        myhashtable.insertMinus("TX");
//        myhashtable.insertMinus("UT");
//        myhashtable.insertMinus("VT");
//        myhashtable.insertMinus("VA");
//        myhashtable.insertMinus("WA");
//        myhashtable.insertMinus("WV");
//        myhashtable.insertMinus("WI");
//        myhashtable.insertMinus("WY");
//
//        myhashtable.deleteMinus("VT");
//
//        myhashtable.insertMinus("VT");
//        myhashtable.displayTable();
        
        HashTable myhashtable = new HashTable(52);
        myhashtable.insertMinus("FL");
        myhashtable.insertMinus("CO");
        myhashtable.insertMinus("ME");
        myhashtable.insertMinus("MI");
        myhashtable.insertMinus("SC");
        myhashtable.insertMinus("NH");
        myhashtable.insertMinus("ND");
        myhashtable.deleteMinus("CO");
        myhashtable.deleteMinus("MI");
        System.out.println(myhashtable.findMinus("CO"));
        System.out.println(myhashtable.findMinus("MI"));
        System.out.println(myhashtable.findMinus("ND"));
        System.out.println(myhashtable.findMinus("ME"));

    }

}
