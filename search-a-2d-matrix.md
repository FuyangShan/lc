```java
//将二维数组展开成一维然后二分搜索

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, mid = 0, hi = m * n - 1;
        int x = 0, y = 0;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            x = mid / n;
            y = mid % n;
            if (matrix[x][y] < target) lo = mid;
            else hi = mid;
        }

        if (matrix[lo / n][lo % n] == target || matrix[hi / n][hi % n] == target) return true;
        return false;
    }
}
```