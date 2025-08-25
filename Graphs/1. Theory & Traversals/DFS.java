// V = N = No.of nodes
// E = No. of edges
// TC: O(V + 2E) = (N + 2E) = Undirected Graph for Directed Graph = O(N + E)
// SC: O(3V) = O(3N)
public void dfs(int node, List<List<Integer>> adj, List<Integer> ans, boolean vis[]) {
    vis[node] = true;
    ans.add(node);

    for (Integer it : adj.get(node)) {
      if (vis[it] == false) {
        dfs(it, adj, ans, vis);
      }
    }
  }

  public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
    boolean vis[] = new boolean[V];
    List<Integer> ans = new ArrayList<>();
    dfs(0, adj, ans, vis);
    return ans;
  }
