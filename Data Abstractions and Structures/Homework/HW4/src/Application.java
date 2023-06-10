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
    String key;
    int data;
    Node down;
    Node up;

    Node(String key, int data) {
        this.key = key;
        this.data = data;
        up = null;
        down = null;
    }

    public String getkey() {
        return key;
    }

    public String getdata() {
        return String.valueOf(data);
    }

    public Node getdown() {
        return down;
    }

    public Node getup() {
        return up;
    }
}

class TreeMap {

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
            sb.append(node.getkey() + ":" + node.getdata());
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

    public boolean IsGreaterThan(String key1, String key2)

    {
        if (LetterToNumber(key1.charAt(0)) > LetterToNumber(key2.charAt(0)))
            return true;

        if (LetterToNumber(key1.charAt(0)) < LetterToNumber(key2.charAt(0)))
            return false;

        if (LetterToNumber(key1.charAt(1)) > LetterToNumber(key2.charAt(1)))
            return true;

        if (LetterToNumber(key1.charAt(1)) < LetterToNumber(key2.charAt(1)))
            return false;

        return false;
    }

    public void add(String key, int data) {
        root = addRecursive(root, key, data);
    }

    private Node addRecursive(Node current, String key, int data) {
        if (current == null) {
            return new Node(key, data);
        }
        
        if(doMapping(key) != 0) {
            delete(key);
        }

        if (IsGreaterThan(current.key, key)) {
            current.down = addRecursive(current.down, key, data);
            return current;
        }

        if (IsGreaterThan(key, current.key)) {
            current.up = addRecursive(current.up, key, data);
            return current;
        }

        if (key.equals(current.key)) {
            return current;
        }

        return current; /// This line is added only to show the compiler that
                        /// there is always a return data.
    }

    public int doMapping(String key) {
        return doMappingRecursive(root, key);
    }

    private int doMappingRecursive(Node current, String key) {
        if (current == null) {
            return -1;
        }
        if (key.equals(current.key)) {
            return current.data;
        }

        if (IsGreaterThan(current.key, key)) {
            return doMappingRecursive(current.down, key);

        }

        if (IsGreaterThan(key, current.key)) {
            return doMappingRecursive(current.up, key);

        }
        return -1; /// This line is added only to show the compiler that the
                   /// method always has a return data
    }

    private Node findSmallestkey(Node mynode) {
        if (mynode.down == null)
            return mynode;

        return findSmallestkey(mynode.down);

    }

    public void delete(String key) {
        if (root == null)
            return;
        root = deleteRecursive(root, key);
        return;

    }

    private Node deleteRecursive(Node current, String key) {
        if (current == null) {
            return null;
        }

        if (key.equals(current.key)) {

            if (current.down == null && current.up == null)

            {

                return null;

            }

            if (current.down == null)
                return current.up;

            if (current.up == null)
                return current.down;

            Node smallestkey = findSmallestkey(current.up);
            current.key = smallestkey.key;
            current.data = smallestkey.data;
            current.up = deleteRecursive(current.up, smallestkey.key);
            return current;

        }
        if (IsGreaterThan(current.key, key)) {
            current.down = deleteRecursive(current.down, key);
            return current;
        }

        if (IsGreaterThan(key, current.key)) {
            current.up = deleteRecursive(current.up, key);
            return current;
        }

        return null; /// This line is added only to show the compiler that there
                     /// is always a return data.

    }

    public int LetterToNumber(char ch)

    {

        int digit = 0;
        if (ch == 'A')
            digit = 0;

        if (ch == 'B')
            digit = 1;

        if (ch == 'C')
            digit = 2;

        if (ch == 'D')
            digit = 3;

        if (ch == 'E')
            digit = 4;

        if (ch == 'F')
            digit = 5;

        if (ch == 'G')
            digit = 6;

        if (ch == 'H')
            digit = 7;

        if (ch == 'I')
            digit = 8;

        if (ch == 'J')
            digit = 9;

        if (ch == 'K')
            digit = 10;

        if (ch == 'L')
            digit = 11;

        if (ch == 'M')
            digit = 12;

        if (ch == 'N')
            digit = 13;

        if (ch == 'O')
            digit = 14;

        if (ch == 'P')
            digit = 15;

        if (ch == 'Q')
            digit = 16;

        if (ch == 'R')
            digit = 17;

        if (ch == 'S')
            digit = 18;

        if (ch == 'T')
            digit = 19;

        if (ch == 'U')
            digit = 20;

        if (ch == 'V')
            digit = 21;

        if (ch == 'W')
            digit = 22;

        if (ch == 'X')
            digit = 23;

        if (ch == 'Y')
            digit = 24;

        if (ch == 'Z')
            digit = 25;
        return digit;
    }

}

class Application {

    public static void main(String argv[]) {

        TreeMap myBinaryTree = new TreeMap();
        
        myBinaryTree.add("AK",10);
        myBinaryTree.add("TX",19);
        myBinaryTree.add("FL",8);
        myBinaryTree.add("CO",7);
        myBinaryTree.add("ME",21);
        myBinaryTree.add("LA",15);
        myBinaryTree.add("CA",16);
        myBinaryTree.add("HI",14);
        myBinaryTree.add("GA",17);
        myBinaryTree.add("OR",22);
        myBinaryTree.add("WY",20);
        myBinaryTree.delete("LA");
        myBinaryTree.delete("CA");
        myBinaryTree.display();
        
        
        myBinaryTree.add("AK", 10);
        myBinaryTree.add("TX", 19);
        myBinaryTree.add("FL", 8);
        myBinaryTree.add("CO", 7);
        myBinaryTree.add("ME", 21);
        myBinaryTree.add("LA", 15);
        myBinaryTree.add("CA", 16);
        myBinaryTree.add("HI", 14);
        myBinaryTree.add("GA", 17);
        myBinaryTree.add("OR", 22);
        myBinaryTree.add("WY", 20);
        myBinaryTree.add("FL", 17);
        

        System.out.println(myBinaryTree.doMapping("FL"));

    }

}
