```java
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 3) return res;
        addToList(res, new ArrayList<>(), n, 2);
        return res;
    }
    public void addToList(List<List<Integer>> res, List<Integer> sol, int n, int start) {
        if (n < start) return; // end of division
        if (sol.size() > 0) {
            sol.add(n);
            res.add(new ArrayList<>(sol));
            sol.remove(sol.size() - 1);
        }
        for (int i = start; i <= n / 2; i++) {
            if (n % i == 0) {
                sol.add(i);
                addToList(res, sol, n / i, i);
                sol.remove(sol.size() - 1);
            }
        }
    }
}
```