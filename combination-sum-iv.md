```java
// DFS
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        return DFS(new HashMap<Integer, Integer>(), nums, target);
    }
    private int DFS(HashMap<Integer, Integer> map, int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (map.containsKey(target)) return map.get(target);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += DFS(map, nums, target - nums[i]);
        }
        map.put(target, res);
        return res;
    }
}

// DP
class Solution {
    public int combinationSum4(int[] nums, int target) {
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