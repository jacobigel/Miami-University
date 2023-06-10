
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

class Queue

{

    private Link first;
    private Link last;

    public Queue()

    {
        first = null;
        last = null;

    }

    public void enQueue(Vertex myVertex) {

        Link newLink = new Link(myVertex);

        if (first == null)

        {

            newLink.next = null;
            newLink.previous = null;
            first = newLink;
            last = newLink;
            return;

        }

        newLink.next = null;
        newLink.previous = last;
        last.next = newLink;
        last = newLink;

        return;

    }

    public Vertex deQueue() {

        if (first == null)
            return null;

        Link tmp = first;

        if (first.next == null) {

            first = null;
            last = null;

            return tmp.Data;
        }

        first.next.previous = null;
        first = first.next;

        return tmp.Data;

    }

    public boolean isEmpty() {
        return first == null;
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
    private boolean[][] Adjacency;
    private Vertex[] VertexArray;

    int size;

    Graph() {
        size = 0;
    }

    public void display() {

        System.out.print("Adjacency Matrix:\n\n");

        System.out.print(String.format("%-6s", String.valueOf("")));
        for (int i = 0; i < size; i++)
            System.out.print(String.format("%-7s",
                    String.valueOf(VertexArray[i].label)));

        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(String.format("%-6s",
                    String.valueOf(VertexArray[i].label)));
            for (int j = 0; j < size; j++) {

                System.out.print(
                        String.format("%-6s", String.valueOf(Adjacency[i][j])));
                System.out.print(" ");
            }

            System.out.println();
        }

        System.out.println();

    }

    public void addVertex(String label) {

        size = size + 1;
        boolean[][] tmp;

        tmp = new boolean[size][size];

        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - 1; j++)
                tmp[i][j] = Adjacency[i][j];

        for (int j = 0; j < size; j++)
            tmp[size - 1][j] = false;

        for (int i = 0; i < size; i++)
            tmp[i][size - 1] = false;

        Adjacency = tmp;

        Vertex[] pro;
        pro = new Vertex[size];
        for (int i = 0; i < size - 1; i++)
            pro[i] = VertexArray[i];

        pro[size - 1] = new Vertex(label);

