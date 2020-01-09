# Remove Duplicates from Sorted Array II
- Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

- Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

> Example 1:

> Given nums = [1,1,1,2,2,3],

> Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

> It doesn't matter what you leave beyond the returned length.
> Example 2:

> Given nums = [0,0,1,1,1,1,2,3,3],

> Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

> It doesn't matter what values are set beyond the returned length.

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) return nums.length;
        
        int slow = 1;
        
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1])
				nums[++slow] = nums[fast];
        }
        
        return slow + 1;
    }
}
```
