```java
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) return res;
        for (int i = 1; i <= 9 && i <= n; i++) {
            DFS(res, i, n);
        }
        return res;
    }
    private void DFS(List<Integer> res, int sol, int n) {
        res.add(sol);
        for (int i = 0; i <= 9; i++) {
            sol = sol * 10 + i;
            if (sol <= n) DFS(res, sol, n);
            sol = (sol - i) / 10;
        }
    }
}
```