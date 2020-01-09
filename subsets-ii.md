```java
// DFS Backtrack
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        DFS(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void DFS(List<List<Integer>> res, List<Integer> sol, int[] nums, int start) {
        res.add(new ArrayList<>(sol));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            sol.add(nums[i]);
            DFS(res, sol, nums, i + 1);
            sol.remove(sol.size() - 1);
        }
    }
}
```