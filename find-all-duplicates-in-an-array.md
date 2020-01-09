# Find All Duplicates in an Array

- Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

- Find all the elements that appear twice in this array.

- Could you do it without extra space and in O(n) runtime?

> Example:
> Input:
> [4,3,2,7,8,2,3,1]

> Output:
> [2,3]

```java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        for (int i = 0; i < nums.length; i++) {
			// get the value of current bucket
            int val = nums[i] < 0 ? -nums[i] : nums[i];
			// if positive, update bucket
            if (nums[val - 1] < 0) res.add(val);
			// if negative, found dup
            else nums[val - 1] = -nums[val - 1];   
        }
        
        return res;
    }
}
```
