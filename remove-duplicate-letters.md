# [16] Remove Duplicate Letters
https://leetcode.com/problems/remove-duplicate-letters

问题：

思路：如果一个字母c，小于前面的某个字母b，并且b在a后面还有，那么b应当被删除。
用栈来实现。

遍历一遍统计每个字母出现次数。
再遍历一遍，对当前字母c的统计数字减一。
如果c不在栈中，则进行如下栈操作：
如果当前字母c小于栈顶，并且栈顶元素还有剩余，则出栈栈顶，并标记栈顶不在栈中。重复该操作直到栈顶元素不满足要求或者栈为空。
入栈字母c，并标记c已经在栈中。

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        // store the count of char
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // use stack to store the result;
        char[] stack = new char[s.length()];
        
        // store if c is in stack
        boolean[] inStack = new boolean[26];
        
        // use 'len' to mark the actual length of result
        int len = 0;
        
        // check each char
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            
            // if c is less than the stack top, and stack top has extra, then pop stack. 
            // repeating until the stack top not meeting the requirement. 
            // then add c to res, and mark c in stack
            if (!inStack[c - 'a']) {
                while ((len > 0 && c < stack[len - 1]) && count[stack[len - 1] - 'a'] > 0) {
                    inStack[stack[--len] - 'a'] = false;
                }
                
                stack[len++] = c;
                inStack[c - 'a'] = true;
            }
        }
        
        return new String(stack, 0, len);
    }
}

public String removeDuplicateLetters(String s) {
    if (s == null || s.length() == 0) return s;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);
    char[] res = new char[map.size()];
    int start = 0;
    int end = findMinLastPos(map);
    for (int i = 0; i < res.length; i++) {
        char minChar = 'z' + 1;
        for (int k = start; k <= end; k++) {
            if (map.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                minChar = s.charAt(k);
                start = k + 1;
            }
        }
        res[i] = minChar;
        map.remove(minChar);
        if (s.charAt(end) == minChar) {
            end = findMinLastPos(map);
        }
    }
    return new String(res);
}

private int findMinLastPos(Map<Character, Integer> map) {
    int res = Integer.MAX_VALUE;
    for (int num : map.values()) {
        res = Math.min(res, num);
    }
    return res;
}
```