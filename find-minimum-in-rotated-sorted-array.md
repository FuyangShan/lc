```java
//找到pivot即可

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, mid = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[nums.length - 1]) lo = mid;
            else hi = mid;
        }
        return nums[lo] < nums[hi] ? nums[lo] : nums[hi];
    }
}
```