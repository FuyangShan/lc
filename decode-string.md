# Decode String
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

```java
class Solution {
    int index = 0; // scan starting from index 0
    public String decodeString(String s) {
        // res to host final result
        StringBuilder res = new StringBuilder();
        // current repeating number
        int k = 0;
        
        while (index < s.length()) { // scan s with incremental index
            char c = s.charAt(index);
            if (Character.isDigit(c)) { // digit found, update k
                index++;
                k = k * 10 + (c - '0');
            } else if (c == '[') { // recursively decode[s], add "decoded" k times to res, reset k
                index++;
                String decoded = decodeString(s);
                for (int j = 0; j < k; j++) res.append(decoded);
                k = 0;
            } else if (Character.isLetter(c)) { // append c to res
                index++;
                res.append(c);
            } else if (c == ']') { // we are in "[]", need to return res
                index++;
                return res.toString();
            }
        }
        return res.toString();
    }
}
```