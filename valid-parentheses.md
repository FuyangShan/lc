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