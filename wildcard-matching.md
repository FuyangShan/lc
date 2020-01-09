# 44. Wildcard Matching
- Given an input string (s) and a pattern (p)
### Q: implement wildcard pattern matching with support for '?' and 'STAR'.

- '?' Matches any single character.
- 'STAR' Matches any sequence of characters (including the empty sequence).
- The matching should cover the entire input string (not partial).

- Note:

- s could be empty and contains only lowercase letters a-z.
- p could be empty and contains only lowercase letters a-z, and characters like ? or STAR.

> Example 1:
> Input:
> s = "aa"
> p = "a"
> Output: false
> Explanation: "a" does not match the entire string "aa".

> Example 2:
> Input:
> s = "aa"
> p = "STAR"
> Output: true
> Explanation: 'STAR' matches any sequence.

> Example 3:
> Input:
> s = "cb"
> p = "?a"
> Output: false
> Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

> Example 4:
> Input:
> s = "adceb"
> p = "STARaSTARb"
> Output: true
> Explanation: The first 'STAR' matches the empty sequence, while the second 'STAR' matches the substring "dce".

> Example 5:
> Input:
> s = "acdcb"
> p = "aSTARc?b"
> Output: false

```java

// DP
public class Solution {
    public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();

		boolean[][] f = new boolean[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				// init
				if (i == 0 && j == 0) {
					f[i][j] = true;
					continue;
				}
				// init
				if (j == 0) {
					f[i][j] = false;
					continue;
				}

				// init
				f[i][j] = false;

				// f[i][j] = {
				//             f[i-1][j-1] | p[j-1]='?' or s[i-1]=p[j-1]
				//               OR
				//             f[i][j-1] or f[i-1][j] | p[j-1]='*'
				//           }

				// case 1, p = "xxxxx A/?"
				if (p.charAt(j - 1) != '*') {
					if (i >= 1 && p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
						f[i][j] |= f[i - 1][j - 1];
					}
				// case 2, p = "xxxxx *"
				} else {
					f[i][j] |= f[i][j - 1];
					if (i >= 1) {
						f[i][j] |= f[i - 1][j];
					}
				}
			}
		}
		return f[m][n];
	}
}
```
