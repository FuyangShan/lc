# Shortest way to form String

From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).

Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.

 

Example 1:

Input: source = "abc", target = "abcbc"
Output: 2
Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
Example 2:

Input: source = "abc", target = "acdbc"
Output: -1
Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.
Example 3:

Input: source = "xyz", target = "xzyxz"
Output: 3
Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
 

Constraints:

Both the source and target strings consist of only lowercase English letters from "a"-"z".
The lengths of source and target string are between 1 and 1000.

```java
// DP O(n^2 * m)
class Solution {
    public int shortestWay(String source, String target) {

        int n = target.length();
        // f[i] = shortest way to for first i chars (target[0,...i-1])
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        // init
        f[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // enumerating last cut from ''+'0....i-1' to '0...i-2'+'i-1'
                if (f[j] < Integer.MAX_VALUE && i - j <= source.length()) {
                    String sub = target.substring(j, i);
                    if (isSubsequence(source, sub)) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n] == Integer.MAX_VALUE ? -1 : f[n];

    }
    private boolean isSubsequence( String src, String tgt) {
        int i = 0;
        for (int j = 0; j < src.length(); j++) {
            if (src.charAt(j) != tgt.charAt(i)) continue;
            if (++i == tgt.length()) break;
        }
        if (i == tgt.length()) return true;
        else return false;
    }
}

// Two Pointers O(m*n)
class Solution {
    public int shortestWay(String source, String target) {
        char[] src = source.toCharArray();
        char[] tgt = target.toCharArray();
        // store the appearance of char in src
        boolean[] srcMap = new boolean[26];
        for (char c : src) {
            srcMap[c - 'a'] = true;
        }
        int res = 0;

        // j iterate src, i iterate tgt
        for (int i = 0, j = 0; i < tgt.length; i++, j++) {
            // if char in tgt !exist in source, return -1
            if (!srcMap[tgt[i] - 'a']) return -1;
            while (j < src.length && src[j] != tgt[i]) {
                j++;
            }
            if (j == src.length) {
                j = -1;
                res++;
                i--;
            }
        }
        return res;
    }
}

// Store all char pos, O(n)
class Solution {
    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        int[][] idx = new int[26][cs.length];
        for (int i = 0; i < cs.length; i++) idx[cs[i] - 'a'][i] = i + 1;
        for (int i = 0; i < 26; i++) {
            for (int j = cs.length - 1, pre = 0; j >= 0; j--) {
                if (idx[i][j] == 0) idx[i][j] = pre;
                else pre = idx[i][j];
            }
        }
        int res = 1, j = 0;
        for (int i = 0; i < ts.length; i++) {
            if (j == cs.length) {
                j = 0;
                res++;
            }
            if (idx[ts[i] - 'a'][0] == 0) return -1;
            j = idx[ts[i] - 'a'][j];
            if (j == 0 ) {
                res++;
                i--;
            }
        }
        return  res;
    }
}
```