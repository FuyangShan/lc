class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> res = new HashSet<>();
        int left = 0,  right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        addToRes(res, s, 0, new StringBuilder(), left, right, 0);
        return new ArrayList<String>(res);
    }
    public void addToRes(HashSet<String> res, // result set
                         String s, 
                         int i, // recusion level
                         StringBuilder sb, // build up sb
                         int left,  // left boundary
                         int right,  // right boundary
                         int open) { // make sure sb is valid
        if (left < 0 || right < 0 || open < 0) return;
        if (i == s.length()) {
            if (left == 0 && right == 0 && open == 0) 
                res.add(sb.toString());
            return;
        }
        char c = s.charAt(i);
        int len = sb.length();
        if (c == '(') {
            addToRes(res, s, i + 1, sb, left - 1, right, open);
            addToRes(res, s, i + 1, sb.append(c), left, right, open + 1);
        } else if (c == ')') {
            addToRes(res, s, i + 1, sb, left, right - 1, open);
            addToRes(res, s, i + 1, sb.append(c), left, right, open - 1);
        } else {
            addToRes(res, s, i + 1, sb.append(c), left, right, open);
        }
        sb.setLength(len);
    }
}