# Perfect Squares
- Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

>Example 1:
>Input: n = 12
>Output: 3 
>Explanation: 12 = 4 + 4 + 4.

>Example 2:
>Input: n = 13
>Output: 2
>Explanation: 13 = 4 + 9.

```java

// DP
class Solution {
    public int numSquares(int n) {
        // f[i] = least number of perfect sqaure numbers sums to i
        int[] f = new int[n + 1];
        // init
        f[0] = 0;
        // get f[i] in order from 1, 2, 3... n
        for (int i = 1; i <= n; i++) {
            // init
            f[i] = Integer.MAX_VALUE;
            // enumerate j from 1 to i^1/2
            for (int j = 1; j * j <= i; j++) {
                // f[i] = Min{f[i - j*j]+1}
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }
}
```