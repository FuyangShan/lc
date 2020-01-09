```java
// Union Find + DFS
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<Integer>(); 
        for (int[] e: edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        boolean[] visited = new boolean[n];
        if (!dfs(adj, visited, 0, -1)) return false;
        for (boolean b:visited)
            if(!b) return false;
        return true;
    }
    public boolean dfs(List<Integer>[] adj, boolean[] visited, int node, int pre){
        visited[node] = true;
        for (int i: adj[node]){
            if (i == pre) continue;
            if (visited[i] || !dfs(adj, visited, i, node)) return false;
        }
        return true;
    }
}

// Union Find + BFS
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0 || edges.length + 1 != n) return false;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        Set<Integer> res = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        res.add(0);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int num : map.get(curr)) {
                if (res.contains(num)) continue;
                q.offer(num);
                res.add(num);
            }
        }
        return res.size() == n;
    }
}
```