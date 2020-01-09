class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int lo = j + 1, hi = nums.length - 1, twoSum = target - nums[i] - nums[j];
                int min = nums[lo] + nums[lo + 1], max = nums[hi] + nums[hi - 1];
                if (twoSum < min || twoSum > max) continue;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == twoSum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < twoSum) lo++;
                    else hi--;
                }
            }
        }
        
        return res;
    }
}