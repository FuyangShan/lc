# [150] Evaluate Reverse Polish Notation
https://leetcode.com/problems/evaluate-reverse-polish-notation

问题：逆波兰表达式求值。

思路：只需要定义一个stack，如果是+, -, *, /四个运算符，就取出栈顶的两个数，进行相应操作，之后将计算得到的结果压入栈中；如果是数字，就直接入栈。最终stack只剩下一个元素，这个元素就是逆波兰表达式的值。

例如给定：["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

遇到4：stack : 4
遇到13：stack : 4 13
遇到5：stack : 4 13 5
遇到/号：pop : b=5, a=13 -> stack : 4 -> 13/5=2, push 2 to stack -> stack : 4 2
遇到+号：pop : b=2, a=4 -> stack : null -> 4+2=6, push 6 to stack -> stack : 6
pop剩下的一个元素6，得到计算结果为6

```java
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String s : tokens) {
        if (s.equals("+")) {
            stack.push(stack.pop() + stack.pop());
        } else if (s.equals("-")) {
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a - b);
        } else if (s.equals("*")) {
            stack.push(stack.pop() * stack.pop());
        } else if (s.equals("/")) {
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a / b);
        } else {
            stack.push(Integer.parseInt(s));
        }
    }
    return stack.pop();
}
```