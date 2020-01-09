```java
// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        boolean[] visited = new boolean[m * n];
        int[][] dirs = {
            {0, 1}, // right
            {1, 0}, // down
            {0, -1}, // left
            {-1, 0} // top
        };
        int step = 0;
        int x = 0, y = 0;
        int dir = 0;
        while (step < m * n){
            res.add(matrix[x][y]);
            step++;
            visited[x * n + y] = true;
            int newX = x + dirs[dir % 4][0];
            int newY = y + dirs[dir % 4][1];
            if (newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX * n + newY]){
                dir++;
                x += dirs[dir % 4][0];
                y += dirs[dir % 4][1];
                continue;
            }
            x += dirs[dir % 4][0];
            y += dirs[dir % 4][1];
        }
        return res;
    }
}
```