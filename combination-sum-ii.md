```java
//S1 : DFS Backtrack
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        DFS(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    private void DFS(List<List<Integer>> res, List<Integer> sol, int[] c, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(sol));
        } else if (start >= c.length || target - c[start] < 0) {
            return;
        } else {
            for (int i = start; i < c.length; i++) {
                if (i > start && c[i] == c[i - 1]) continue;
                sol.add(c[i]);
                DFS(res, sol, c, target - c[i], i + 1);
                sol.remove(sol.size() - 1);
            }
        }
    }
}
```