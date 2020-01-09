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
    private int index(int[] nums, int target, boolean isFirst) {
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