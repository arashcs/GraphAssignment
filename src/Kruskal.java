
/** ******************************
 * Author: Beau Anderson, Joshua Stephenson-Losey, Arash Ajam
 * Date: 4/10/2018
 * Overview: Kruskal's algorithm
 ******************************** */
/*
 * large portions of this code are modified from https://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
 */
public class Kruskal {

    int Vertices;
    int Edges; //counts the vertices and edges

    public int runKruskal(int[][] graph) {
        Vertices = graph[0].length;
        Edges = graph[0].length * graph.length;
        graphConvert graphConvert = new graphConvert(Vertices, Edges);
        for (int i = 0; i < graph.length; i++) {
            for (int j = i; j < graph.length; j++) {
                graphConvert.edge[j + i * graph.length].source = i;
                graphConvert.edge[j + i * graph.length].dest = j;
                if (graph[i][j] != 0) {
                    graphConvert.edge[j + i * graph.length].weight = graph[i][j];
                } else {
                    graphConvert.edge[j + i * graph.length].weight = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < graphConvert.edge.length; i++) {
            if (graphConvert.edge[i].weight == 0) {
                graphConvert.edge[i].weight = Integer.MAX_VALUE;
            }

        }
        graphConvert.kruskalMST();
        return 1;
    }

    class graphConvert {
        // A class to represent a graph edge

        class edge {

            int source;
            int dest;
            int weight;

            //compares the current with another edge
            public int compareTo(edge compare) { //compares the weights using this value and an input from another edge
                return this.weight - compare.weight;
            }
        }

        // A class to represent a subset for finding unions of the edges
        class subset {

            int parent;
            int rank;
        }

        int VerticeCount;
        int Edges;    // V-> no. of vertices & E->no.of edges
        edge edge[]; // collection of all edges

        // Creates a graph with V vertices and E edges
        graphConvert(int v, int e) {
            VerticeCount = v;
            Edges = e;
            edge = new edge[Edges];
            for (int i = 0; i < e; i++) {
                edge[i] = new edge();
            }
        }

        // Find this integer 
        int find(subset subsets[], int findMe) {
            // find root and make root as parent of i (path compression)
            if (subsets[findMe].parent != findMe) {
                subsets[findMe].parent = find(subsets, subsets[findMe].parent);
            }

            return subsets[findMe].parent;
        }

        // A function that finds the intersect of two sets of x and y
        // (uses intersect by rank)
        void intersect(subset subsets[], int x, int y) {
            int xRoot = find(subsets, x);
            int yRoot = find(subsets, y);

            // Attach smaller rank tree under root of high rank tree
            // (intersect by Rank)
            if (subsets[xRoot].rank < subsets[yRoot].rank) {
                subsets[xRoot].parent = yRoot;
            } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
                subsets[yRoot].parent = xRoot;
            } // If ranks are same, then make one as root and increment
            // its rank by one
            else {
                subsets[yRoot].parent = xRoot;
                subsets[xRoot].rank++;
            }
        }

        public void kruskalMST() {
            edge result[] = new edge[Edges]; //stores the resulting MST
            int e = 0; //indexing variable for the edges
            int r = 0; //indexing variable for the result
            for (e = 0; e < Vertices; e++) {
                result[e] = new edge() {
                };
            }

            // Sort all the edges based on the weight within. This could also be done with a PriorityQueue
            for (int i = (Edges - 1); i >= 0; i--) {
                for (int j = 1; j <= i; j++) {
                    if (edge[j - 1].weight > edge[j].weight) {
                        int tempWeight = edge[j - 1].weight;
                        int tempSrc = edge[j - 1].source;
                        int tempdest = edge[j - 1].dest;
                        edge[j - 1].weight = edge[j].weight;
                        edge[j - 1].source = edge[j].source;
                        edge[j - 1].dest = edge[j].dest;
                        edge[j].weight = tempWeight;
                        edge[j].source = tempSrc;
                        edge[j].dest = tempdest;
                    }
                }
            }

            subset subsets[] = new subset[Vertices];
            //set up enough locations for all of the edges
            for (e = 0; e < Vertices; e++) {
                subsets[e] = new subset();
            }
            // Create Vertices subsets with single elements
            for (int v = 0; v < Vertices; v++) {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }
            e = 0;  // Index used to pick next edge
            while (r < Vertices - 1) {
                // Pick the smallest edge. And increment the index for next iteration
                edge next_edge = new edge();
                next_edge = edge[e++];

                int x = find(subsets, next_edge.source);
                int y = find(subsets, next_edge.dest);

                // If including this edge does't cause cycle,
                // include it in result and increment the index 
                // of result for next edge
                if (x != y) {
                    result[r++] = next_edge;
                    intersect(subsets, x, y);
                }
                // Else discard the next_edge
            }
            // print the min span tree
            //System.out.println("Following are the edges in the constructed MST");

            String[] lable = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            System.out.println("The Kruskal Minimum Spanning Tree Resulted in:");
            for (e = 0; e < r; e++) {
                
                System.out.print(" " + lable[result[e].source] + "" + lable[result[e].dest] + " ");
            }
            System.out.println("");
        }
    }
}

