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

    //o(1)
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

    public boolean isEmpty() {
        return (first == null);
    }

    public Link deleteFirst() ////// deleting the link at the beginning part of
                              ////// the linked list

    {
        Link temp = first;

        if (temp != null) {
            first = first.next;
            return temp;

        } else {
            return null;
        }

    }

    public Link find(int key) /// finding a link in which iData is equal to key

    {
        Link current = first;

        if (current != null) {
            while (current.iData != key) //// Keep iterating until finding the
                                         //// link
            //// with iData=key

            {
                if (current.next == null) {
                    return null;
                }

                current = current.next;

            }

            return current;

        } else {
            return null;
        }

    }

    //o(n)
    public void insertLast(int id, double dd)

    {

        if (first == null)

        {

            insertFirst(id, dd);
            return;
        }

        Link current = first;

        //loop all the way until the next is null aka the last 
        while (current.next != null)

        {

            // keep making the current the next to test where the end i
            current = current.next;

        }
        
        //make a new link and put it at the end
        Link newLink2 = new Link(id, dd);
        newLink2.next = null;
        current.next = newLink2;

    }

    public void CountandDisplay(int index) {
        Link current = first;
        int counter = 1;
        while (current.next != null) {
            if (counter == index) {
                System.out.println(
                        "{" + current.iData + ", " + current.dData + "}");
                return;
            }
            current = current.next;
            counter++;
        }

    }
}

class Application ////
{

    public static void main(String[] args) {
        LinkList myLinkedlist = new LinkList();
        System.out.println(myLinkedlist.find(4)==null);
        myLinkedlist.deleteFirst();
        myLinkedlist.insertLast(1, 29.2);
        myLinkedlist.insertFirst(3, 13.5);
        myLinkedlist.insertLast(2, 22.2);
        myLinkedlist.deleteFirst();
        myLinkedlist.displayList();
        System.out.println(myLinkedlist.find(1)==null);
        myLinkedlist.insertFirst(6,17.8);
        myLinkedlist.insertFirst(5,21.6);
        myLinkedlist.insertFirst(4,81.3);
        myLinkedlist.displayList();
        System.out.println("The link with index 4:");
        myLinkedlist.CountandDisplay(4);

    }

}
