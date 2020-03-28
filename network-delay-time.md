# Network Delay Time

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

 

Example 1:



Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2
 

Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.


```java
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        if (times.length == 0) return -1;
        
        // use HashMap to build the graph, store <src, List<time, tgt>>
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            if (!graph.containsKey(time[0])) {
                graph.put(time[0], new ArrayList<>());
            }
            graph.get(time[0]).add(new int[] {time[2], time[1]});
        }
        
        // sort the values of graph so we iterate the tgts for a node from the closest node
        for (int key : graph.keySet()) {
            Collections.sort(graph.get(key), (a, b) -> (a[0] - b[0]));
        }
        
        // use HashMap to store timestamp when node receive signals
        HashMap<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        
        // dfs sending signal from K and update timestamp for every node in graph
        DFS(graph, dist, K, 0);
        // iterate the timestamp records to get the last timestamp
        int res = 0;
        for (int time : dist.values()) {
            if (time == Integer.MAX_VALUE) return -1;
            res = Math.max(res, time);
        }
        return res;
    }
    
    public void DFS(HashMap<Integer, List<int[]>> graph, HashMap<Integer, Integer> dist, int src, int time) {
        // if src got signal before "time", do nothing and return
        if (time >= dist.get(src)) return;
        // update the time 
        dist.put(src, time);
        if (graph.containsKey(src)) {
            for (int[] node : graph.get(src)) {
                // node[0] is time to take to travel from K to node[1]
                DFS(graph, dist, node[1], time + node[0]);
            }
        }
    }
}
```

