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

    public int iData;

    public Link next;

    public Link(int id)

    {
        iData = id;
    }

}

class LinkList

{

    private Link first;

    public LinkList()

    {
        first = null;
    }

    public void insertFirst(int id) {

        Link newLink = new Link(id);
        newLink.next = first;
        first = newLink;
    }

    /**
     * Checks if the Linked List is empty
     * 
     * @return boolean value if the list is empty or not
     */
    public boolean isEmpty()

    {
        if (first == null) {
            return true;
        }
        return false;
    }

    /**
     * Deletes the first in the list and returns it back to the user
     * 
     * @return the deleted link
     */
    public Link deleteFirstandSendItBack()

    {

        if (first == null) {
            return null;
        }
        Link temp = first;
        temp = first;
        first = first.next;
        return temp;

    }
}

class StackLinkedList

{

    private LinkList list;
    private int maxSize;
    private int[] stackArray;
    private int top;

    /**
     * Stack Linked List constructor
     */
    public StackLinkedList()

    {
        list = new LinkList();
    }

    /**
     * Pushes a new link to the top of the stack
     * 
     * @param j - iData being added to the top
     */
    public void push(int j) {

        list.insertFirst(j);
    }

    /**
     * Removes the top iData Link and then returns that value
     * 
     * @return iData containing the first link
     */
    public int pop() {
        return list.deleteFirstandSendItBack().iData;
    }

    /**
     * Checks to see if the linked list is empty
     * 
     * @return boolean if the list is empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

  

    public boolean isFull()

    {

        return (top == maxSize - 1);

    }

}

class StackI

{

    private int maxSize;

    private int[] stackArray;

    private int top;

    public StackI(int s)

    {

        maxSize = s;

        stackArray = new int[maxSize];// create array

        top = -1;

    }

    public void push(int j)

    {

        top = top + 1;
        stackArray[top] = j;

    }

    public int pop()

    {

        int temp = stackArray[top];
        top = top - 1;
        return temp;

    }

    public boolean isEmpty()

    {

        return (top == -1);

    }

    public boolean isFull()

    {

        return (top == maxSize - 1);

    }

}

class Application

{

    public static void main(String[] args)

    {

        StackLinkedList theStack = new StackLinkedList();
        theStack.push(11);
        theStack.push(22);
        theStack.push(33);
        theStack.push(44);
        theStack.push(55);
        theStack.push(66);
        while (!theStack.isEmpty())
            System.out.println(theStack.pop());

    }

}
