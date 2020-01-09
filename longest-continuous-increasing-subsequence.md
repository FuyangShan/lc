# Longest Continuous Increasing Subsequence
- Given an unsorted array of integers, 

### Q: find the length of longest continuous increasing subsequence (subarray).

>Example 1:
>Input: [1,3,5,4,7]
>Output: 3
>Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
>Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 

>Example 2:
>Input: [2,2,2,2,2]
>Output: 1
>Explanation: The longest continuous increasing subsequence is [2], its length is 1. 

```java

// DP
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // f[i] = longest continuous increasing subsequence from 0 to i
        int[] f = new int[n];
        int result = 1;
        // init
        f[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // init
            f[i] = 1;
            // corner condition
            if (nums[i] > nums[i - 1]) {
                // f[i] = {f[i-1] + 1 | nums[i]>nums[i-1]}
                f[i] = f[i - 1] + 1;
            } 
            result = Math.max(result, f[i]);
        }
        return result;
    }
}

// DP in-place
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i - 1]) {
                len++;
            } else {
                len = 1;
            }
            // update the max len so far
            result = Math.max(len, result);
        }
        return result;
    }
}
```