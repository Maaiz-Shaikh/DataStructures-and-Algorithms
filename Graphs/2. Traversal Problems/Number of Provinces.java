// Complexity Analysis:
// Time Complexity: O(V + E) (where V denotes the number of nodes, E denotes the number of edges)

// Converting adjacency matrix to list takes O(V2) time (equivalent to O(E)).
// Considering overall, all the nodes are visited through traversal techniques which takes O(V+ E) time.
// Space Complexity: O(V + E)

// Storing the adjacency list takes O(E) space.
// Any traversal technique takes O(V) extra space.

class Solution {
    public void dfs(int node, int[][] adj, boolean[] vis) {
        vis[node] = true;
        for(int i=0; i<adj[node].length; i++) {
            if(adj[node][i] != 0 && vis[i] == false) {
                dfs(i, adj, vis);
            }
        }
    }

    public int numProvinces(int[][] adj) {
        int n = adj.length;
        boolean[] vis = new boolean[n];

        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(vis[i] == false) {
                cnt++;
                dfs(i, adj, vis);
            }
        }

        return cnt;
    }
}

