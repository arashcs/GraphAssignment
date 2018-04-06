import java.util.LinkedList;

public class Graph {
    int N;      //Number of nodes
    LinkedList<Integer> adjList[];

    //constructor
    public Graph(int n){
        this.N = n;
        adjList = new LinkedList[n];

        //Create a linked list for each vertex
        //to store adjacent vertices
        for(int i = 0; i < N; i++){
            adjList[i] = new LinkedList<>();
        }
    }
    // Adds an edge to an undirected graph
    static void addEdge(Graph graph, int v, int w)
    {
        // Add an edge from v to w.
        graph.adjList[v].addFirst(w);

        // Since graph is undirected, add an edge from w to v
        graph.adjList[w].addFirst(v);
    }
    static void printGraph(Graph graph)
    {
        for(int i = 0; i < graph.N; i++)
        {
            System.out.println("Adjacency list of vertex "+ i);
            System.out.print("start");
            for(Integer node: graph.adjList[i]){
                System.out.print(" -> "+node);
            }
            System.out.println("\n");
        }
    }
}
