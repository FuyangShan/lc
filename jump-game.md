# Jump Game
>Input: [2,3,1,1,4]
>Output: true
>Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

```java

// DP
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        // f[i] = if can jump to nums[i]
        boolean[] f = new boolean[n];
        // init (you are initially at the nums[0])
        f[0] = true;
        
        for (int i = 1; i < n; i++) {
            // enumerate from 0 to i-1
            for (int j = 0; j < i; j++) {
                // f[i] = {f[j] && nums[j] >= i - j}
                if (f[j] && nums[j] >= i - j) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n - 1];
    }
}

// DP in-place
class Solution {
    public boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length == 1) return true;
        if (nums[0] == 0) return false;
        int max = nums[0];
        for (int i = 1; i < nums.length - 1; i++){
            max = Math.max(max - 1, nums[i]);
            if (max == 0) return false;
        }
        return true;
    }
}
```