# Maximum Subarray
>Input: [-2,1,-3,4,-1,2,1,-5,4],
>Output: 6
>Explanation: [4,-1,2,1] has the largest sum = 6.

```java

// DP in place
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }
}
```