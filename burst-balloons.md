# Burst Ballons
- Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
- You are asked to burst all the balloons. 
- If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
- Here left and right are adjacent indices of i. 
- After the burst, the left and right then becomes adjacent.

### Q : Find the maximum coins you can collect by bursting the balloons wisely.

- Note:
    You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
    0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

>Example:
>Input: [3,1,5,8]
>Output: 167 
>Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
>             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

```java

// DP
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        
        int[] A = new int[n + 2];
        A[0] = A[n + 1] = 1;
        // A[0] = 1, A[1], A[2], ... A[n], A[n + 1] = 1
        for (int i = 1; i <= n; i++) {
            A[i] = nums[i - 1];
        }
        
        // f[i][j] = maxCoins of burst ballons between i, j (i, j are not real)
        int[][] f = new int[n + 2][n + 2];

        // init, nothing gained between i and i+1
        for (int i = 0; i < n + 1; i++) {
            f[i][i + 1] = 0;
        }
        
        // iterate from len = 3 to len = n + 2
        for (int len = 3; len <= n + 2; len++) {
            // ------ len -------
            // n+2-len ------ n+1
            //    i    ------  j
            for (int i = 0; i <= n - len + 2; i++) {
                int j = i + len - 1;
                f[i][j] = 0;
                // enumerate "last" burst position from i+1 to j-1
                for  (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }
        
        return f[0][n + 1];
    }
}
```
