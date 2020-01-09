class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int current = nums[0];
        int previousIndex = 0;
        for (int i = 1; i < nums.length;i++){
            if (nums[i] != current){
                current =nums[i];
                nums[++previousIndex] = nums[i];
            }
        }
        return ++previousIndex;

    }
}