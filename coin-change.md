# Coint Change
- You are given coins of different denominations and a total amount of money amount. 
- Write a function to compute the fewest number of coins that you need to make up that amount. 
- If that amount of money cannot be made up by any combination of the coins, return -1.
>Note:
>You may assume that you have an infinite number of each kind of coin.

>Example 1:
>Input: coins = [1, 2, 5], amount = 11
>Output: 3 
>Explanation: 11 = 5 + 5 + 1

>Example 2:
>Input: coins = [2], amount = 3
>Output: -1

```java
// DP
class Solution {
    public int coinChange(int[] coins, int amount) {
        // f[i] = minimum coins to make money i
        int[] f = new int[amount + 1];
        int len = coins.length;
        // init
        f[0] = 0;
        
        // 1....amount
        for (int i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE; 
            for (int j = 0; j < len; j++) {
                // corner condition
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) { 
                    // f[i] = min{f[i - coins[j]] + 1};
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1); 
                }
            }
        }
        
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }
}
```