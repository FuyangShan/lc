```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        dfs(nums, new ArrayList<>(), res);
        return res;
    }
    public void dfs(int[] nums, List<Integer> sol, List<List<Integer>> res){
        if (sol.size() >= nums.length){
            res.add(new ArrayList<>(sol));
        } else {
            for (int i = 0; i < nums.length; i++){
                if (sol.contains(nums[i])) continue;
                sol.add(nums[i]);
                dfs(nums, sol, res);
                sol.remove(sol.size() - 1);
            }
        }
    }
}
```