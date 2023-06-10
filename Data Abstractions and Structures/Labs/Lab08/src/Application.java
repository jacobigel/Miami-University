/**
 * 
 * @author jacobigel Lab 8
 *
 */

class Packet {
    public String Data;
    public int Priority;
    Packet next;
    Packet previous;

    Packet() {
    }
}

class PriorityQueue {
    int number = 0;
    private int maxSize;
    private Packet[] InternalArray;

    PriorityQueue(int size) {
        maxSize = size;
        InternalArray = new Packet[maxSize];
        for (int j = 0; j < maxSize; j++)
            InternalArray[j] = new Packet();
    }

    public String deQueue() {
        String temp = InternalArray[number - 1].Data;
        number = number - 1;
        return temp;
    }

    public void displayQueue() {
        for (int j = 0; j < number; j++)
            System.out.println(InternalArray[j].Data);
    }

    public boolean isEmpty() {
        return number == 0;
    }

    public void enQueue(String newData, int newPriority) {
        int j = 0;
        for (; j < number; j++) {
            if (newPriority <= InternalArray[j].Priority) {
                break;
            }
        }

        for (int i = number - 1; i >= j; i--) {
            InternalArray[i + 1].Data = InternalArray[i].Data;
            InternalArray[i + 1].Priority = InternalArray[i].Priority;
        }

        InternalArray[j].Data = newData;
        InternalArray[j].Priority = newPriority;

        number++;
    }
} // end of class

class PriorityQueueLinkedList {
    private Packet first;
    private Packet last;

    PriorityQueueLinkedList() {
    }

    public String deQueue() {
        Packet temp = first;
        first = first.next;
        if (first == null) {
            last = null;
            return temp.Data;
        }
        first.previous = null;
        return temp.Data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayQueue() {
        Packet current = first;
        System.out.print("Data: ");
        while (current != null) {
            System.out.print(String.format("%10s", current.Data));
            current = current.next;
        }
        System.out.println("\n");
        current = first;
        System.out.print("Next: ");
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
            else
                System.out.print(String.format("%10s", current.previous));
            current = current.next;
        }
        System.out.println("\n");
    }

    public void enQueue(String newData, int newPriority) {
        Packet newPacket = new Packet();
        newPacket.Data = newData;
        newPacket.Priority = newPriority;

        if (first == null) {
            first = newPacket;
            last = newPacket;
            newPacket.next = null;
            newPacket.previous = null;
            return;
        }

        if (newPacket.Priority <= last.Priority) {
            last.next = newPacket;
            newPacket.previous = last;
            last = newPacket;
            newPacket.next = null;
            return;
        }

        Packet current = last;

        while (current != null) {
            if (newPriority <= current.Priority) {
                break;
            }
            current = current.previous;
        }

        if (current == null) {
            newPacket.next = first;
            first.previous = newPacket;
            first = newPacket;
            return;
        }

        current.next.previous = newPacket;
        newPacket.next = current.next;
        current.next = newPacket;
        newPacket.previous = current;
        return;

    }
} // end of class

class Application

{

    public static void main(String[] args) {
//        PriorityQueue myQueue = new PriorityQueue(10);
//        myQueue.enQueue("A", 1);
//        myQueue.enQueue("B", 3);
//        myQueue.enQueue("C", 2);
//        myQueue.enQueue("D", 5);
//        myQueue.enQueue("E", 4);
//        while (!myQueue.isEmpty())
//            System.out.println(myQueue.deQueue());
        PriorityQueueLinkedList myQueue = new PriorityQueueLinkedList();
        myQueue.enQueue("A", 1);
        myQueue.enQueue("B", 3);
        myQueue.enQueue("C", 2);
        myQueue.enQueue("D", 5);
        myQueue.enQueue("E", 4);
        myQueue.displayQueue();

    }

}
