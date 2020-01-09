# Scramble String

- Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

- Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
- To scramble the string, we may choose any non-leaf node and swap its two children.

- For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t

- We say that "rgeat" is a scrambled string of "great".

- Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
- We say that "rgtae" is a scrambled string of "great".

- Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

>Example 1:

>Input: s1 = "great", s2 = "rgeat"
>Output: true

>Example 2:

>Input: s1 = "abcde", s2 = "caebd"
>Output: false

```java

// DP
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || 
            s1.length() == 0 || s2.length() == 0 ||
            s1.length() != s2.length()) 
            return false;

        int n = s1.length();
        // f[i][j][w] = if s1.substring(i, i + w) can transfer to s2.substring(j, j + w)
        boolean[][][] f = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // init
                f[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    f[i][j][k] = false;
                    // enumerate partition position (s1 length)
                    for (int w = 1; w <= k - 1; w++) {
                        // case 1: no swap
                        // s1.sub1 -> s2.sub1, s1.sub2 -> s2.sub2
                        if (f[i][j][w] && f[i + w][j + w][k - w]) {
                            f[i][j][k] = true;
                            break;
                        }
                        // case 2: swap
                        // s1.sub1 -> s2.sub2, s1.sub2 -> s2.sub1
                        if (f[i][j + k - w][w] && f[i + w][j][k - w]) {
                            f[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }
}

// DFS
class Solution {
    public boolean isScramble(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        return helper(s1, s2, map);
    }
    public boolean helper(String s1, String s2, HashMap<String, Integer> map) {
        
        String key = s1 + "#" + s2;
        
        int res = map.getOrDefault(key, -1);
        if (res == 1) return true;
        else if (res == 0) return false;
        
        if (s1.equals(s2)) {
            map.put(key, 1);
            return true;
        }
        if (s1.length() != s2.length()) {
            map.put(key, 0);
            return false;
        }
        
        int[] count = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                map.put(key, 0);
                return false;
            }
        }
        
        for (int i = 1; i < s1.length(); i++) {
            if (helper(s1.substring(0, i), s2.substring(0, i), map) && helper(s1.substring(i), s2.substring(i), map)) {
                map.put(key, 1);
                return true;
            } 
            if (helper(s1.substring(0, i), s2.substring(s1.length() - i), map) && helper(s1.substring(i), s2.substring(0, s1.length() - i), map)) {
                map.put(key, 1);
                return true;
            }
        }
        
        map.put(key, 0);
        return false;
    }
}
```






