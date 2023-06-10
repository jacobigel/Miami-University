/*
Copyright Notice: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
The codes in this file are prepared for the students of CSE 274 using the content of the following webpage:
https://www.baeldung.com/java-print-binary-tree-diagram
The codes in this file are shared with the students of CSE 274 course by the instructor of the course,
Seyed Mahdi Ghamkhari, so that students use the codes for learning purpose.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

/**
 * 
 * @author jacobigel
 *
 */

class Node {
    int value;
    Node down;
    Node up;

    Node(int value) {
        this.value = value;
        up = null;
        down = null;
    }

    public int getValue() {
        return value;
    }

    public Node getdown() {
        return down;
    }

    public Node getup() {
        return up;
    }
}

class Heap {

    private int Size;
    private Node root;

    public Heap() {
        Size = 0;
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        span(sb, "", "", root);
        System.out.print(sb.toString());
        System.out.println();

    }

    public void span(StringBuilder sb, String padding, String pointer,
            Node node) {

        if (node == null)

        {
            sb.append(padding);
            sb.append(pointer);
            sb.append("");
            sb.append("\n");

        }

        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│   ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForup = "┝━━";
            String pointerFordown = "└──";

            span(sb, paddingForBoth, pointerForup, node.getup());
            span(sb, paddingForBoth, pointerFordown, node.getdown());
        }
    }

    public String[] route(int Position)

    {
        String BinaryString = Integer.toBinaryString(Position);

        String[] myroute = new String[BinaryString.length()];

        myroute[0] = "NON";

        for (int i = 1; i < BinaryString.length(); i++) {
            if (BinaryString.charAt(i) == '0')
                myroute[i] = "DownWard";

            if (BinaryString.charAt(i) == '1')
                myroute[i] = "UpWard";
        }

        return myroute;

    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            Size = Size + 1;
            return;
        }

        int Position = Size + 1;
        String[] Direction = route(Position);
        int level = 1;
        Node current = root;

        while (true) {
            if (current.value < value) {
                int temp = current.value;
                current.value = value;

                value = temp;
            }
            if (level == Direction.length - 1) {
                break;
            }

            if (Direction[level].equals("DownWard")) {
                current = current.down;
            }

            if (Direction[level].equals("UpWard")) {
                current = current.up;
            }

            level = level + 1;

        }
        if (Direction[level].equals("DownWard")) {
//          current.down is a new node having the value
            current.down = new Node(value);
        }

        if (Direction[level].equals("UpWard")) {
//          current.up is a new node having the value
            current.up = new Node(value);
        }

        Size = Size + 1;

    }
}

class Application {

    public static void main(String[] argv) {

        Heap myHeap = new Heap();
        myHeap.add(3);
        myHeap.add(1);
        myHeap.add(19);
        myHeap.add(25);
        myHeap.add(4);
        myHeap.add(9);
        myHeap.add(18);
        myHeap.add(7);
        myHeap.add(6);
        myHeap.add(5);
        myHeap.add(12);
        myHeap.display();

    }

}