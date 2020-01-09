# Palindrome Partition II
- Given a string s, partition s such that every substring of the partition is a palindrome.

### Q: Return the minimum cuts needed for a palindrome partitioning of s.

>Example:

>Input: "aab"
>Output: 1
>Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

```java

// DP
class Solution {
    public int minCut(String s) {
        int n = s.length();
        // isPalin[i][j] = if s[i]...s[j] is Palindrome
        boolean[][] isPalin = new boolean[n][n]; 
        // f[i] = minCuts to partition s[0]...s[i]
        int[] f = new int[n]; 
        
        for (int i = 0; i < n; i++) { 
            // init, maximum cuts needed
            f[i] = i;
            // enumerate j from 0 to i
            for (int j = 0; j <= i; j++) { 
                // [j, i] is Palindrome : s[i] == s[j] AND (i, j are adjacent OR neighbors [i - 1][j + 1] is Palindrome)
                if ((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || isPalin[i - 1][j + 1])) {
                    isPalin[i][j] = true;
                    // f[i] = Min{f[j - 1] + 1}
                    f[i] = (j == 0) ? 0 : Math.min(f[i], (f[j - 1] + 1));
                }
            }
        }
        return f[n - 1];
    }
}
```