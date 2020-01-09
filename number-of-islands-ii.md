```java
// Union Find
class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0|| n <= 0||positions == null || positions.length == 0) return res;
        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        for (int[] p : positions){
            int root = p[0] * n + p[1];
            roots[root] = root;
            count++;
            for (int[] dir : dirs){
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = x * n + y;
                if (x < 0 || x >= m || y < 0|| y >= n || roots[nb] ==  -1) continue;
                int rootNb = findIsland(roots, nb);
                if (root != rootNb){
                    roots[root] = rootNb;
                    root = rootNb;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    private int findIsland(int[] roots, int root){
        while (root != roots[root]){
            roots[root] = roots[roots[root]];
            root = roots[root];
        }
        return root;
    }
}
```