class Solution{ 
    private static void findPathHelper(int row, int col, int[][] maze, int n, boolean[][] visited, ArrayList<String> result, String path, String[] dir, int[] rowDiff, int[] colDiff){
        if(row == n-1 && col == n-1){
            result.add(path);
            return;
        }
        
        for(int i=0; i<4; i++){
            int nextRow = row + rowDiff[i];
            int nextCol = col + colDiff[i];
            
            if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<n && !visited[nextRow][nextCol] && maze[nextRow][nextCol] == 1){
                visited[row][col] = true;
                findPathHelper(nextRow, nextCol, maze, n, visited, result, path+dir[i], dir, rowDiff, colDiff);
                visited[row][col] = false;
            }
        }
        
    }    
    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] visited = new boolean[n][n];
        int[] rowDiff = {1, 0, 0,-1};
        int[] colDiff = {0, -1, 1, 0};
        String[] dir = {"D", "L", "R", "U"};
        ArrayList<String> result = new ArrayList<String>();
        if(m[0][0] == 1) findPathHelper(0, 0, m, n, visited, result, "", dir, rowDiff, colDiff);
        return result;
    }
}
