/********************************
 * Author: Joshua Stephenson-Losey, Arash Ajam, Beau Anderson
 * Date: 4/5/18
 * Overview: Floyd-Worshall algorithm
 *********************************/
import java.util.PriorityQueue;

public class Prim {
    int[] A;

    public int[][] runPrim(int[][] graph) {

        PriorityQueue<Integer> unMarked = new PriorityQueue<>(graph.length); //holds unmarked vertices
        PriorityQueue<Integer> marked = new PriorityQueue<>(graph.length);  //holds marked vertices

        //holds MST vertices
        int[][] MST = new int[graph.length][graph.length];

        //initialize unmarked queue with all the vertices
        for (int i = 0; i < graph.length; i++) {
            unMarked.add(i);
        }

        //starting with a random node, in this case 0 which is equivalent to A
        int initialNode = 0;

        unMarked.remove(initialNode);   //remove the initial node from unmarked
        marked.add(initialNode);    //add the initial node to marked

        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        //loops through each adjacent vertex of initial node and chooses the minimum edge
        for (int i = 0; i < graph.length; i++) {
            int adjWeight = graph[initialNode][i];
            if (adjWeight < min){
                min = adjWeight;
                minIndex = i;
            }
        }


        unMarked.remove(minIndex);  //remove the new vertex from unmarked
        marked.add(minIndex);       //add the new vertex to marked

//
//        for (int i = 0; i < MST.length; i++) {
//            for (int j = 0; j < MST.length; j++) {
//                MST[i][j] = 0; //setting vertices without edge connecting to each other to zero
//            }
//        }

        //adds the two vertices chosen so far to the MST array
        MST[initialNode][minIndex] = min;
        MST[minIndex][initialNode] = min;

        //for each marked vertex in the graph it loops through its adjacent unmarked vertices and finds minimum edge
        while(unMarked.size() > 0){
            min = Integer.MAX_VALUE;
            int count = 0;
            for(Integer element : marked){
                count++;
                for (int i = 0; i < graph.length; i++) {
                    if (unMarked.contains(i)){
                        if (graph[element][i] < min) {
                            min = graph[element][i];
                            minIndex = i;
                        }
                    }
                }
                if (count == marked.size()){
                    MST[element][minIndex] = min;
                    MST[minIndex][element] = min;
                }
            }
            unMarked.remove(minIndex);
            marked.add(minIndex);
        }
        System.out.println("PRIM'S MST MATRIX:");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(MST[i][j] + " ");
            }
            System.out.println();
        }
        return MST;
    }

}


