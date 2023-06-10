/////  Copyright: The codes in this file are prepared for the students of CSE 274 using the content of the following textbook:

////   Data Structures and Algorithms in Java, 2nd Edition by Robert Lafore

////   The codes in this file are shared with the students of CSE 274 course by the instructor of the course,

////   so that students use the codes for learning purpose. 

////   Accordingly, the instructor of the course is not in a position to give a permission to the students

////   to use these codes for any other purposes, such as sharing the codes with other individuals. 

/**
 * 
 * @author jacobigel
 *
 */

//Question 1 (10 points): How many steps it takes to insert a new link at the beginning part of a linked
//list?
//O(1)

//Question 2 (10 points): How many steps it takes to insert a new link at the ending part of a linked list?
// O(N)

//Question 3 (10 points): In average, how many steps it takes to find a link that includes a specific key,
//i.e. Data==key?
// N/2

//Question 4 (10 points): Once a link list is created, does it have a fixed number of links?
// A link list does not have a fixed number of links and they can either 
// increase or decrease dependent on what the user wants.

//Question 5 (10 points): Is there any relationship between the memory locations at which the links of a
//linked list are placed?
// Links are not stored in a sequenced memory location so there is no relationship.

class Link //////// Class Link

{

    public int iData;

    public double dData;

    public Link next;

    public Link(int id, double dd) ///// Constructor

    {
        iData = id;
        dData = dd;
    }

    public void displayLink() //// printing the data in the link

    {

        System.out.println("{" + iData + "," + dData + "}");

    }

}

class LinkList

{

    private Link first;

    public void LinkList() /////////// constructor

    {
        first = null; //// Initializing "first" variable.
    }

    public void insertFirst(int id, double dd) //// inserting a link at the
                                               //// beginning part of the linked
                                               //// list

    {

        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public void displayList() /// printing the data in all links

    {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;

        }
    }

    public Link deleteFirst() ////// deleting the link at the beginning part of
                              ////// the linked list

    {

        Link temp = first;

        if (first == null)
            return null;

        first = first.next;
        return temp;

    }

    public Link find(int key) /// finding a link in which iData is equal to key

    {
        Link current = first;

        if (current == null)
            return null;

        while (current.iData != key) //// Keep iterating until finding the link
                                     //// with iData=key

        {

            if (current.next == null)
                return null;

            current = current.next;

        }

        return current;

    }

    public void insertLast(int id, double dd)

    {

        if (first == null)

        {

            insertFirst(id, dd);
            return;
        }

        Link current = first;

        while (current.next != null)

        {

            current = current.next;

        }

        Link newlink = new Link(id, dd);

        newlink.next = null;
        current.next = newlink;

    }

    public void CountandDisplay(int index)

    {

        if (first == null)

        {

            return;
        }

        Link current = first;

        int count = 1;

        while (current != null)

        {

            if (count == index) {

                current.displayLink();
                return;

            }
            count = count + 1;
            current = current.next;

        }

    }

    public void delete(int key)

    {
        if (first == null)
            return;

        if (first.next == null)

        {
            if (first.iData != key)

                return;

            if (first.iData == key)

            {
                first = null;

                return;
            }
        }

        if (first.iData == key)

        {
            first = first.next;
            return;
        }

        Link previous = first;

        Link current = first.next;

        while (current.iData != key) {

            previous = current;
            current = current.next;

            if (current == null)

                return;
        }

        previous.next = current.next;
        return;
    }

    public void insertOrdered(int id, double dd) {
        Link newLink = new Link(id, dd);

        // if list is empty
        if (first == null) {
            insertFirst(id, dd);
            return;
        }

        // case for one thing in the list
        if (first.next == null || newLink.iData >= first.next.iData) {
            first.next = newLink;
            newLink = first;
            return;
        }

        Link current = first;

        while (current.next != null && newLink.iData >= current.next.iData) {
            current = current.next;

        }

        newLink.next = current.next;
        current.next = newLink;

    }
}

class Application {

    public static void main(String[] args) {
        LinkList myLinkedlist = new LinkList();
        // test 1 - good
//        System.out.println("Linked list before calling delete method:" );
//        myLinkedlist.displayList();
//        myLinkedlist.delete(9);
//        System.out.println("Linked list after calling delete method:" );
//        myLinkedlist.displayList();
//
//        //test 2 - correct output, 10.3 doesn't show because its a float
//        myLinkedlist.insertFirst(9, 10.3);
//        System.out.println("Linked list before calling delete method:");
//        myLinkedlist.displayList();
//        myLinkedlist.delete(9);
//        System.out.println("Linked list after calling delete method:");
//        myLinkedlist.displayList();
//        
//        // test 3 - works just fine
//        myLinkedlist.insertFirst(11, 10.3);
//        System.out.println("Linked list before calling delete method:" );
//        myLinkedlist.displayList();
//        myLinkedlist.delete(9);
//        System.out.println("Linked list after calling delete method:" );
//        myLinkedlist.displayList();

        // test 4 - looks good
//        myLinkedlist.insertFirst(14, 10.3);
//        myLinkedlist.insertFirst(15, 10.3);
//        myLinkedlist.insertFirst(9, 10.3);
//        System.out.println("Linked list before calling delete method:" );
//        myLinkedlist.displayList();
//        myLinkedlist.delete(9);
//        System.out.println("Linked list after calling delete method:" );
//        myLinkedlist.displayList();
//        
//        // test 5 - Correct
//        myLinkedlist.insertFirst(15, 10.3);
//        myLinkedlist.insertFirst(9, 10.3);
//        myLinkedlist.insertFirst(16, 10.3);
//        System.out.println("Linked list before calling delete method:" );
//        myLinkedlist.displayList();
//        myLinkedlist.delete(9);
//        System.out.println("Linked list after calling delete method:" );
//        myLinkedlist.displayList();
//        
//        // test 6 - looks good
//        myLinkedlist.insertFirst(21, 10.3);
//        myLinkedlist.insertFirst(15, 10.3);
//        myLinkedlist.insertFirst(16, 10.3);
//        System.out.println("Linked list before calling delete method:" );
//        myLinkedlist.displayList();
//        myLinkedlist.delete(9);
//        System.out.println("Linked list after calling delete method:" );
//        myLinkedlist.displayList();

        // question 7
        myLinkedlist.insertOrdered(21, 10.3);
        myLinkedlist.insertOrdered(15, 11.8);
        myLinkedlist.insertOrdered(18, 12.1);
        myLinkedlist.insertOrdered(9, 19.9);
        myLinkedlist.insertOrdered(50, 15.7);
        myLinkedlist.insertOrdered(26, 11.4);

        myLinkedlist.displayList();

    }

}
