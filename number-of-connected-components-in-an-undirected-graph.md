```java
// Union Find + DFS
class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>();
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++){
            if(visited[i] == false) count++;
            dfs(graph,visited,i);
        }
        return count;
    }
    public void dfs(ArrayList<Integer>[] graph, boolean[]visited, int node){
        if (visited[node]){
            return;
        } else {
            visited[node] = true;
        }
        for (int i = 0; i < graph[node].size(); i++){
            dfs(graph, visited, graph[node].get(i));
        }
    }
}