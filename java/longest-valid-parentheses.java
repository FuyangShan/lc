class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                count += 2;
            } else if (!stack.isEmpty() && stack.peek() == ')') {
                count = 0;
            } else {
                stack.push(c);
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

// 