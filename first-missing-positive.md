# First Missing Positive
- Given an unsorted integer array
### Q: find the smallest missing positive integer.

> Example 1:

> Input: [1,2,0]
> Output: 3
> Example 2:

> Input: [3,4,-1,1]
> Output: 2

> Example 3:

> Input: [7,8,9,11,12]
> Output: 1
```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //Base case
        int one = 0;
        for (int i : nums) {
            if (i == 1) {
                one++;
                break;
            }
        }
        //if there is no "1"
        if (one == 0) return 1;
        
        //nums = [1];
        if (len == 1) return 2;
        
        //replace all negatives, zeros, larger than len's into "1"
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) nums[i] = 1;
        }
        
        for (int i = 0; i < len; i++) {
            int a = Math.abs(nums[i]);
            
            if (a == len) {
                nums[0] = - Math.abs(nums[0]);
            } else {
                nums[a] = - Math.abs(nums[a]);
            }
        }
        
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) return i;
        }
        
        if (nums[0] > 0) return len;
        
        return len + 1;
        
    }
}
```
