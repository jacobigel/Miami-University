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
 * Homework 3
 *
 */
class Link<unknown>

{

    public unknown iData;

    public Link<unknown> next;

    public Link<unknown> previous;

// -------------------------------------------------------------

    public Link(unknown id)

    {
        iData = id;
    }

// -------------------------------------------------------------

    public void displayLink()

    {
        System.out.print(iData + " ");
    }

// -------------------------------------------------------------

}

////////////////////////////////////////////////////////////////

class DoublyLinkedList<unknown>

{

    private Link<unknown> first;

    private Link<unknown> last;

// -------------------------------------------------------------

    public DoublyLinkedList()

    {

        first = null;

        last = null;

    }

// -------------------------------------------------------------

    public boolean isEmpty()

    {
        return first == null;
    }

// -------------------------------------------------------------

    public void insertFirst(unknown id)

    {

        if (first == null) {

            Link <unknown> newLink = new Link(id);
            newLink.next = null;

            last = newLink;
            first = newLink;

            return;

        }

        Link <unknown> newLink = new Link(id);
        newLink.previous = null;
        newLink.next = first;
        first.previous = newLink;
        first = newLink;
        return;

    }

// -------------------------------------------------------------

    public void insertLast(unknown id)

    {

        if (first == null)

        {
            insertFirst(id);
            return;
        }

        Link <unknown> newLink = new Link(id);

        newLink.next = null;
        newLink.previous = last;

        last.next = newLink;
        last = newLink;

    }

    public void deleteFirst()

    {

        if (first == null)
            return;

        if (first.next == null)

        {
            first = null;
            last = null;
            return;

        }

        first.next.previous = null;

        first = first.next;

        return;

    }

    public void deleteLast()

    {

        if (first == null)

        {

            return;

        }

        if (first.next == null)

        {
            deleteFirst();
            return;
        }

        last.previous.next = null;

        last = last.previous;

    }

// -------------------------------------------------------------

    public Link<unknown> deleteFirstandPassItAlong()

    {

        if (first == null)
            return null;

        Link<unknown> temp;
        temp = first;
        if (first.next == null)

        {

            first = null;
            last = null;
            return temp;

        }

        first.next.previous = null;

        first = first.next;

        return temp;

    }

}

class Queue<unknown> {

    private DoublyLinkedList<unknown> myLinkedList = new DoublyLinkedList();

    private int num;

    public Queue() {
        num = 0;
    }

    public void enQueue(unknown j) {
//        myLinkedList[first] = j;
        myLinkedList.insertLast(j);
        num = num + 1;
        return;
    }

    public unknown deQueue() {
        num = num - 1;
        Link<unknown> temp = myLinkedList.deleteFirstandPassItAlong();
        return temp.iData;

    }

    public boolean isEmpty() {
        if (num == 0)
            return true;

        return false;
    }
}

class Application

{

    public static void main(String[] args) {
        Queue<String> myQueue = new Queue<String>();
        myQueue.enQueue("11");
        myQueue.enQueue("22");
        myQueue.enQueue("33");
        myQueue.enQueue("44");
        myQueue.enQueue("55");
        while (!myQueue.isEmpty())
            System.out.println(myQueue.deQueue());

    }

}
