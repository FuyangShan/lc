# Maximum Size Subarray Sum Equals k

- Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

- Note:
- The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

> Example 1:

> Input: nums = [1, -1, 5, -2, 3], k = 3
> Output: 4
> Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
> Example 2:

> Input: nums = [-2, -1, 2, 1], k = 1
> Output: 2
> Explanation: The subarray [-1, 2] sums to 1 and is the longest.

```java
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        //make a Prefix sum array
        //sum[0] = 0; sum[1] = sum[0] + num[0]....
        int[] sum = new int[nums.length + 1];
        //and store <sum, index> in hashmap for quick access
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            map.put(sum[i + 1], i + 1);
        }
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer len = map.get(sum[i] + k);
            if (len != null && len - i > longest) {
                //the longest you can get is nums.length or nums.length - 1, once you get either one, it couldn't get any longer.
                if (len >= nums.length - 1) {
                    return len - i;
                } else {
                    longest = len - i;
                }
            }
        }
        return longest;
    }
}
```
