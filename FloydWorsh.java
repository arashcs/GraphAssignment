/********************************
 * Author: Joshua Stephenson-Losey, Arash Ajam, Beau Anderson
 * Date: 4/5/18
 * Overview: Floyd-Worshall algorithm
 *********************************/
public class FloydWorsh {
    public void run(int[][] weight){
        //for each row
        int row = 0;
        for (int vert[] : weight) {
            //set the diagonal vertex to zero
            vert[row] = 0;
            row++;
        }
        for (int k = 0; k < weight.length; k++) {
            for (int i = 0; i < weight.length; i++) {
                for (int j = 0; j < weight.length; j++) {
                    if(weight[i][j] > weight[i][k] + weight[k][j]){
                        weight[i][j] = weight[i][k] + weight[k][j];
                        //if a change was made print new graph
                        print(weight);
                    }
                }
            }
        }
    }

    public void print(int[][] weight){
        for (int row = 0; row < weight.length; row++) {
            for (int col = 0; col < weight.length; col++) {
                int val = weight[row][col];
                if(val >= 2000000){
                    System.out.print("inf  ");
                }
                else{
                    System.out.print(val + "   ");
                    if(val < 10){
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
