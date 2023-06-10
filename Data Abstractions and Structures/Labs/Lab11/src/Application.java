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

class Link {

    public Link next;
    Node Data;

    Link(Node mynode) {
        next = null;
        Data = mynode;
    }
}

class Queue

{
    private Link first;

    Queue()

    {
        first = null;

    }

    public void enQueue(Node mynode) {
        Link newlink = new Link(mynode);
        newlink.next = null;
        if (first == null) {
            first = newlink;
            return;
        }

        Link current = first;
        while (current.next != null)

        {
            current = current.next;

        }

        current.next = newlink;
        return;

    }

    public Node deQueue()

    {
        Link temp = first;
        if (first.next == null) {

            first = null;
            return temp.Data;
        }

        first = first.next;

        return temp.Data;
    }

    public boolean isEmpty() {
        return first == null;
    }

}

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

    // Question 2
    public void traversePreOrder() {
        RecursivetraversePreOrder(root);
        System.out.println();
    }

    public void RecursivetraversePreOrder(Node mynode) {
        if (mynode != null) {
            System.out.print(" " + mynode.value);
            RecursivetraversePreOrder(mynode.down);
            RecursivetraversePreOrder(mynode.up);
        }
    }

    // Question 3
    public void traversePostOrder() {
        RecursivetraversePostOrder(root);
        System.out.println();
    }

    public void RecursivetraversePostOrder(Node mynode) {
        if (mynode != null) {
            RecursivetraversePostOrder(mynode.down);
            RecursivetraversePostOrder(mynode.up);
            System.out.print(" " + mynode.value);
        }
    }

    // Question 4
    public void traverseInOrder() {
        RecursivetraverseInOrder(root);
        System.out.println();
    }

    private void RecursivetraverseInOrder(Node mynode) {
        if (mynode != null) {
            RecursivetraverseInOrder(mynode.down);
            System.out.print(" " + mynode.value);
            RecursivetraverseInOrder(mynode.up);
        }
    }

    // Question 5
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }
        Queue myQueue = new Queue();

        myQueue.enQueue(root);

        while (!myQueue.isEmpty()) {
            Node mynode = myQueue.deQueue();
            System.out.print(" " + mynode.value);
            if (mynode.down != null) {
                myQueue.enQueue(mynode.down);
            }
            if (mynode.up != null) {
                myQueue.enQueue(mynode.up);
            }

        }

        System.out.println();

    }

}

class Application {

    public static void main(String args[]) {

        BinaryTree myBinaryTree = new BinaryTree();

//        Question 1

        myBinaryTree.root = new Node(11);
        myBinaryTree.root.up = new Node(17);

        myBinaryTree.root.up.up = new Node(28);

        myBinaryTree.root.up.down = new Node(27);
        myBinaryTree.root.up.down.up = new Node(68);
        myBinaryTree.root.up.down.up.down = new Node(92);

        myBinaryTree.root.down = new Node(13);
        myBinaryTree.root.down.up = new Node(24);
        myBinaryTree.root.down.down = new Node(22);
        myBinaryTree.root.up.down.down = new Node(54);

        myBinaryTree.display();

//        Question 2

//        BinaryTree myBinaryTree = new BinaryTree();
        myBinaryTree.root=new Node(11);
        myBinaryTree.root.up= new Node(17);
        myBinaryTree.root.up.up= new Node(28);
        myBinaryTree.root.up.down= new Node(27);
        myBinaryTree.root.up.down.up= new Node(68);
        myBinaryTree.root.up.down.up.down= new Node(92);
        myBinaryTree.root.down= new Node(13);
        myBinaryTree.root.down.up= new Node(24);
        myBinaryTree.root.down.down= new Node(22);
        myBinaryTree.root.up.down.down= new Node(54);
        myBinaryTree.traversePreOrder();

//        Question 3

//        BinaryTree myBinaryTree = new BinaryTree();
        myBinaryTree.root = new Node(11);
        myBinaryTree.root.up = new Node(17);
        myBinaryTree.root.up.up = new Node(28);
        myBinaryTree.root.up.down = new Node(27);
        myBinaryTree.root.up.down.up = new Node(68);
        myBinaryTree.root.up.down.up.down = new Node(92);
        myBinaryTree.root.down = new Node(13);
        myBinaryTree.root.down.up = new Node(24);
        myBinaryTree.root.down.down = new Node(22);
        myBinaryTree.root.up.down.down = new Node(54);
        myBinaryTree.traversePostOrder();

//        Question 4

//        BinaryTree myBinaryTree = new BinaryTree();
        myBinaryTree.root=new Node(11);
        myBinaryTree.root.up= new Node(17);
        myBinaryTree.root.up.up= new Node(28);
        myBinaryTree.root.up.down= new Node(27);
        myBinaryTree.root.up.down.up= new Node(68);
        myBinaryTree.root.up.down.up.down= new Node(92);
        myBinaryTree.root.down= new Node(13);
        myBinaryTree.root.down.up= new Node(24);
        myBinaryTree.root.down.down= new Node(22);
        myBinaryTree.root.up.down.down= new Node(54);
        myBinaryTree.traverseInOrder();

//        Question 5

//        BinaryTree myBinaryTree = new BinaryTree();
        myBinaryTree.root=new Node(11);
        myBinaryTree.root.up= new Node(17);
        myBinaryTree.root.up.up= new Node(28);
        myBinaryTree.root.up.down= new Node(27);
        myBinaryTree.root.up.down.up= new Node(68);
        myBinaryTree.root.up.down.up.down= new Node(92);
        myBinaryTree.root.down= new Node(13);
        myBinaryTree.root.down.up= new Node(24);
        myBinaryTree.root.down.down= new Node(22);
        myBinaryTree.root.up.down.down= new Node(54);
        myBinaryTree.traverseLevelOrder();

    }

}
