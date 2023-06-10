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
class HashMap

{

    private String[] InternalArray;
    private int[] ValueArray;

    private int arraySize;

    private int num;

    public HashMap(int size)

    {

        num = 0;

        arraySize = size;

        InternalArray = new String[arraySize];
        ValueArray = new int[arraySize];

        for (int j = 0; j < arraySize; j++) {
            InternalArray[j] = "**";
            ValueArray[j] = -1;
        }

    }

    public void displayMap()

    {

        System.out.println("Table: ");

        for (int j = 0; j < arraySize; j++)

        {

            System.out.print("(" + InternalArray[j] + ": "
                    + String.format("%3d", ValueArray[j]) + ")   ");

            if (j % 10 == 9)
                System.out.print("\n");

        }

        System.out.println("");

    }

    public int hashFunc(String key)

    {

        int result = LetterToNumber(key.charAt(0))
                * LetterToNumber(key.charAt(1));

        return result % arraySize;

    }

    public void put(String key, int value) {

        // Calculate the hashIndex corresponding to the key
        int hashIndex = hashFunc(key);

        // Begin searching for the key in the internalArray, starting at
        // hashIndex.
        // The search should be limited to only one block of data.
        // That means, the search should stop when the key is found or when the
        // search reaches to a ** entry
        while (!InternalArray[hashIndex].equals("**")) {
            // If the key is found in the InternalArray, the method should
            // return.
            if (InternalArray[hashIndex].equals(key)) {
                return;
            }
            ++hashIndex;
            hashIndex = hashIndex % arraySize;

        }

        hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].equals("**")
                && !InternalArray[hashIndex].equals("--")) {
            ++hashIndex;
            hashIndex = hashIndex % arraySize;

        }

        if (InternalArray[hashIndex].equals("**") && num == arraySize - 1) {
            return;
        }

        if (InternalArray[hashIndex].equals("**")) {
            num = num + 1;
        }

        // Let hashIndex denote the index at which the key is inserted in the
        // internalArray by the
        // method.
        InternalArray[hashIndex] = key;

        // The method should insert value into the ValueArray at
        // hashIndex

        ValueArray[hashIndex] = value;

        return;

    }

    public int doMapping(String key) {
        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].equals("**")) {
            if (InternalArray[hashIndex].equals(key)) {
                return ValueArray[hashIndex];
            }
            hashIndex++;
            hashIndex = hashIndex % arraySize;

        }
        return -1;

    }

    public void remove(String key)

    {
        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].equals("**"))

        {

            if (InternalArray[hashIndex].equals(key))

            {

                InternalArray[hashIndex] = "--";
                ValueArray[hashIndex] = -1;

                return;

            }

            ++hashIndex;

            hashIndex = hashIndex % arraySize;

        }

        return;

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

}

class Pair {
    public String mykey;
    public int myvalue;

    Pair() {
        mykey = "**";
        myvalue = -1;
    }
}

class HashMapPair {
    private Pair[] InternalArray;
    private int arraySize;
    private int num;

    public HashMapPair(int size) {
        num = 0;
        arraySize = size;
        InternalArray = new Pair[arraySize];
        for (int j = 0; j < arraySize; j++) {
            InternalArray[j] = new Pair();
        }
    }

    public int hashFunc(String key)

    {

        int result = LetterToNumber(key.charAt(0))
                * LetterToNumber(key.charAt(1));

        return result % arraySize;

    }

    public void putPair(String key, int value) {
        int hashIndex = hashFunc(key);
        while (!InternalArray[hashIndex].mykey.equals("**")) {
            if (InternalArray[hashIndex].mykey.equals(key)) {
                return;
            }
            ++hashIndex;
            hashIndex = hashIndex % arraySize;

        }

        hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].mykey.equals("**")
                && !InternalArray[hashIndex].mykey.equals("--")) {
            ++hashIndex;
            hashIndex = hashIndex % arraySize;

        }

        if (InternalArray[hashIndex].mykey.equals("**")
                && num == arraySize - 1) {
            return;
        }

        if (InternalArray[hashIndex].mykey.equals("**")) {
            num = num + 1;
        }

        InternalArray[hashIndex].mykey = key;
        InternalArray[hashIndex].myvalue = value;

        return;
    }

    public void removePair(String key) {
        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].mykey.equals("**"))

        {

            if (InternalArray[hashIndex].mykey.equals(key))

            {

                InternalArray[hashIndex].mykey = "--";
                InternalArray[hashIndex].myvalue = -1;

                return;

            }

            ++hashIndex;

            hashIndex = hashIndex % arraySize;

        }

        return;
    }

    public int doMappingPair(String key) {
        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].mykey.equals("**")) {
            if (InternalArray[hashIndex].mykey.equals(key)) {
                return InternalArray[hashIndex].myvalue;
            }
            hashIndex++;
            hashIndex = hashIndex % arraySize;

        }
        return -1;

    }

    public void displayMap() {
        System.out.println("Table: ");

        for (int j = 0; j < arraySize; j++)

        {

            System.out.print("(" + InternalArray[j].mykey + ": "
                    + String.format("%3d", InternalArray[j].myvalue) + ")   ");

            if (j % 10 == 9)
                System.out.print("\n");

        }

        System.out.println("");

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
} // end of hashmappair

class Application

{

    public static void main(String[] args)

    {

//        HashMap myhashmap = new HashMap(52);
//        myhashmap.put("AK", 114);
//        myhashmap.put("FL", 341);
//        myhashmap.put("IA", 419);
//        myhashmap.put("MN", 201);
//        myhashmap.put("NV", 941);
//        myhashmap.put("VT", 388);
//        myhashmap.remove("VT");
//        myhashmap.displayMap();
//        String key;
//        key = "MN";
//        System.out.println("key:" + key + " value:" + myhashmap.doMapping(key));
//        key = "VT";
//        System.out.println("key:" + key + " value:" + myhashmap.doMapping(key));

        HashMapPair myhashmap = new HashMapPair(52);
        myhashmap.putPair("AK", 114);
        myhashmap.putPair("FL", 341);
        myhashmap.putPair("IA", 419);
        myhashmap.putPair("MN", 201);
        myhashmap.putPair("NV", 941);
        myhashmap.putPair("VT", 388);
        myhashmap.removePair("VT");
        myhashmap.displayMap();
        String key;
        key = "MN";
        System.out.println("key:" + key + " value:" + myhashmap.doMappingPair(
                key));
        key = "VT";
        System.out.println("key:" + key + " value:" + myhashmap.doMappingPair(
                key));

    }

}
