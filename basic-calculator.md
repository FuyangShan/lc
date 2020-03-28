# [224] Basic Calculator
https://leetcode.com/problems/basic-calculator

问题：

思路：题目中只有+ - ( )。遍历字符串，对于每个字符c：

如果是数字，则一直遍历到非数字字符，把数字找出，并与结果相加
如果是+``-符号，将符号位sign设置成对应的值
如果是(，将res和sign压入栈中，重置res和sign
如果是)，将sign和res弹出栈，并计算结果
例如给定：1 + 3 - (2 - 3)

遇到1：sign=1 -> res=0+1*1=1
遇到+：sign=1
遇到3：sign=1 -> res=1+3*1=4
遇到-：sign=-1
遇到(：push res(4), push sign(-1), res=0, sign=1 -> stack : 4 -1
遇到2：sign=1 -> res=0+2*1=2
遇到-：2-3相当于2+(-3) -> sign=-1
遇到3：sign=-1 -> res=2+3*(-1)=-1
遇到)：res=-1*stack.pop()+stack.pop()=-1*(-1)+4=5

```java
public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int sign = 1;
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
        if (Character.isDigit(s.charAt(i))) {
            int num = s.charAt(i) - '0';
            // 如果下一个还是数字，就继续计算
            while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                int next = s.charAt(i + 1) - '0';
                num = num * 10 + next;
                i++;
            }
            res += num * sign;
        } else if (s.charAt(i) == '+') {
            sign = 1;
        } else if (s.charAt(i) == '-') {
            sign = -1;
        } else if (s.charAt(i) == '(') {
            stack.push(res);
            stack.push(sign);
            res = 0;
            sign = 1;
        } else if (s.charAt(i) == ')') {
            res = res * stack.pop() + stack.pop();
        }
    }
    return res;
}
```