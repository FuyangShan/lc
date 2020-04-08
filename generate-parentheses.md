```java
// DFS Backtrack
/*
    for each step, we can choose either generate a ( or a )
    so we can keep generating until either :
        1. we got a invalid result
        2. we got a valid result with 2n length solution, add to result
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int l = 0, r = 0;
        generate(n, l, r, new StringBuilder(), res);
        return res;
    }
    public void generate(int n, int l, int r, StringBuilder sb, List<String> res) {
        if (l < r || l > n) return;
        if (l + r == n * 2) {
            res.add(sb.toString());
            return;
        } 
        sb.append("(");
        generate(n, l + 1, r, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        generate(n, l, r + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}
```