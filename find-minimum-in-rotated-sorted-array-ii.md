```java
//1st Method 与nums[hi]比较，由于pivot有可能是在数组最后

class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi])
                hi = mid;
            else if (nums[mid] > nums[hi])
                lo = mid;
            else // nums[mid] == nums[hi])
                hi--;
        }
        return nums[lo] < nums[hi] ? nums[lo] : nums[hi];
    }
}

//2nd Method 排除掉数组依次递增的可能性

class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo + 1 < hi && nums[lo] >= nums[hi]) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[lo])
                hi = mid;
            else if (nums[mid] > nums[lo])
                lo = mid;
            else // nums[mid] == nums[lo])
                lo++;
        }
        return nums[lo] < nums[hi] ? nums[lo] : nums[hi];
    }
}
```