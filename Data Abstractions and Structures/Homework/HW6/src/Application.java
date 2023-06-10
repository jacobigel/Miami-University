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

        System.out.print("Adjacancy Matrix:\n\n");

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

    public void removeEdge(int u, int v)

    {
        Adjacency[u][v] = false;
        Adjacency[v][u] = false;

    }

    public int VertexToIndex(Vertex myVertex)

    {

        for (int i = 0; i < size; i++)
            if (VertexArray[i] == myVertex)
                return i;

        return -1; /// This line does not needed logically.

    }

    public boolean IsVisited(Vertex NeighborVertex, Vertex[] VisititedVertexes)

    {

        int t;
        for (t = 0; t < size; t++) {
            if (VisititedVertexes[t] != NeighborVertex)
                continue;

            break;

        }

        if (t != size)
            return true;

        return false;
    }

    public void Visit(Vertex AnotherVertex, Vertex CurrentVertex,
            String[] PathArray)

    {
        //// Fill in the body of the method ////
        PathArray[VertexToIndex(
                LabelToVertex(AnotherVertex.label))] = PathArray[VertexToIndex(
                        LabelToVertex(CurrentVertex.label))]
                        + CurrentVertex.label;
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

    void ShortestPath(String SourceLabel, String DestinationLabel) {

        String[] PathArray = new String[size];
        PathArray[VertexToIndex(LabelToVertex(SourceLabel))] = "";

        Vertex[] VisititedVertexes = new Vertex[size];
        int VisitedCounter = 0;

        Vertex CurrentVertex = LabelToVertex(SourceLabel);

        if (CurrentVertex == null)
            return;

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

                    Visit(AnotherVertex, CurrentVertex, PathArray);

                    VisititedVertexes[VisitedCounter] = AnotherVertex;
                    VisitedCounter++;

                    myQueue.enQueue(AnotherVertex);
                }

            }

        }

        System.out.println("Shortest path from Vertex " + SourceLabel
                + " to Vertex " + DestinationLabel + " is: ");

        if (PathArray[VertexToIndex(LabelToVertex(DestinationLabel))] == null)
            return;

        System.out.println(
                PathArray[VertexToIndex(LabelToVertex(DestinationLabel))]
                        + DestinationLabel);

    }

}

class Application {

    public static void main(String[] argv)

    {
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
        myGraph.ShortestPath("A", "G");
        myGraph.ShortestPath("F", "H");
        myGraph.ShortestPath("A", "K");

    }

}
