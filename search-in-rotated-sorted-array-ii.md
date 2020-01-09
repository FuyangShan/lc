```java
//将nums[mid] 与 nums[lo]比较，如果一样则说明有duplicate，则移动lo++

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[lo]) {
                    if (target >= nums[lo] && target <= nums[mid]) {
                            hi = mid;
                    } else {
                            lo = mid;
                    }
            } else if (nums[mid] < nums[lo]) {
                    if (target <= nums[hi] && target >= nums[mid]) {
                            lo = mid;
                    } else {
                            hi = mid;
                    }
            } else {
                    lo++;
            }
        }
        if (nums[lo] == target || nums[hi] == target) return true;
        else return false;
    }
}
```