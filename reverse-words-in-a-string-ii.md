# Reverse Words in a String II
- Given an input string , reverse the string word by word. 

> Example:
> 
> Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
> Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
> Note: 
> 
> A word is defined as a sequence of non-space characters.
> The input string does not contain leading or trailing spaces.
> The words are always separated by a single space.
>
> Follow up: Could you do it in-place without allocating extra space?

```java
class Solution {
    public void reverseWords(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the
        // corner case
        reverse(s, start, s.length - 1);
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
```
