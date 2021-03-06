# 787. Cheapest Flights Within K Stops

There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
Note:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.

```java
// Best First Search, MST
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // build graph to store costs from A to B
        int[][] graph = new int[n][n];
        for (int[] f : flights) {
            graph[f[0]][f[1]] = f[2];
        }
        // <cost, stop, startStop>
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[] {0, 0, src});
        
        // <stop, bestCost>
        Map<Integer, Integer> best = new HashMap<>();
        
        // expanding nodes from src node, generate the neighbor nodes
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], k = cur[1], stop = cur[2];
            if (k > K+1 || cost > best.getOrDefault(k * 1000 + stop, Integer.MAX_VALUE)) 
                continue; // if take more than K stops, do not expand
            if (stop == dst) return cost; // reached destination, return 
            for (int next = 0; next < n; next++) {
                if (graph[stop][next] > 0) {
                    int newCost = cost + graph[stop][next];
                    if (newCost < best.getOrDefault((k + 1) * 1000 + next, Integer.MAX_VALUE)) { // generate node if there is no better cost to reach next node with k+1 stop
                        pq.offer(new int[] {newCost, k + 1, next});
                        best.put((k + 1) * 1000 + next, newCost); // store the optimal cost to reach next node with k+1 stops
                    }
                }
            }
        }
        return -1;
    }
}
```