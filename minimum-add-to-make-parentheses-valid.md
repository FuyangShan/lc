# Minimum Add to Make Parentheses Valid
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

 

Example 1:

Input: "())"
Output: 1
Example 2:

Input: "((("
Output: 3
Example 3:

Input: "()"
Output: 0
Example 4:

Input: "()))(("
Output: 4

```java
class Solution {
    public int minAddToMakeValid(String S) {
        if (S.equals("")){
            return 0;
        }
        String[] sList = S.split("");
        Stack<String> stack = new Stack();
        int n = 0;
        for (int i = sList.length - 1; i >= 0; i--){
            if (stack.isEmpty()){
                stack.push(sList[i]);
                n++;
            } else{
                if (stack.peek().equals(")") && sList[i].equals("(")){
                    stack.pop();
                    n--;
                }else {
                    stack.push(sList[i]);
                    n++;
                }
            }
        }
        return n;
    }
}
```