// Complexity Analysis:
// Time Complexity: O(N*M) (where N and M are the dimensions of the grid)

// Running a nested loop to traverse every cell of grid takes O(N*M) time.
// In total, the traversal will be performed on grids taking overall at most of O(9*N*M) time.
// Space Complexity: O(N*M)

// Because of the visited array, it takes up O(N*M) space and the queue space will also be O(N*M) at most.

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIsland = 0;

        boolean[][] vis = new boolean[numRows][numCols];
        for(int row=0; row<numRows; row++) {
            for(int col=0; col<numCols; col++) {
                if(grid[row][col] == '1' && vis[row][col] == false) {
                    numIsland++;
                    bfs(row, col, grid, vis);
                }
            }
        }

        return numIsland;
    }

    public void bfs(int row, int col, char[][] grid, boolean[][] vis) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        vis[row][col] = true;

        int[] drow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dcol = {0, 1, 1, 1, 0, -1, -1, -1};

        while(!queue.isEmpty()) {
            Pair node = queue.poll();

            for(int i=0; i<8; i++) {
                int nrow = node.row+drow[i];
                int ncol = node.col+dcol[i];

                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol] == '1') {
                    if(vis[nrow][ncol] == false) {
                        vis[nrow][ncol] = true;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}

