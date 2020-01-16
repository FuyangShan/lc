# Minimum Window Subsequence

- Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

- If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

> Example 1:
> 
> Input: 
> S = "abcdebdde", T = "bde"
> Output: "bcde"
> Explanation: 
> "bcde" is the answer because it occurs before "bdde" which has the same length.
> "deb" is not a smaller window because the elements of T in the window must occur in order.
 

- Note:

- All the strings in the input will only contain lowercase letters.
- The length of S will be in the range [1, 20000].
- The length of T will be in the range [1, 100].

```java
class Solution {
    public String minWindow(String S, String T) {
        
        char[] str = S.toCharArray();
        char[] tgt = T.toCharArray();
        int m = str.length;
        int n = tgt.length;
        
        int min = Integer.MAX_VALUE;
        String res = "";
        
        
        for (int k = 0; k <= m - n; k++) {
            
            if (str[k] != tgt[0]) continue;
            // when first match, note the substring len
            int len = 0;
            int i = k;
            int j = 0;
            while (i < m && j < n) {
                if (str[i] == tgt[j]) {
                    j++;
                }
                if (j == n) break;
                i++;
            }
            if (i == m) len = Integer.MAX_VALUE;
            else len = i - k + 1;
            
            if (min > len) {
                min = len;
                res = S.substring(k, k + len);
            }
            
        }
        return res;
        
    }
}
```