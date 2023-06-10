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
class Link

{

    public int iData;// data item

    public Link next;// next link in list

    public Link previous;// previous link in list

// -------------------------------------------------------------

    public Link(int id)// constructor

    {
        iData = id;
    }

// -------------------------------------------------------------

    public void displayLink()// display this link

    {
        System.out.print(iData + " ");
    }

// -------------------------------------------------------------

}// end class Link

////////////////////////////////////////////////////////////////

class DoublyLinkedList

{

    private Link first;// ref to first item

    private Link last;// ref to last item

// -------------------------------------------------------------

    public DoublyLinkedList()// constructor

    {

        first = null;// no items on list yet

        last = null;

    }

// -------------------------------------------------------------

    public boolean isEmpty()// true if no links

    {
        return first == null;
    }

// -------------------------------------------------------------

    public void insertFirst(int id)// insert at front of list

    {

        if (first == null) {

            Link newLink = new Link(id);
            newLink.next = null;

            last = newLink;
            first = newLink;

            return;

        }

        Link newLink = new Link(id);
        newLink.previous = null;
        newLink.next = first;// newLink --> old first
        first.previous = newLink;// newLink <-- old first
        first = newLink;// first --> newLink
        return;

    }

// -------------------------------------------------------------

    public void insertLast(int id)// insert at end of list

    {

        if (first == null)

        {
            insertFirst(id);
            return;
        }

        Link newLink = new Link(id);

        newLink.next = null;
        newLink.previous = last;

        last.next = newLink;// old last --> newLink
        last = newLink;

    }

// -------------------------------------------------------------

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

// -------------------------------------------------------------

    public void delete(int key)// delete item w/ given key

    {// (assumes non-empty list)

        if (first == null)
            return;

        Link current = first;// start at beginning

        while (current.iData != key)// until match is found,

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

// old previous --> old next

        if (current == last)// last item?

        {
            deleteLast();
            return;
        }

        current.previous.next = current.next;

        current.next.previous = current.previous;

        return;// return value

    }

    public void insertAfter(int key, int id)

    {
        if (first == null) {
            return;
        }
        Link current = first;

        while (current.iData != key) {
            current = current.next;
            if (current == null) {
                return;
            }
        }

        Link newLink = new Link(id);

        if (current == last) {
            insertLast(id);
            return;
        }
//        Link newLink2 = new Link(id);
        newLink.next = current.next;
        newLink.previous = current;
        current.next.previous = newLink; // required
        current.next = newLink;
    }

// -------------------------------------------------------------

    public void displayForward()

    {

        System.out.print("List (first-->last): ");

        Link current = first;// start at beginning

        while (current != null)// until end of list,

        {

            current.displayLink();// display data

            current = current.next;// move to next link

        }

        System.out.println("");

    }

// -------------------------------------------------------------

    public void displayBackward()

    {

        System.out.print("List (last-->first): ");
        Link current = last;// start at beginning

        while (current != null)// until end of list,

        {

            current.displayLink();// display data

            current = current.previous;// move to next link

        }

        System.out.println("");

    }

// -------------------------------------------------------------

// end class DoublyLinkedList

////////////////////////////////////////////////////////////////

    public void cleanup()

    {

        // empty link list
        if (first == null) {
            return;
        }

        // if only one link
        if (first.next == null) {
            return;
        }

        Link current = first.next;

        while (current != null) {
            Link back = current.previous;

            while (back != null) {

                if (back.iData == current.iData) {
                    delete(back.iData);
                    back = current;
                }
                back = back.previous; // shift to left

            }
            current = current.next; // shift current right
        }

    }

}

class Application

{

    public static void main(String[] args)

