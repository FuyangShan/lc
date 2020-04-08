# 1192. Critical Connections in a Network

There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:

Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.

```java
/*    (1/1)  (2/1)
        1 --- 2
       / \   / 
 (3/3)3    0 (3/1)
*/

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n]; // store the time node is discovered
        int[] low = new int[n]; // store the earliest node it can reach
        List<List<Integer>> result = new ArrayList<>(); // result list
        List<Integer>[] graph = new ArrayList[n]; // graph[0] = ArrayList<>(1,2)  0 -> 1,2
        // fill disc with -1
        Arrays.fill(disc, -1);
        
        // Build the graph
        for (List<Integer> conn : connections) {
            int from = conn.get(0);
            int to = conn.get(1);
            if (graph[from] == null) graph[from] = new ArrayList<>();
            if (graph[to] == null) graph[to] = new ArrayList<>();
            graph[from].add(to);            
            graph[to].add(from);
        }
        
        // dfs from any node
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) // start from undiscovered node
                dfs(i, disc, low, result, graph, i);
        }
        return result;
    }
    
    int time = 0;
    
    public void dfs(int cur, int[] disc, int[] low, List<List<Integer>> result, List<Integer>[] graph, int parent) {
        // update time when cur is discovered
        disc[cur] = low[cur] = ++time;
        // traverse the nexts of cur
        for (int next : graph[cur]) {
            if (next == parent) continue;
            if (disc[next] == -1) { // next is not discovered
                dfs(next, disc, low, result, graph, cur);
                low[cur] = Math.min(low[cur], low[next]);
                if (disc[cur] < low[next]) { // from "next" there is no path back to "cur", or previous of "cur", "cur -> next" is critical
                    result.add(Arrays.asList(cur, next));
                }
            } else { // next is discovered, update low[cur]
                low[cur] = Math.min(low[cur], disc[next]);
            }
        }
    }
}
```