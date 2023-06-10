
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
class Link

{
    public Vertex Data;

    public Link previous;

    public Link next;

    public Link(Vertex myVertex)

    {
        Data = myVertex;
    }
}

class LinkedList {
    public Link first;

    LinkedList() {
        first = null;
    }

    public void insertFirst(Vertex myVertex) {
        Link newLink = new Link(myVertex);

        if (first == null) {

            newLink.next = null;
            first = newLink;
            return;
        }

        newLink.next = first;
        first = newLink;
        return;

    }

    public boolean find(String myLabel) {
        if (first == null)
            return false;

        Link current = first;
        while (current != null) {
            if (current.Data.label.equals(myLabel))
                return true;

            current = current.next;
        }
        return false;
    }

    public void display() {
        Link current = first;
        while (current != null) {
            System.out.print(current.Data.label + " ");
            current = current.next;
        }
        System.out.println("");
        return;
    }

}

class StackV

{
    int size;
    int top;
    private Vertex[] InternalArray;

    StackV(int theSize)

    {
        top = -1;
        size = theSize;

        InternalArray = new Vertex[size];

    }

    public void push(Vertex myVertex)

    {
        top = top + 1;
        InternalArray[top] = myVertex;
        return;

    }

    public Vertex pop()

    {

        Vertex tmp = InternalArray[top];

        top = top - 1;

        return tmp;

    }

    public boolean isEmpty()

    {

        return top == -1;
    }

}

class Vertex {
    String label;

    Vertex(String theLabel) {
        label = theLabel;
    }

}

class Graph {
    private LinkedList[] AdjacencyList;
    private Vertex[] VertexArray;
    int size;
    int maxSize;

    Graph(int theMaxSize) {
        maxSize = theMaxSize;
        size = 0;
        VertexArray = new Vertex[maxSize];
        AdjacencyList = new LinkedList[maxSize];

        for (int i = 0; i < maxSize; i++) {
            AdjacencyList[i] = new LinkedList();
        }
    }

    public void display() {

        System.out.print("Adjacency List:\n\n");

        for (int i = 0; i < size; i++) {
            System.out.print(String.format("%-6s",
                    String.valueOf(VertexArray[i].label) + ": "));

            AdjacencyList[i].display();

        }

        System.out.println("");

    }

    public void addVertex(String label) {

        Vertex newVertex = new Vertex(label);
        AdjacencyList[size] = new LinkedList();
        VertexArray[size] = newVertex;
        size = size + 1;
    }

    public boolean IsVisited(Vertex myVertex, Vertex[] VisititedVertexes) {
        int t;
        for (t = 0; t < size; t++) {
            if (VisititedVertexes[t] != myVertex)
                continue;

            break;

        }

        if (t != size)
            return true;

        return false;
    }

    public void Visit(Vertex myVertex)

    {

        System.out.println(myVertex.label);

    }

    public void addEdge(String uLabel, String vLabel) {

        Vertex vVertex = null;
        for (int i = 0; i < size; i++) {
            //            if the label of VertexArray[i] is vLabel
            if (VertexArray[i].label.equals(vLabel)) {
                vVertex = VertexArray[i];
            }
        }

        for (int i = 0; i < size; i++) {
            if (VertexArray[i].label.equals(uLabel)) {
                //                if AdjacencyList[i] does not have a Vertex with vLabel
                if (!AdjacencyList[i].find(vLabel)) {
                    AdjacencyList[i].insertFirst(vVertex);
                    return;
                }
            }
        }
    }

