// Using DFS & BFS
class Solution {
    public void bfs(int node, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> queue = new LinkedList<>();
        vis[node] = true;
        queue.add(node);

        while(!queue.isEmpty()) {
            int element = queue.poll();
            for(Integer nb : adj.get(element)) {
                if(vis[nb] != true) {
                    vis[nb] = true;
                    queue.add(nb);
                }
            }
        }
    }

    public void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for(Integer nb : adj.get(node)) {
            if(vis[nb] == false) {
                dfs(nb, adj, vis);
            }
        }
    }

    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];

        int numOfComponents = 0;
        for(int i=0; i<V; i++) {
            if(vis[i] != true) {
                numOfComponents++;
                dfs(i, adj, vis);
            }
        }

        return numOfComponents;
    }
}
