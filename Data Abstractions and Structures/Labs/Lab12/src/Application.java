/*
Copyright Notice: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
The codes in this file are prepared for the students of CSE 274 using the content of the following webpages:
https://www.baeldung.com/java-binary-tree
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

class BinaryTree {

    public Node root;

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

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.down = addRecursive(current.down, value);
            return current;
        }

        if (value > current.value) {
            current.up = addRecursive(current.up, value);
            return current;
        }

        if (value == current.value) {
            return current;
        }

        return current;
    }

    public boolean contain(int value) {
        return containRecursive(root, value);
    }

    private boolean containRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        if (value < current.value) {
            return containRecursive(current.down, value);
        }

        if (value > current.value) {
            return containRecursive(current.up, value);
        }

        return false;

    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        root = deleteRecursive(root, value);
        return;
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.down == null && current.up == null) {
                return null;
            }
            if (current.down == null) {
                return current.up;
            }
            if (current.up == null) {
                return current.down;
            }
            int smallestValue = findSmallestValue(current.up);
            current.value = smallestValue;
            current.up = deleteRecursive(current.up, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.down = deleteRecursive(current.down, value);
            return current;
        }
        if (value > current.value) {
            current.up = deleteRecursive(current.up, value);
            return current;
        }
        return null;
    }

    private int findSmallestValue(Node mynode) {
        while (mynode.down != null) {
            mynode = mynode.down;
        }

        return (mynode.value);
    }
}

class Application {

    public static void main(String argv[]) {
        BinaryTree myBinaryTree = new BinaryTree();
//        Question 1
//        myBinaryTree.add(10);
//        myBinaryTree.add(11);
//        myBinaryTree.add(8);
//        myBinaryTree.add(7);
//        myBinaryTree.add(3);
//        myBinaryTree.add(5);
//        myBinaryTree.add(4);
//        myBinaryTree.add(12);
//        myBinaryTree.add(9);
//        myBinaryTree.add(2);
//        myBinaryTree.display();

//        Question 2
//        myBinaryTree.add(10);
//        myBinaryTree.add(11);
//        myBinaryTree.add(7);
//        myBinaryTree.add(3);
//        myBinaryTree.add(5);
//        myBinaryTree.add(4);
//        myBinaryTree.add(12);
//        myBinaryTree.add(9);
//        myBinaryTree.add(2);
//        System.out.println(myBinaryTree.contain(7));
//        System.out.println(myBinaryTree.contain(8));
//        System.out.println(myBinaryTree.contain(12));
//        System.out.println(myBinaryTree.contain(2));
//        System.out.println(myBinaryTree.contain(4));
//        System.out.println(myBinaryTree.contain(14));
//        System.out.println(myBinaryTree.contain(17));
//        System.out.println(myBinaryTree.contain(6));
//        System.out.println(myBinaryTree.contain(1));

//        Question 3
        myBinaryTree.add(10);
        myBinaryTree.add(19);
        myBinaryTree.add(8);
        myBinaryTree.add(7);
        myBinaryTree.add(21);
        myBinaryTree.add(15);
        myBinaryTree.add(16);
        myBinaryTree.add(14);
        myBinaryTree.add(17);
        myBinaryTree.add(17);
        myBinaryTree.add(22);
        myBinaryTree.add(20);
        myBinaryTree.delete(19);
        myBinaryTree.delete(15);
        myBinaryTree.display();
    }

}