    public void depthFirstTraversal(String label) {
        System.out.println("Depth First Traversal from Vertex: " + label);
        Vertex[] VisititedVertexes = new Vertex[size];
        int VisitedCounter = 0;
        Vertex CurrentVertex = null;

        for (int i = 0; i < size; i++) {
            if (VertexArray[i].label.equals(label)) {
                CurrentVertex = VertexArray[i];
            }
        }

        if (CurrentVertex == null) {
            return;
        }

        Visit(CurrentVertex);
        VisititedVertexes[VisitedCounter] = CurrentVertex;
        VisitedCounter++;

        StackV myStack = new StackV(size);
        //        push CurrentVertex on myStack
        myStack.push(CurrentVertex);

        //        while myStack is not empty
        while (!myStack.isEmpty()) {
            CurrentVertex = myStack.pop();
            Link currentLink = null;
            for (int i = 0; i < size; i++) {
                //                if VertexArray[i] and CurrentVertex are same references
                if (VertexArray[i] == CurrentVertex) {
                    currentLink = AdjacencyList[i].first;
                }
            }
            
            while (currentLink != null) {
                //                NeighborVertex is the Data inside currentLink
                Vertex NeighborVertex = currentLink.Data;
                //                if NeighborVertex is already visited
                if (IsVisited(NeighborVertex, VisititedVertexes)) {
                    currentLink = currentLink.next;
                    continue;
                }

                Visit(NeighborVertex);
                VisititedVertexes[VisitedCounter] = NeighborVertex;
                VisitedCounter++;

                //                push CurrentVertex on myStack
                myStack.push(CurrentVertex);

                //                push NeighborVertex on myStack
                myStack.push(NeighborVertex);
                break;

            }
        }

    }

}

class Application {

    public static void main(String[] argv)

    {

        //        Graph myGraph = new Graph(100);
        //        myGraph.addVertex("A");
        //        myGraph.addVertex("B");
        //        myGraph.addVertex("C");
        //        myGraph.addVertex("D");
        //        myGraph.addVertex("E");
        //        myGraph.addVertex("F");
        //        myGraph.addVertex("G");
        //        myGraph.addVertex("H");
        //        myGraph.addVertex("I");
        //        myGraph.addVertex("J");
        //        myGraph.addVertex("K");
        //        myGraph.addEdge("A", "B");
        //        myGraph.addEdge("B", "A");
        //        myGraph.addEdge("B", "E");
        //        myGraph.addEdge("E", "B");
        //        myGraph.addEdge("A", "C");
        //        myGraph.addEdge("C", "A");
        //        myGraph.addEdge("B", "D");
        //        myGraph.addEdge("D", "B");
        //        myGraph.addEdge("D", "C");
        //        myGraph.addEdge("C", "D");
        //        myGraph.addEdge("C", "E");
        //        myGraph.addEdge("E", "C");
        //        myGraph.addEdge("E", "F");
        //        myGraph.addEdge("F", "E");
        //        myGraph.addEdge("D", "G");
        //        myGraph.addEdge("G", "D");
        //        myGraph.addEdge("E", "G");
        //        myGraph.addEdge("G", "E");
        //        myGraph.addEdge("G", "H");
        //        myGraph.addEdge("H", "G");
        //        myGraph.addEdge("C", "I");
        //        myGraph.addEdge("I", "C");
        //        myGraph.addEdge("A", "J");
        //        myGraph.addEdge("J", "A");
        //        myGraph.display();

        Graph myGraph = new Graph(100);
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");
        myGraph.addVertex("E");
        myGraph.addVertex("F");
        myGraph.addVertex("G");
        myGraph.addVertex("H");
        myGraph.addVertex("I");
        myGraph.addVertex("J");
        myGraph.addVertex("K");
        myGraph.addEdge("A", "B");
        myGraph.addEdge("B", "A");
        myGraph.addEdge("B", "E");
        myGraph.addEdge("E", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("C", "A");
        myGraph.addEdge("B", "D");
        myGraph.addEdge("D", "B");
        myGraph.addEdge("D", "C");
        myGraph.addEdge("C", "D");
        myGraph.addEdge("C", "E");
        myGraph.addEdge("E", "C");
        myGraph.addEdge("E", "F");
        myGraph.addEdge("F", "E");
        myGraph.addEdge("D", "G");
        myGraph.addEdge("G", "D");
        myGraph.addEdge("E", "G");
        myGraph.addEdge("G", "E");
        myGraph.addEdge("G", "H");
        myGraph.addEdge("H", "G");
        myGraph.addEdge("C", "I");
        myGraph.addEdge("I", "C");
        myGraph.addEdge("A", "J");
        myGraph.addEdge("J", "A");
        myGraph.depthFirstTraversal("A");
        myGraph.depthFirstTraversal("K");

    }

}