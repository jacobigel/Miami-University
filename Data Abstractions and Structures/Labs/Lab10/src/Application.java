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

/*
 * (A) What is the length of the above tree? - 2 (B) How many levels there exist
 * in the tree? - 3 (C) What is the value of the root node of the tree? - 11 (D)
 * How many children the node 17 has? - 2 (E) How many children the node 24 has?
 * - 0 (F) Which nodes are the children of node 13? - 24 and 22 (G) Which nodes
 * are children of the root node? - 17 and 13 (H) Is this a binary tree? - Yes
 * (I) What is the up child for node 13? - 24 (J) What is the down child for
 * node 13? - 22
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

    public int NodeCounter() {

        return RecursiveNodeCounter(root);

    }

    public int RecursiveNodeCounter(Node mynode)

    {

        if (mynode == null)
            return 0;

        return 1 + RecursiveNodeCounter(mynode.down)
                + RecursiveNodeCounter(mynode.up);

    }

    public int Length() {

        if (root == null)
            return 0;

        return RecursiveLength(root) - 1;

    }

    public int RecursiveLength(Node mynode) {

        if (mynode == null)
            return 0;

        // return 1 + RecursiveLength(mynode.down)
        return 1 + Math.max(RecursiveLength(mynode.down),
                RecursiveLength(mynode.up));

    }

}

class Application {

    public static void main(String args[]) {

//      Question 1
        BinaryTree myBinaryTree = new BinaryTree();
        myBinaryTree.root = new Node(11);
        myBinaryTree.root.up = new Node(17);
        myBinaryTree.root.down = new Node(13);
        myBinaryTree.root.down.down = new Node(22);
        myBinaryTree.root.down.up = new Node(24);
        myBinaryTree.root.up.down = new Node(27);
        myBinaryTree.root.up.up = new Node(28);
        myBinaryTree.display();

//      Question 2
//        BinaryTree myBinaryTree = new BinaryTree();
        myBinaryTree.root = new Node(11);
        myBinaryTree.root.up = new Node(17);
        myBinaryTree.root.down = new Node(13);
        myBinaryTree.root.down.down = new Node(22);
        myBinaryTree.root.down.up = new Node(24);
        myBinaryTree.root.up.down = new Node(27);
        myBinaryTree.root.up.up = new Node(28);
        System.out.println(myBinaryTree.NodeCounter());

//      Question 3
//        BinaryTree myBinaryTree = new BinaryTree();
        myBinaryTree.root = new Node(11);
        myBinaryTree.root.up = new Node(17);
        myBinaryTree.root.down = new Node(13);
        myBinaryTree.root.down.down = new Node(22);
        myBinaryTree.root.down.up = new Node(24);
        myBinaryTree.root.up.down = new Node(27);
        myBinaryTree.root.up.up = new Node(28);
        System.out.println(myBinaryTree.Length());

    }

}
