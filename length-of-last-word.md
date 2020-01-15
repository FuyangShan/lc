# Length of Last Word
- Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

- If the last word does not exist, return 0.

- Note: A word is defined as a maximal substring consisting of non-space characters only.

> Example:
> 
> Input: "Hello World"
> Output: 5

```java
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        // remove tailing " "
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') len--;
            else break;
        }
        String newString = s.substring(0, len);
        
        for (int i = newString.length() - 1; i >= 0; i--) {
            if (newString.charAt(i) == ' ') return newString.length() - 1 - i;
        }
        
        return newString.length();
    }
}
```
