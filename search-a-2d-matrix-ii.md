```java
//Binary Search 递归搜索，初始边界是左上角和右下角，每次在可选的边界内搜索。

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0||matrix[0].length == 0) return false;
        return helper(0, 0, matrix.length - 1, matrix[0].length - 1, matrix, target);
    }
    private boolean helper(int x1, int y1, int x2, int y2, int[][] matrix, int target) {
        if (x2 < x1 || y2 < y1 || x1 >= matrix.length || y1 >= matrix[0].length || x2 < 0|| y2 < 0) 
            return false;
        int mx = x1 + (x2 - x1) / 2;
        int my = y1 + (y2 - y1) / 2;
        if (matrix[mx][my] == target) {
            return true;
        } else if (matrix[mx][my] < target) {
            return helper(mx + 1, y1, x2, y2, matrix, target) || helper(x1, my + 1, x2, y2, matrix, target);
        } else if (matrix[mx][my] > target) {
            return helper(x1, y1, mx - 1, y2, matrix, target) || helper(x1, y1, x2, my - 1, matrix, target);
        } else {
            return false;
        }
    }
}

//O(m+n)

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
```