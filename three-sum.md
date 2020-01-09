```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = nums.length - 1, sum = - nums[i];
            int min = nums[lo] + nums[lo + 1], max = nums[hi] + nums[hi - 1];
            if (sum < min || sum > max) continue;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo + 1] == nums[lo]) lo++;
                    while (lo < hi && nums[hi - 1] == nums[hi]) hi--;
                    lo++;hi--;
                } else if (nums[lo] + nums[hi] < sum) lo++;
                else hi--;
            }
        }
        return res;
    }
}
```