# 1135. Connecting Cities With Minimum Cost

- https://leetcode.com/problems/connecting-cities-with-minimum-cost/

There are N cities numbered from 1 to N.

You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)

Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.

 

Example 1:



Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: 
Choosing any 2 edges will connect all cities so we choose the minimum 2.
Example 2:



Input: N = 4, connections = [[1,2,3],[3,4,4]]
Output: -1
Explanation: 
There is no way to connect all cities even if all edges are used.

```java
/*
          1. ----5---- 2
           \         /
             7     1 
              \   / 
                3
                
     1 -> (2, 5), (3, 7)
     2 -> (1, 5), (3, 1)
     3 -> (1, 7), (1, 2)
     
     start from node (1,0)
     expand 1, add cost 0 to total
     generate (2, 5), (3, 7) to PQ, visited add 1
     
     expand 2, add cost 5 to total
     generate (1, 5) (3, 1) (3, 7)
     

*/
class Pair {
    int next;
    int cost;
    
    public Pair(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }
}

class Solution {
    public int minimumCost(int N, int[][] connections) {
        // build graph with HashMap<id, nextId>
        Map<Integer, List<Pair>> map = new HashMap<>();
        
        for (int[] conn : connections) {
            int s = conn[0], e = conn[1], cost = conn[2];
            if (!map.containsKey(s)) map.put(s, new ArrayList<>());
            if (!map.containsKey(e)) map.put(e, new ArrayList<>());
            Pair sPair = new Pair(e, cost);
            Pair ePair = new Pair(s, cost);

            map.get(s).add(sPair);
            map.get(e).add(ePair);
        }
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer>  best = new HashMap<>();                        
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
        q.add(new Pair(1,0));
        
        int costs = 0;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.cost > best.getOrDefault(cur.next, Integer.MAX_VALUE)) continue;
            
            if (!visited.contains(cur.next)) {
                costs += cur.cost;
                visited.add(cur.next);
                for (Pair next : map.get(cur.next)) {
                    q.add(next);
                    best.put(next.next, next.cost);
                }    
            } 
        }
        return visited.size() == N ? costs : -1;

    }
}
```

```java
/* Union Find
    sort connections by cost
    start from lowest cost pair
    compare parent of each node
    case 1: they are not under same parent, then union them, add cost, and decrement parents count
    case 2: they are same parent, do nothing
*/
class Solution {
    
    int[] parent;
    int n;
    
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if (px != py) {
            parent[px] = py;
            n--;
        }
    }
    
    private int find(int x) {
        if (parent[x] == x) return parent[x];
        return find(parent[x]);
    }
    
    public int minimumCost(int N, int[][] connections) {
        parent = new int[N + 1];
        n = N;
        for (int i = 0; i <= N; i++) parent[i] = i;

        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
         
        int res = 0; 
        for (int[]  : connections) {
            int x = c[0], y = c[1];
            if (find(x) != find(y)) {
                res += c[2];
                union(x, y);
            }
        }
        return n == 1 ? res : -1;
    }
}
```