// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        /*
         * (0)----(1)
         *  |\     |\
         *  | \    | \
         *  |  \   |  (3)
         *  |   \  | /
         *  |    \ |/
         * (4)----(2)
        */
        
        /*
         * Graph Representation
         * Given: For undirected graph
         *      n = number of nodes
         *      e = number of edges
         *      e times (u,v) {represents an edge between u and v node}
         * If graph had been weighted 3rd parameter would also have been given (u,v,w) { represents an edge with w weight between u and v}
         * Space Complexity : O(n^2)
        */
        
        /*
         * Method 1 : Adjacency Matrix
         * adjacency_matrix[n][n];
         * adjacency_matric[0][1] = 1 or w(if weighted graph); ... etc
         * Disadvantage : if n = 10^5 {Memory Limit Exceeded}
        */
        int n = 5, e = 7;
        int adjacency_matrix[][] = new int[n][n];
        
        //edge 0---1
        adjacency_matrix[0][1] = 1;
        adjacency_matrix[1][0] = 1;
        
        //edge 0---2
        adjacency_matrix[0][2] = 1;
        adjacency_matrix[2][0] = 1;
        
        //edge 0---4
        adjacency_matrix[0][4] = 1;
        adjacency_matrix[4][0] = 1;
        
        //edge 1---2
        adjacency_matrix[1][2] = 1;
        adjacency_matrix[2][1] = 1;
        
        //edge 1---3
        adjacency_matrix[1][3] = 1;
        adjacency_matrix[3][1] = 1;
        
        //edge 4---2
        adjacency_matrix[4][2] = 1;
        adjacency_matrix[2][4] = 1;
        
        //edge 2---3
        adjacency_matrix[2][3] = 1;
        adjacency_matrix[3][2] = 1;
        
        System.out.println("Adjacency Matrix");
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                System.out.print(adjacency_matrix[row][col]+" ");
            }
            System.out.println();
        }
        
        /*
         * Method 2 : Adjacency List
         * ArrayList<ArrayList<Integer> adjacency_list = new ArrayList<ArrayList<Integer>>();
         * Initially, I have n empty ArrayList in adjacency_list
         * For egde 1---2, I will add 2 in 1st indexed ArrayList and add 1 in 2nd indexed ArrayList
         * Every indexed ArrayList stored all th adjacent nodes which have edges pointed to it 
         * 
         * 0 --- 1,2,4 {Represent 0th node is connected with 1st, 2nd and 4th nodes}
         * 1 --- 0,2,3
         * 2 --- 0,1,3,4
         * 3 --- 1,2
         * 4 --- 0,2
         *
         * For weighted graph you can store pair of integer<Integer,Integer> eg:
         * 0 --- (1,w1),(2,w2),(4,w4) .... and so on
         *
         * Space Complexity :Undirected Graph = O(n + 2*e)
         *                   Directed Graph = O(n + e)
        */
        
        ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<n; i++){
            adjacency_list.add(new ArrayList<Integer>());
        }
        
        //edge 0---1
        adjacency_list.get(0).add(1);
        adjacency_list.get(1).add(0);
        
        //edge 0---2
        adjacency_list.get(0).add(2);
        adjacency_list.get(2).add(0);
        
        //edge 0---4
        adjacency_list.get(0).add(4);
        adjacency_list.get(4).add(0);
        
        //edge 1---2
        adjacency_list.get(1).add(2);
        adjacency_list.get(2).add(1);
        
        //edge 1---3
        adjacency_list.get(1).add(3);
        adjacency_list.get(3).add(1);
        
        //edge 4---2
        adjacency_list.get(4).add(2);
        adjacency_list.get(2).add(4);
        
        //edge 2---3
        adjacency_list.get(2).add(3);
        adjacency_list.get(3).add(2);
        
        System.out.println("Adjacency List");
        for(int row=0; row<n; row++){
            for(int col=0; col<adjacency_list.get(row).size(); col++){
                System.out.print(adjacency_list.get(row).get(col)+" ");
            }
            System.out.println();
        }
    }
}
