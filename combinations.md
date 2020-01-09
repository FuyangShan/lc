```java
//S1 : DFS Backtrack
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0) return res;
        dfs(res, new ArrayList<Integer>(), 1, k, n);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> sol, int start, int k, int n){
        if (sol.size() ==  k) res.add(new ArrayList<>(sol));
        else {
            for (int i = start; i < n + 1; i++){
                sol.add(i);
                dfs(res, sol, i + 1, k, n);
                sol.remove(sol.size() - 1);
            }
        }
    }
}

//S2 : ??
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < k + 1; i++){
            nums.add(i);
        }
        nums.add(n + 1);
        int j = 0;
        while (j < k){
            res.add(new ArrayList<>(nums.subList(0, k)));
            j = 0;
            while (j < k && nums.get(j + 1) == nums.get(j) + 1){
                nums.set(j, j++ + 1);
            }
            nums.set(j, nums.get(j) + 1);
        }
        return res;
    }
}
```
