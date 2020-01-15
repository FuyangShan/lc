# Shortest Palindrome

Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example 1:

Input: "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: "abcd"
Output: "dcbabcd"

```java
class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = len / 2 - 1; i >= 0; i--) {
            for (int x = 2; x > 0; x--) {
                int j = i, k = i + x;
                while (j >= 0 && k < len && s.charAt(j) == s.charAt(k)) {
                    j--;
                    k++;
                }
                if (j == -1) {
                    while (k < len)
                        sb.insert(0, s.charAt(k++));
                    // System.out.println(sb.toString());
                    return sb.toString() + s;
                }
            }
        }

        for (int i = len - 1; i > 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString() + s;
    }
}

// validate from [0, len]...to [0, len - 1]
class Solution {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}

// KMP
public class Solution {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int[] lps = getLPS(s + '|' + r);
        return r.substring(0, r.length() - lps[lps.length - 1]) + s;
    }

    // KMP get longest prefix and suffix count
    int[] getLPS(String s) {
        int[] lps = new int[s.length()];
        int i = 1, len = 0;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len))
                lps[i++] = ++len;
            else if (len == 0)
                lps[i++] = 0;
            else
                len = lps[len - 1];
        }

        return lps;
    }
}
```