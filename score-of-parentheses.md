# Score of Parentheses
Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6


```java
class Solution {
    public int scoreOfParentheses(String S) {
        if (S == null || S.equals("")) return 0;
        int times = 0;
        int sum = 0;
        boolean open = true;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (times == 0) times++;
                else times *= 2;
                open = true;
            } else if (open){
                sum += times;
                open = false;
                if (times == 1) times--;
                else times /= 2;
            } else {
                if (times == 1) times--;
                times /= 2;
            }
        }
        return sum;
    }
}
```