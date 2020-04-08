# Min Cost to Connect All Nodes

https://leetcode.com/discuss/interview-question/356960/Amazon-or-OA-2019-or-Find-Pair-With-Given-Sum

Given an undirected graph with n nodes labeled 1..n. Some of the nodes are already connected. The i-th edge connects nodes edges[i][0] and edges[i][1] together. Your task is to augment this set of edges with additional edges to connect all the nodes. Find the minimum cost to add new edges between the nodes such that all the nodes are accessible from each other.

Input:

n, an int representing the total number of nodes.
edges, a list of integer pair representing the nodes already connected by an edge.
newEdges, a list where each element is a triplet representing the pair of nodes between which an edge can be added and the cost of addition, respectively (e.g. [1, 2, 5] means to add an edge between node 1 and 2, the cost would be 5).
Example 1:

Input: n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
Output: 7
Explanation:
There are 3 connected components [1, 4, 5], [2, 3] and [6].
We can connect these components into a single component by connecting node 1 to node 2 and node 1 to node 6 at a minimum cost of 5 + 2 = 7.

```java


// Union Find
public class Main {
    int[] parent;
    int N;
    
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            parent[px] = py;
            N--;
        }
    }
    
    public int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
    
    public int minCosttoConnectAllNodes(int n, int edges[][], int newEdges[][]){
        
        // use int[] to store original parents
        N = n; // N decrement when new nodes connected
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
        
        // union old edges and update their parent, decrement the n--
        for (int[] e : edges) union(e[0], e[1]);
        
        // sort the newEdges by the cost
        Arrays.sort(newEdges, (a, b) -> (a[2] - b[2]));
        
        int res = 0;
        // starting from lowest cost, union the nodes, until n==1, return the cost
        for (int[] e : newEdges) {
            if (N == 1) break;
            int x = e[0];
            int y = e[1];
            int cost = e[2]; 
            if(find(x) != find(y)) {
                union(x, y);
                res += cost;
            }
        }
        return N == 1 ? res : -1;  
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] n_tests = {6};
        int[][][] edges_tests = { {{1, 4}, {4, 5}, {2, 3}}};
        int[][][] newEdges_tests = { {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}}};
        for(int i = 0; i < n_tests.length; ++i){
            System.out.println(main.minCosttoConnectAllNodes(n_tests[i], edges_tests[i],
                                                    newEdges_tests[i]));
        }
    }
}
```