class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) return nums.length;
        
        int slow = 1;
        
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) nums[++slow] = nums[fast];
        }
        
        return slow + 1;
    }
}
