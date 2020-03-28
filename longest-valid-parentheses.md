# [32] Longest Valid Parentheses 最长合法的括号
https://leetcode.com/problems/longest-valid-parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"


```java
public int longestValidParentheses(String s) {
    // 存放每一个左括号的位置
    Stack<Integer> stack = new Stack<>();
    int res = 0;
    // 当前括号组合的最左侧边界
    int start = -1;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            stack.push(i);
        } else {
            // 当前括号组合为空
            if (stack.empty()) {
                start = i;
            } else {
                stack.pop();
                if (stack.empty()) {
                    res = Math.max(res, i - start);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
    }
    return res;
}
```