    {// make a new list
        DoublyLinkedList myLinkedList = new DoublyLinkedList();

//        // I
//        myLinkedList.displayBackward();
//        myLinkedList.insertFirst(11);
//        myLinkedList.displayBackward();
//        myLinkedList.insertFirst(22);
//        myLinkedList.displayBackward();
//        myLinkedList.insertFirst(33);
//        myLinkedList.displayBackward();
//        
//        // II
//        myLinkedList.deleteFirst();
//        myLinkedList.insertFirst(11);
//        myLinkedList.deleteFirst();
//        myLinkedList.insertFirst(22);
//        myLinkedList.insertFirst(33);
//        myLinkedList.deleteFirst();
//        myLinkedList.insertFirst(44);
//        myLinkedList.insertFirst(55);
//        myLinkedList.insertFirst(66);
//        myLinkedList.displayForward();
//        
//        // III       
//        myLinkedList.deleteLast();
//        myLinkedList.insertFirst(11);
//        myLinkedList.deleteLast();
//        myLinkedList.insertFirst(22);
//        myLinkedList.insertFirst(33);
//        myLinkedList.deleteLast();
//        myLinkedList.insertFirst(44);
//        myLinkedList.insertFirst(55);
//        myLinkedList.insertFirst(66);
//        myLinkedList.displayForward();
//        
//        // V
//        myLinkedList.insertAfter(11,15);
//        myLinkedList.insertFirst(11);
//        myLinkedList.insertAfter(11,16);
//        myLinkedList.insertLast(22);
//        myLinkedList.insertLast(33);
//        myLinkedList.insertLast(44);
//        myLinkedList.insertAfter(44,17);
//        myLinkedList.insertAfter(33,18);
//        myLinkedList.displayForward();
//        
//        
//        // VI
//        myLinkedList.cleanup();
//        myLinkedList.displayForward();
//        myLinkedList.insertLast(22);
//        myLinkedList.cleanup();
//        myLinkedList.displayForward();
//        myLinkedList.insertLast(33);
//        myLinkedList.insertLast(44);
//        myLinkedList.insertLast(44);
//        myLinkedList.insertLast(33);
//        myLinkedList.insertLast(44);
//        myLinkedList.cleanup();
//        myLinkedList.displayForward();

        // DoublyLinkedList myLinkedList = new DoublyLinkedList();
        //// Test for Question 1
        myLinkedList.displayBackward();
        myLinkedList.insertFirst(11);
        myLinkedList.displayBackward();
        myLinkedList.insertFirst(22);
        myLinkedList.displayBackward();
        myLinkedList.insertFirst(33);
        myLinkedList.displayBackward();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.displayBackward();
        //// Test for Question 2
        myLinkedList.deleteFirst();
        myLinkedList.insertFirst(11);
        myLinkedList.deleteFirst();
        myLinkedList.insertFirst(22);
        myLinkedList.insertFirst(33);
        myLinkedList.deleteFirst();
        myLinkedList.insertFirst(44);
        myLinkedList.insertFirst(55);
        myLinkedList.insertFirst(66);
        myLinkedList.displayForward();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.displayBackward();
        //// Test for Question 4
        myLinkedList.deleteLast();
        myLinkedList.insertFirst(11);
        myLinkedList.deleteLast();
        myLinkedList.insertFirst(22);
        myLinkedList.insertFirst(33);
        myLinkedList.deleteLast();
        myLinkedList.insertFirst(44);
        myLinkedList.insertFirst(55);
        myLinkedList.insertFirst(66);
        myLinkedList.displayForward();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.displayBackward();
        //// Test for Question 5
        myLinkedList.insertAfter(11, 15);
        myLinkedList.insertFirst(11);
        myLinkedList.insertAfter(11, 16);
        myLinkedList.insertLast(22);
        myLinkedList.insertLast(33);
        myLinkedList.insertLast(44);
        myLinkedList.insertAfter(44, 17);
        myLinkedList.insertAfter(33, 18);
        myLinkedList.displayForward();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.deleteFirst();
        myLinkedList.displayBackward();
        //// Test for Question 5
        myLinkedList.cleanup();
        myLinkedList.displayForward();
        myLinkedList.insertLast(22);
        myLinkedList.cleanup();
        myLinkedList.displayForward();
        myLinkedList.insertLast(33);
        myLinkedList.insertLast(44);
        myLinkedList.insertLast(44);
        myLinkedList.insertLast(33);
        myLinkedList.insertLast(44);
        myLinkedList.cleanup();
        myLinkedList.displayForward();
    }

}
