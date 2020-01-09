```java
//1st method 将nums[mid]与nums[hi]作比较，来确定mid在左边还是右边

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                if (nums[mid] > target && target > nums[hi]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        if (nums[lo] == target) return lo;
        else if (nums[hi] == target) return hi;
        else return -1;
    }
}
```