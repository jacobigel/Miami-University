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

class Packet

{
    public String Data;

    public int Priority;

    Packet next;

    Packet previous;

    Packet()

    {
    }

}

class PriorityQueueFastEnQueue

{
    private Packet first;
    private Packet last;

    PriorityQueueFastEnQueue()

    {

    }

    public void display()

    {
        Packet current = first;

        while (current != null) {

            System.out.print("     Previous:");
            if (current.previous != null)
                System.out.print(current.previous.Data);
            else {
                System.out.print(current.previous);
            }

            System.out.print("    Data:");
            System.out.print(current.Data);

            System.out.print("      next:");
            if (current.next != null)
                System.out.print(current.next.Data);
            else {
                System.out.print(current.next);
            }

            System.out.print("\n\n");

            current = current.next;
        }

        System.out.println("first ^^^^^^^  last");
    }

    public void displayQueue()

    {
        Packet current = first;

        System.out.print("Data:    ");
        while (current != null) {

            System.out.print(String.format("%10s", current.Data));

            current = current.next;
        }

        System.out.println("\n");
        current = first;

        System.out.print("Next:    ");
        while (current != null) {

            if (current.next != null)
                System.out.print(String.format("%10s", current.next.Data));
            else
                System.out.print(String.format("%10s", current.next));

            current = current.next;
        }

        System.out.println("\n");

        current = first;

        System.out.print("Previous:");

        while (current != null) {
            if (current.previous != null)
                System.out.print(String.format("%10s", current.previous.Data));
            else {
                System.out.print(String.format("%10s", current.previous));
            }

            current = current.next;
        }

        System.out.println("\n");

    }

    public void enQueue(String newData, int newPriority)

    {
        Packet newPacket = new Packet();
        newPacket.Data = newData;
        newPacket.Priority = newPriority;

        if (first == null)

        {

            newPacket.next = null;
            newPacket.previous = null;
            first = newPacket;
            last = newPacket;

            return;
        }

        newPacket.next = null;
        newPacket.previous = last;
        last.next = newPacket;
        last = newPacket;
        return;

    }

    public boolean isEmpty()

    {
        return first == null;

    }

    public String deQueue() {
        Packet highPriorityPacket = first;
        Packet current = first;

        while (current.next != null) {
            current = current.next;
            if (highPriorityPacket.Priority < current.Priority) {
                highPriorityPacket = current;
            }
        }
        String Data = highPriorityPacket.Data;

        if (highPriorityPacket == first) {
//          Delete the first link from the linked list
            first.previous = null;
            first = first.next;
            return Data;
        }
        if (highPriorityPacket == last) {
//          Delete the last link from the linked list
            last.previous.next = null;
            last = last.previous;
            return Data;
        }

//      Delete the highPriorityPacket from the linked list
        highPriorityPacket.previous.next = highPriorityPacket.next;
        highPriorityPacket.next.previous = highPriorityPacket.previous;

        return Data;
    }

}

class Application {

    public static void main(String[] args) {
        PriorityQueueFastEnQueue myQueue = new PriorityQueueFastEnQueue();
        myQueue.enQueue("A", 1);
        myQueue.enQueue("B", 3);
        myQueue.enQueue("C", 2);
        myQueue.enQueue("D", 5);
        myQueue.enQueue("E", 4);
        while (!myQueue.isEmpty())
            System.out.println(myQueue.deQueue());

    }

}
