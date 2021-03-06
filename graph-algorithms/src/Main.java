/********************************
 * Author: Joshua Stephenson-Losey, Arash Ajam, Beau Anderson
 * Date: 4/5/18
 * Overview: Floyd-Worshall algorithm
 *********************************/
public class Main {
    public static void main(String[] args) {

        CreateGraph createGraph = new CreateGraph();
        int[][] graph = createGraph.getGraph();

        System.out.println("Representation of the original Graph:");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        /*PRIM'S ALGORITHM*/
        Prim prim = new Prim();
        prim.runPrim(graph);

        FloydWorsh algo = new FloydWorsh();

        /*KRUSKAL'S ALGORITHM*/


        /*FLOYD WORSH'S ALGORITHM*/
        System.out.println("FLOYDWORSH ALGORITHM:");
        System.out.println("Start:");
        algo.print(graph);
        System.out.println();

        algo.run(graph);
        System.out.println("Finish:");
        algo.print(graph);




    }
}
