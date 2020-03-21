# Backpack IV
- Given N postive integer : **A0, A1, ..., An-1**
- and a positive integer **target**
- **note**: each Ai can be used multiple times
### Q: How many combinations sums up to target?

>Input: nums = [1, 2, 4], and target = 4
>Output: 6
>Explanation:
>The possible combination ways are:
>[1, 1, 1, 1]
>[1, 1, 2]
>[1, 2, 1]
>[2, 1, 1]
>[2, 2]
>[4]

* [see: combinations sum IV](combination-sum-iv.md)

```java

// DP
class Solution {
    public int backpack(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
```
