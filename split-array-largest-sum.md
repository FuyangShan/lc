# Split Array Largest Sum
- Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

- Note:
- If n is the length of array, assume the following constraints are satisfied:

- 1 ≤ n ≤ 1000
- 1 ≤ m ≤ min(50, n)

> Examples:

> Input:
> nums = [7,2,5,10,8]
> m = 2

> Output:
> 18

> Explanation:
> There are four ways to split nums into two subarrays.
> The best way is to split it into [7,2,5] and [10,8],
> where the largest sum among the two subarrays is only 18.

```java
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        // f[i][j] = minimal largest sum of spliting first i elements in array into j subs
        int[][] f = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        // store prefix sum array to cache sum of subarray
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // enumerate the last split from 0 ~ i-1, cut after nums[0] .... nums[i-1]
                for (int k = 0; k < i; k++) {
                    // f[i][j] = Min{Max{f[k][j-1], sum(k+1...i)}}
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];        
    }
}
```
