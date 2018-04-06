public class Main {
    public static void main(String[] args) {
        // create the graph given in above figure
        int numOfNodes = 5;
        Graph graph = new Graph(numOfNodes);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 4);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 1, 3);
        graph.addEdge(graph, 1, 4);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 3, 4);

        // print the adjacency list representation of
        // the above graph
        graph.printGraph(graph);
    }
}
