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

    public void add(int value)

    {
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
                int tmp = current.value;
                current.value = value;
                value = tmp;
            }

            if (level == Direction.length - 1)
                break;

            if (Direction[level].equals("DownWard"))

                current = current.down;

            if (Direction[level].equals("UpWard"))
                current = current.up;

            level = level + 1;

        }

        if (Direction[level].equals("DownWard"))
            current.down = new Node(value);

        if (Direction[level].equals("UpWard"))
            current.up = new Node(value);

        Size = Size + 1;

    }

    public boolean isEmpty()

    {
        return Size == 0;
    }

    public int delete()

    {

        int DeletedValue = root.value;

        if (root.up == null && root.down == null) {

            root = null;
            Size = Size - 1;
            return DeletedValue;
        }

        if (Size == 2) {
            root.value = root.down.value;
            root.down = null;
            Size = Size - 1;
            return DeletedValue;

        }

        if (Size == 3) {

            if (root.up.value >= root.down.value) {
                root.value = root.up.value;
                root.up = null;
                Size = Size - 1;
                return DeletedValue;
            }

            if (root.up.value < root.down.value) {
                root.value = root.down.value;
                root.down.value = root.up.value;
                root.up = null;
                Size = Size - 1;
                return DeletedValue;
            }

        }

        Node current = root;
        Node parent = root;

        String[] Direction = route(Size);

        for (int i = 1; i < Direction.length; i++) {
            if (Direction[i].equals("UpWard")) {
                parent = current;
                current = current.up;
            }

            if (Direction[i].equals("DownWard")) {
                parent = current;
                current = current.down;
            }

        }

        int LastValue = current.value;

        if (Direction[Direction.length - 1].equals("UpWard"))
            parent.up = null;

        if (Direction[Direction.length - 1].equals("DownWard"))
            parent.down = null;

        current = root;

        int tmp;

        while (true) {
            if (current.up == null && current.down == null) {
                /// Complete the body of "if" Statement ///
                current.value = LastValue;

                Size--;

                return DeletedValue;

            }

            if (current.down == null) {

                current.value = current.up.value;

                if (current.value < LastValue) {
                    /// Complete the body of "if" Statement ///

                    tmp = current.value;
                    current.value = LastValue;
                    LastValue = tmp;

                }

                current = current.up;
                continue;

            }

            if (current.up == null) {

                current.value = current.down.value;
                if (current.value < LastValue) {
                    /// Complete the body of "if" Statement ///

                    tmp = current.value;
                    current.value = LastValue;
                    LastValue = tmp;

                }

                current = current.down;

                continue;

            }

            if (current.down.value > current.up.value) {
                current.value = current.down.value;

                if (current.value < LastValue) {
                    tmp = current.value;
                    current.value = LastValue;
                    LastValue = tmp;
                }

                current = current.down;

                continue;
            }

            if (current.down.value < current.up.value) {

                /// Complete the body of "if" Statement ///
                current.value = current.up.value;

                if (current.value < LastValue) {
                    tmp = current.value;
                    current.value = LastValue;
                    LastValue = tmp;
                }

                current = current.up;

                continue;

            }

            if (current.down.value == current.up.value) {
                current.value = current.down.value;
                if (current.value < LastValue) {
                    /// Complete the body of "if" Statement ///

                    tmp = current.value;
                    current.value = LastValue;
                    LastValue = tmp;

                }

                current = current.down;

            }

        }

    }

}

class Application {

    public static void main(String[] argv)

    {
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
        
//        myHeap.add(44);
//        myHeap.add(21);
//        myHeap.add(88);
//        myHeap.add(12);
//        myHeap.add(43);
//        myHeap.add(5);
//        myHeap.add(7);
//        myHeap.add(3);
//        myHeap.add(19);
//        myHeap.add(5);
        while (!myHeap.isEmpty())
            System.out.println(myHeap.delete());

    }

}