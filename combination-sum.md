```java
//S1 : DFS Backtrack
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        DFS(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    private void DFS(List<List<Integer>> res, List<Integer> sol, int[] c, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(sol));
        } else if (target - c[start] < 0){
            return;
        } else {
            for (int i = start; i < c.length; i++) {
                sol.add(c[i]);
                DFS(res, sol, c, target - c[i], i);
                sol.remove(sol.size() - 1);
            }
        }
    }
}
```