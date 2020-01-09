```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(res, new ArrayList<Integer>(), nums, visited);
        return res;

    }
    public void dfs(List<List<Integer>> res, List<Integer> sol, int[] nums, boolean[] visited){
        if (sol.size() >= nums.length){
            res.add(new ArrayList<>(sol));
        } else {
            for (int i = 0; i < nums.length; i++){
                if (visited[i]) continue;
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                sol.add(nums[i]);
                dfs(res, sol, nums, visited);
                sol.remove(sol.size() - 1);
                visited[i] = false;
            }
        }
    }
}
```