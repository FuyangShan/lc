# Backpack III
- Given N items, Weight from **A0, A1, A2, ..., An-1**, 
- Value from **V0, V1, V2...., Vn-1**,
- And a backpack size **M**
> note: each item can be picked multiple times
### Q: The max Value can be packed?
> Example:
> input: int[] A = {2, 3, 5, 7} and int[] V = {1, 5, 2, 4} and target = 10
> output: 15 (3 * 3 < 10, 3 * 5 = 15)

```java

// DP
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int target, int[] A, int[] V) {
        int n = A.length;
        if (n == 0) return 0;

        int[] f = new int[target + 1];
        f[0] = 0;
        for (i = 1; i <= target; i++) {
            f[i] = -1;
        }

        for (int i = 1; i <= n; i++) {
            // f[0], f[1]... f[n]

            for (int j = 0; j <= target; j++) {
                // f[i][w] = max{f[i - 1][w-k*Ai-1] + k*Vi-1}
                // compress -> 
                // f[i][w] = max{f[i - 1][w], f[i][w-Ai-1] + Vi-1 }
                // compress ->
                // original f[j]: slide f[i-1][j]
                // updated f'[j]: slide f[i][j]
                if (j >= A[i - 1] && f[j - A[i - 1]] != -1) {
                    f[j] = Math.max(f[j], f[j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= target; i++) {
            if (f[i] != -1) {
                res = Math.max(res, f[i]);
            }
        }

        return res;
    }
}
```
