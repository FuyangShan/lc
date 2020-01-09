# Backpack I
- Given **n** items with size **Ai**, 
- Integer **m** denotes the size of a backpack. 
### How full you can fill this backpack?

>Example 1:
>Input:  [3,4,8,5], backpack size=10
>Output:  9

>Example 2:
>Input:  [2,3,5,7], backpack size=12
>Output:  12

```java
// DP
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int n = A.length;
        if (n == 0) return 0;
        // f[i][j] = if we can make a less-than "weight j" pack with "first i" items 
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        
        for (int i = 1; i <= m; i++) {
            f[0][i] = false;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // case 1, can(not) make a weight j pack with previous i-1 items 
                f[i][j] = f[i - 1][j];
                // if target weight is bigger than current item
                // case 2, can(not) make a weight j pack with previous i-1 items AND the current item
                if (j >= A[i - 1]) {
                    f[i][j] = f[i][j] || f[i - 1][j - A[i - 1]];
                }
            }
        }
        // find the largest weight of possible pack
        for (int i = m; i >= 0; i--) {
            if (f[n][i]) return i;
        }
        
        return 0;
    }
}
```
