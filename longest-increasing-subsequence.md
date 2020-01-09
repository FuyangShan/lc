# Longest Increasing Subsequence
- Given an unsorted array of integers
### Q: find the length of longest increasing subsequence.

> Example:

> Input: [10,9,2,5,3,7,101,18]
> Output: 4 
> Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
> Note:

> There may be more than one LIS combination, it is only necessary for you to return the length.
> Your algorithm should run in O(n2) complexity.

```java

// DP
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // f[i] = how many elements are less than nums[i], including nums[i];
        int[] f = new int[nums.length];
        // init
        f[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            // init
            f[i] = 1;
            // enumerating from 0 to i-1
            for (int j = 0; j < i; j++) {
                // corner condition
                if (nums[j] < nums[i]) 
                    // f[i] = Max {f[j] + 1}
                    f[i] = Math.max(f[i], f[j] + 1);
            }
            result = Math.max(result, f[i]);
        }
        return result;
    }
}

//DP + binary search
class Solution {
    public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;
		
		// implictly: f[s] = length of longest increasing sequence for nums[0,...s-1]
		// b[i] = when "f" value is "i", smallest "nums" value
		int[] b = new int[n + 1];
		
		// init
		b[0] = Integer.MIN_VALUE;

		// set boundary to binary search
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			// within b[0] ~ b[max], binary search
			// find the last value which is smaller than nums[i]
			int lo = 0, hi = max, mid;
			int j;
			while (lo <= hi) {
				mid = lo + (hi - lo) / 2;
				if (b[mid] < nums[i]) {
					j = mid;
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			// found the position to place smallest nums[i]
			b[j + 1] = nums[i];

			// update boundary
			if (j + 1 > max) {
				max = j + 1;
			}
		}
        return max;
    }
}
```
