class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    
    // Approach : Recursion + Backtracking
    // Time Complexity  : O(m^n){n nodes can have m different coloured, if conditions are ignored}
    // Space Complexity : O(n){color} + O(n){Auxiliary Space}
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] color = new int[n];
        if(solve(0, m, n, color, graph) == true) return true;
        return false;
    }
    
    private boolean solve(int node, int m, int n, int[] color, boolean graph[][]){
        if(node == n) return true;
        
        for(int i=1; i<=m; i++){
            if(isValid(node, n, graph, color, i)){
                color[node] = i;
                if(solve(node+1, m, n, color, graph) == true){
                    return true;
                }
                color[node] = 0;
            }
        }
        
        return false;
    }
    
    private boolean isValid(int node, int n, boolean graph[][], int[] color, int col){
        for(int i=0; i<n; i++){
            if(i!=node && graph[node][i]){
                if(color[i] == col){
                    return false;
                }
            }
        }
        
        return true;
    }
}
