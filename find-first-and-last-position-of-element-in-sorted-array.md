# 34. Find First and Last Position of Element in Sorted Array 
```java
//1st Method 先找左下标，再找右下标，注意判断退出条件lo + 1 == hi时，lo和hi都有可能是target；
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
           	return new int[] {-1,-1};
        }
        int left = leftIndex(nums,target);
        int right = rightIndex(nums,target);
        return new int[]{left, right};
    }
    private int leftIndex(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                    lo = mid;
            } else {
                    hi = mid;
            }
        }
        if (nums[lo] == target) return lo;
        else if (nums[hi] == target) return hi;
        else return -1;
    }
    private int rightIndex(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                    lo = mid;
            } else {
                    hi = mid;
            }
        }
        if (nums[hi] == target) return hi;
        else if (nums[lo] == target) return lo;
        else return -1;
    }
}

//2nd Method 合并最左和最右两个方法
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a = -1, b = -1;
        int left = index(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return new int[] {a,b};
        }
        int right = index(nums, target, false);
        if (nums[left] == target) {
            a = left;
            b = right - 1;
        }
        return new int[] {a, b};
    }
    private int index(int[] nums, int target, isFirst) {
        int lo = 0, hi = nums.length;
        int mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target || (nums[mid] == target && !isFirst)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
```