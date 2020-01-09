# Maximum Gap
- Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

- Return 0 if the array contains less than 2 elements.

> Example 1:

> Input: [3,6,9,1]
> Output: 3
> Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
> Example 2:

> Input: [10]
> Output: 0
> Explanation: The array contains less than 2 elements, therefore return 0.
> Note:

> You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
> Try to solve it in linear time/space.
```java
class Solution {
    public int maximumGap(int[] nums) {
        if (nums ==  null || nums.length < 2)  return 0;
        int min = nums[0], max = nums[0];
        for (int num : nums) { //get the min and max of array
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) return 0;
        
        int len = nums.length;
        int[] bucketMin = new int[len];
        int[] bucketMax = new int[len];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        //put N element in buckets, gap can't be smaller than (max - min) / (len - 1)
        int gap = (int)Math.ceil((double)(max - min) / (len - 1));
        // sort in new buckets
        for (int num : nums) {
            //bucket = {0 * gap, .... , (n - 1) * gap}, n elements in total
            int i = (num - min) / gap;
            bucketMin[i] = Math.min(num, bucketMin[i]);
            bucketMax[i] = Math.max(num, bucketMax[i]);
        }
        // traverse the buckets to find maximum gap
        for (int i = 0; i < len; i++) {
            if (bucketMin[i] != Integer.MAX_VALUE) {
                gap = Math.max(gap, bucketMin[i] - min);
                min = bucketMax[i];
            }
        }
        
        return gap;
    }
}
```
