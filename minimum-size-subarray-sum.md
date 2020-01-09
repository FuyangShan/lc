# Minimum Size Subarray Sum
- Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

> Example: 

> Input: s = 7, nums = [2,3,1,2,4,3]
> Output: 2
> Explanation: the subarray [4,3] has the minimal length under the problem constraint.

```java

//Sliding window, Two Pointers
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        //check sum from nums[left], if sum[left, i] >= s, no need to increase i
        //then move left++, and check if new sum[left, i] >= s, if not, increas i
        //update min during the moving
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i + 1 - left);
                sum -= nums[left++];
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

//Prefix sum, Binary Search
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) sums[i + 1] = sums[i] + nums[i];
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int lo = i + 1;
            int hi = n;
            int mid;
            
            while (lo + 1 < hi) {
                mid = lo + (hi - lo) / 2;
                if (sums[mid] - sums[i] >= s) hi = mid;
                else lo = mid;
            }
            if (sums[hi] - sums[i] >= s) min = Math.min(min, hi - i);
            if (sums[lo] - sums[i] >= s) min = Math.min(min, lo - i);
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
        
    }
}
```
