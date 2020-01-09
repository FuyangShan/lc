```java
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        DFS(num, target, res, new StringBuilder(), 0, 0, 0);
        return res;
    }
    public void DFS(String num, int target, List<String> res, StringBuilder sb, int pos, long prev, long multi) {
        // exit when pos = length
        if (pos == num.length()) {
            if (prev == target) res.add(sb.toString());
            return;
        }
        // pos not reach end yet
        for (int i = pos; i < num.length(); i++) { // adding num.substring[pos, i + 1] to sb
            // consecutive number shouldn't start from "0"
            if (num.charAt(pos) == '0' && i != pos) break;
            
            long curr = Long.valueOf(num.substring(pos, i + 1));
            int len = sb.length();
            
            if (pos == 0) { // substring is first number
                DFS(num, target, res, sb.append(curr), i + 1, curr, curr);
                sb.setLength(len);
            } else {
                // prev "+" curr
                DFS(num, target, res, sb.append("+" + curr), i + 1, prev + curr, curr);
                sb.setLength(len);
                // prev "-" curr
                DFS(num, target, res, sb.append("-" + curr), i + 1, prev - curr, -curr);
                sb.setLength(len);
                // prev "*" curr
                DFS(num, target, res, sb.append("*" + curr), i + 1, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }
}
```