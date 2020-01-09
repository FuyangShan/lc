# Two Sum
- Given an array of integers, return indices of the two numbers such that they add up to a specific target.

- You may assume that each input would have exactly one solution, and you may not use the same element twice.

> Example:

> Given nums = [2, 7, 11, 15], target = 9,

> Because nums[0] + nums[1] = 2 + 7 = 9,

```java
return [0, 1].class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //<Value, Index>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //traversal array, put in <value, index> if no pair found;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else { //found pair
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        
        return new int[] {-1, -1};
    }
}
```
