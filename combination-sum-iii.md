```java
// DFS Backtrack
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || n < k) return res;
        DFS(res, new ArrayList<>(), n, k, 1);
        return res;
    }
    private void DFS(List<List<Integer>> res, List<Integer> sol, int target, int k, int start) {
        if (target == 0 && sol.size() ==  k) {
            res.add(new ArrayList<>(sol));
        } else if (sol.size() > k || (start < 10 && target - start < 0)) {
            return;
        } else {
            for (int i = start; i <= 9 && i <= target ; i++) {
                sol.add(i);
                DFS(res, sol, target - i, k, i + 1);
                sol.remove(sol.size() - 1);
            }
        }
    }
}
```