// Initial configurations
// Declare queue and visited array
// Mark the starting node as visited and put that into the queue

// V = N = No.of nodes
// E = No. of edges
// TC: O(V + 2E) = (N + 2E)
// SC: O(3V) = O(3N)
public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
    Queue<Integer> queue = new LinkedList<>();
    boolean vis[] = new boolean[V];
    List<Integer> ans = new ArrayList<>();

    // starting node = 0
    queue.add(0);
    vis[0] = true;

    while(!queue.isEmpty()) {
      int element = queue.poll();
      ans.add(element);

      for(Integer it: adj.get(element)) {
        if(vis[it] == false) {
          vis[it] = true;
          queue.add(it);
        }
      }
    }

    return ans;
  }
