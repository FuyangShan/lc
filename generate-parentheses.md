```java
// DFS Backtrack
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        DFS(res, new StringBuilder(), n, 0, 0);
        return res;
    }
    private void DFS(List<String> res, StringBuilder sb, int n, int left, int right) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
        } else {
            if (left < n) {
                sb.append("(");
                DFS(res, sb, n, left + 1, right);
                sb.deleteCharAt(sb.length() - 1);
            } 
            if (left > right) {
                sb.append(")");
                DFS(res, sb, n, left, right + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
```