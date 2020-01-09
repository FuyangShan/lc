```java
// S1: DFS Backstrack
class Solution {
    HashMap<Character, char[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v' });
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        dfs(digits, res, new StringBuilder(), digits.length());
        return res;
    }

    public void dfs(String digits, List<String> res, StringBuilder sb, int len) {
        if (sb.length() == len) {
            res.add(sb.toString());
        } else {
            for (int i = 1; i <= digits.length(); i++) {
                for (char c : map.get(digits.charAt(i - 1))) {
                    sb.append(c);
                    dfs(digits.substring(i), res, sb, len);
                    sb.setLength(sb.length() - 1);
                }
            }
        }
    }
}

// S2
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return ans;
        char[][] map = new char[8][];
        map[0] = "abc".toCharArray();
        map[1] = "def".toCharArray();
        map[2] = "ghi".toCharArray();
        map[3] = "jkl".toCharArray();
        map[4] = "mno".toCharArray();
        map[5] = "pqrs".toCharArray();
        map[6] = "tuv".toCharArray();
        map[7] = "wxyz".toCharArray();
        char[] input = digits.toCharArray();
        ans.add("");
        for (char c : input)
            ans = expand(ans, map[c - '2']);
        return ans;
    }

    private List<String> expand(List<String> l, char[] arr) {
        List<String> next = new ArrayList<String>();
        for (String s : l)
            for (char c : arr)
                next.add(s + c);
        return next;
    }
}
```
