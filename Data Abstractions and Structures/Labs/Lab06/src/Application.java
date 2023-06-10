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

class HashTableChain

{

    private DoublyLinkedList[] InternalArray;

    private int arraySize;

    public HashTableChain(int size)

    {

        arraySize = size;

        InternalArray = new DoublyLinkedList[arraySize];

        for (int j = 0; j < arraySize; j++)
            InternalArray[j] = new DoublyLinkedList();

    }

    public void displayChains()

    {

        for (int j = 0; j < arraySize; j++)

        {

            System.out.print("Chain " + j + ": ");
            InternalArray[j].displayForward();

        }

        System.out.println("");

    }

    public int hashFunc(String key)

    {

        int result = LetterToNumber(key.charAt(0))
                + LetterToNumber(key.charAt(1));

        return result % arraySize;

    }

    public void insertInaChain(String key)

    {

        int hashIndex = hashFunc(key);

        InternalArray[hashIndex].insertNoDuplicate(key);

    }

    public void deletefromaChain(String key)

    {

        int hashIndex = hashFunc(key);

        InternalArray[hashIndex].delete(key);

        return;

    }

    public boolean findinChains(String key)

    {

        int hashIndex = hashFunc(key);

        return InternalArray[hashIndex].find(key);

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

    }// end of HashTableChain

    class DoublyLinkedList {

        private Link first;

        private Link last;

        // -------------------------------------------------------------

        public DoublyLinkedList()// constructor

        {

            first = null;// no items on list yet

            last = null;

        }

        public boolean find(String key) {

            if (first == null) {
                return false;
            }
            Link current = first;

            while (current.SData == null)

            {

                if (current.next.equals(key)) {

                    return true;
                }

                current = current.next;

            }

            return false;
        }

        /**
         * The below method receives a key and checks if there is a link in the
         * link list that has the key. If there exists such a link the method
         * return. If there exists no such a link, the method creates a new link
         * containing the key and inserts the link at the end of the linked
         * list.
         * 
         * @param key
         */

        public void insertNoDuplicate(String id) {
            if (find(id)) {
                return;
            }

            Link newLink = new Link(id);
            Link temp = first;
            first = newLink;
            first.next = temp;

        }
        
        public void deleteFirst()// delete first link

        {// (assumes non-empty list)

            if (first == null)
                return;

            if (first.next == null)

            {
                first = null;
                last = null;
                return;

            }

            first.next.previous = null; // null <-- old next

            first = first.next;// first --> old next

            return;

        }

    // -------------------------------------------------------------

        public void deleteLast()// delete last link

        {// (assumes non-empty list)
            if (last == null)
                return;

            if (last.previous == null)

            {
                first = null;
                last = null;
                return;

            }

            last.previous.next = null;

            last = last.previous;

            return;

        }

        /**
         * The above method receives a key. If there is a link containing the
         * key, the above method deletes the link from the linked list. If there
         * are multiple links containing the key, the method deletes the first
         * link that is closer to the beginning part of the linked list.
         * 
         * @param key
         */
        public void delete(String key) {
            
            if (first == null)
                return;

            Link current = first;// start at beginning

            while (current.SData != key)// until match is found,

            {

                current = current.next;// move to next link

                if (current == null)

                    return;// didn't find it

            }

            if (current == first)// found it; first item? Yes

            {
                deleteFirst();
                return;

            }

            if (current == last)// last item?

            {
                deleteLast();
                return;
            }

            current.previous.next = current.next;

            current.next.previous = current.previous;

            return;// return value

        }

        public void displayForward() {

            Link current = first;// start at beginning

            while (current != null)// until end of list,

            {

                current.displayLink();// display data

                current = current.next;// move to next link

            }

            System.out.println("");

        }

    } // end of DoublyLinkedList

    class Link {
        public String SData;
        public Link next;
        public Link previous;

        public Link(String id) {
            SData = id;

        }

        public void displayLink() {
            System.out.print(SData + " ");
        }
    } // end of Link

}

class Application

{

    public static void main(String[] args)

    {

        HashTableChain myhashtable = new HashTableChain(52);
        myhashtable.insertInaChain("AK");
        myhashtable.insertInaChain("FL");
        myhashtable.insertInaChain("IA");
        myhashtable.insertInaChain("MN");
        myhashtable.insertInaChain("NV");
        myhashtable.insertInaChain("SC");
        myhashtable.insertInaChain("VT");
        myhashtable.insertInaChain("ND");
        myhashtable.insertInaChain("ME");
        myhashtable.deletefromaChain("CO");
        myhashtable.deletefromaChain("ME");
        System.out.println(myhashtable.findinChains("ME"));
        myhashtable.displayChains();

    }

}
