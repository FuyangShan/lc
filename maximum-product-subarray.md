# Maximum Product Subarray
>Input: [2,3,-2,4]
>Output: 6
>Explanation: [2,3] has the largest product 6.

```java

// DP
class Solution {
    public int maxProduct(int[] nums) {
        int imax = 1, imin = 1, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0) {int temp = imax; imax = imin; imin = temp;};
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            max = Math.max(imax, max);
        }
        return max;
    }
}
```