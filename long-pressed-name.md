# 925. Long Pressed Name

Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

 

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.

```java
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (char c: name.toCharArray()) {
            if (j == typed.length())
                return false;

            // If mismatch...
            if (typed.charAt(j) != c) {
                // If it's the first char of the block, ans is false.
                if (j==0 || typed.charAt(j-1) != typed.charAt(j))
                    return false;

                // Discard all similar chars
                char cur = typed.charAt(j);
                while (j < typed.length() && typed.charAt(j) == cur)
                    j++;

                // If next isn't a match, ans is false.
                if (j == typed.length() || typed.charAt(j) != c)
                    return false;
            }

            j++;
        }

        return true;
    }
}
```

```java
// to examine if name is long pressed / exact of typed, we can check starting the last character
// if the last character is not same, then it's not matched
// if the last character is same, then we need check two possibilities
// 1. if the name(0, len) match typed(0, len - 1)
// 2. if the name(0, len - 1) match typed(0, len - 1)
// if either of cases is true, then we can say name is matching with typed
// recusively, in the case 2, we need to know:
// 3. if the name(0, len - 1) match typed(0, len - 2), OR
// 4. if the name(0, len - 2) match typed(0, len - 2)
// ...
// we can memorize the match records in boolean array so we can look them // up when we need them
// match[i][j] = if name(0, i) matches typed(0, j);
// match[0][0] = "" match "", always true

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length();
        int n = typed.length();
        
        if (m > n) return false;
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (name.charAt(i - 1) != typed.charAt(j - 1)) {
                    match[i][j] = false;
                    continue;
                }
                match[i][j] = match[i - 1][j - 1] || match[i][j - 1];
            }
        }
        
        return match[m][n];
    }
}
```


