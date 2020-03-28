# [71] Simplify Path
https://leetcode.com/problems/simplify-path

问题：解析linux路径，有”.”表示不变和”..”表示回上层。

思路：

```java
public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] paths = path.split("/+");
    for (String s : paths) {
        if (s.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else if (!s.equals(".") && !s.equals("")) {
            stack.push(s);
        }
    }
    String res = "";
    while (!stack.isEmpty()) {
        res = "/" + stack.pop() + res;
    }
    if (res.length() == 0) return "/";
    return res;
}
```

