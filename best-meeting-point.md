```java
class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);

        return minDistance(rows) + minDistance(cols);
    }
    
    public List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1)
                    rows.add(row);
            }
        }
        return rows;
    }
    public List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1)
                    cols.add(col);
            }
        }
        return cols;
    }
    public int minDistance(List<Integer> points) {
        int i = 0; 
        int j = points.size() - 1;
        int distance = 0;
        while (i < j) {
            distance += points.get(j--) - points.get(i++);
        }
        return distance;
    }
}
```