        VertexArray = pro;

    }

    void removeVertex(String label) {

        int index;
        for (index = 0; index < size; index++)
            if (VertexArray[index].equals(label))
                break;
        size = size - 1;
        boolean[][] tmp;

        tmp = new boolean[size][size];

        for (int i = 0; i < index; i++)
            for (int j = 0; j < index; j++)
                tmp[i][j] = Adjacency[i][j];

        for (int i = index + 1; i < size; i++)
            for (int j = 0; j < index; j++)
                tmp[i][j] = Adjacency[i][j];

        for (int i = 0; i < index; i++)
            for (int j = index + 1; j < size; j++)
                tmp[i][j] = Adjacency[i][j];

        for (int i = index + 1; i < size; i++)
            for (int j = index + 1; j < size; j++)
                tmp[i][j] = Adjacency[i][j];

        Adjacency = tmp;

        Vertex[] pro;

        pro = new Vertex[size];

        for (int i = 0; i < index; i++)
            pro[i] = VertexArray[i];

        for (int i = index + 1; i < size; i++)
            pro[i] = VertexArray[i];

        VertexArray = pro;

    }

    public void addEdge(String uLabel, String vLabel)

    {

        int u = VertexToIndex(LabelToVertex(uLabel));
        int v = VertexToIndex(LabelToVertex(vLabel));

        Adjacency[u][v] = true;
        Adjacency[v][u] = true;

    }

    public void removeEdge(String uLabel, String vLabel)

    {
        int u = VertexToIndex(LabelToVertex(uLabel));
        int v = VertexToIndex(LabelToVertex(vLabel));

        Adjacency[u][v] = false;
        Adjacency[v][u] = false;

    }

    public Vertex LabelToVertex(String label)

    {
        for (int i = 0; i < size; i++) {
            Vertex myVertex = VertexArray[i];
            if (myVertex.label.equals(label))
                return myVertex;
        }
        return null;

    }

    public int VertexToIndex(Vertex myVertex)

    {

        for (int i = 0; i < size; i++)
            if (VertexArray[i] == myVertex)
                return i;

        return -1; /// This line does not needed logically.

    }

    /**
     * The Visit method takes myVertex as an argument and prints the label of
     * myVertex in a separate line.
     * 
     * @param myVertex
     */
    void Visit(Vertex myVertex) {
        System.out.println(myVertex.label);
    }

    /**
     * The IsVisited method takes myVertex and the VisititedVertexes array as
     * arguments and return true only if myVertex is in the VisititedVertexes
     * array.
     * 
     * @param myVertex
     * @param VisititedVertexes
     * @return
     */
    boolean IsVisited(Vertex myVertex, Vertex[] VisititedVertexes) {
        for (int i = 0; i < VisititedVertexes.length; i++) {
            if (myVertex.equals(VisititedVertexes[i])) {
                return true;
            }
        }
        return false;
    }

    public void breadthFirstTraversal(String label) {
        System.out.println("Breadth First Traversal from Vertex: " +
                label);
        Vertex[] VisititedVertexes = new Vertex[size];
        int VisitedCounter = 0;
        Vertex CurrentVertex = LabelToVertex(label);
        if (CurrentVertex == null)
            return;
        Visit(CurrentVertex);
        VisititedVertexes[VisitedCounter] = CurrentVertex;
        VisitedCounter++;
        Queue myQueue = new Queue();
        myQueue.enQueue(CurrentVertex);
        while (!myQueue.isEmpty()) {
            CurrentVertex = myQueue.deQueue();
            for (int j = 0; j < size; j++) {
                Vertex AnotherVertex = VertexArray[j];
                if (Adjacency[VertexToIndex(CurrentVertex)][j] == true) {
                    if (IsVisited(AnotherVertex, VisititedVertexes))
                        continue;
                    Visit(AnotherVertex);
                    VisititedVertexes[VisitedCounter] = AnotherVertex;
                    VisitedCounter++;
                    myQueue.enQueue(AnotherVertex);
                }
            }
        }
    }

    public void depthFirstTraversal(String label) {
        System.out.println("Depth First Traversal from Vertex: " +
                label);
        Vertex[] VisititedVertexes = new Vertex[size];

        int VisitedCounter = 0;

        Vertex CurrentVertex = LabelToVertex(label);

        if (CurrentVertex == null)
            return;

        Visit(CurrentVertex);
        VisititedVertexes[VisitedCounter] = CurrentVertex;
        VisitedCounter++;

        StackV myStack = new StackV(size);

//        push CurrentVertex on myStack
        myStack.push(CurrentVertex);

        while (!myStack.isEmpty()) {
            CurrentVertex = myStack.pop();

            for (int j = 0; j < size; j++) {
                Vertex AnotherVertex = VertexArray[j];
//                if CurrentVertex and AnotherVertex are neighbors
                if (Adjacency[VertexToIndex(CurrentVertex)][j] == true) {
//                    if AnotherVertex is already visited
                    if (IsVisited(AnotherVertex, VisititedVertexes))
                        continue;
                    Visit(AnotherVertex);
                    VisititedVertexes[VisitedCounter] = AnotherVertex;
                    VisitedCounter++;

//                    push CurrentVertex on myStack
                    myStack.push(CurrentVertex);
//                    push AnotherVertex on myStack
                    myStack.push(AnotherVertex);
                    break;
                }
            }

        }

    }

}

class Application {

    public static void main(String[] argv)

    {

//        II. THE GRAPH CLASS
//        Graph myGraph = new Graph();
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

//        III. BREADTH FIRST TRAVERSAL
//        Graph myGraph = new Graph();
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
//        myGraph.breadthFirstTraversal("A");
//        myGraph.breadthFirstTraversal("C");
//        myGraph.breadthFirstTraversal("G");
//        myGraph.breadthFirstTraversal("K");

//        IV. DEPTH FIRST TRAVERAL
        Graph myGraph = new Graph();
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
        myGraph.depthFirstTraversal("C");
        myGraph.depthFirstTraversal("G");
        myGraph.depthFirstTraversal("K");

    }

}
