# [20] Valid Parentheses 合法的括号
https://leetcode.com/problems/valid-parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

问题：给定一个字符串，判断括号匹配是否成立。

```java
// class Solution {
//     public boolean isValid(String s) {
//         HashMap<Character,Character> map = new HashMap<>();
//         map.put('(',')');
//         map.put('[',']');
//         map.put('{','}');
//         Stack<Character> stack = new Stack<>();
//         for (char c:s.toCharArray()){
//             if (c == '(' || c == '[' || c == '{') stack.push(map.get(c));
//             else if (stack.isEmpty() || stack.pop() != c) return false;
//         }    
//         return stack.isEmpty();
//     }
// }

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
```