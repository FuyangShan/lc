# Regular Expression Matching
- Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and 'STAR'.

- '.' Matches any single character.
- 'STAR' Matches zero or more of the preceding element.
- The matching should cover the entire input string (not partial).

- Note:

- s could be empty and contains only lowercase letters a-z.
- p could be empty and contains only lowercase letters a-z, and characters like . or STAR.

> Example 1:
> Input:
> s = "aa"
> p = "a"
> Output: false
> Explanation: "a" does not match the entire string "aa".

> Example 2:
> Input:
> s = "aa"
> p = "aSTAR"
> Output: true
> Explanation: 'STAR' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

> Example 3:
> Input:
> s = "ab"
> p = ".STAR"
> Output: true
> Explanation: ".STAR" means "zero or more (STAR) of any character (.)".

> > Example 4:
> Input:
> s = "aab"
> p = "cSTARaSTARb"
> Output: true
> Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

> Example 5:
> Input:
> s = "mississippi"
> p = "misSTARisSTARpSTAR."
> Output: false

```java
// DP
class Solution {
    public boolean isMatch(String s, String p) {
    	int m = s.length();
    	int n = p.length();
		
		// f[i][j] = if p[0,...j-1] match s[0,...,i-1]
		boolean[][] f = new boolean[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				// init, s and p are both empty
				if (i == 0 && j == 0) {
					f[i][j] = true;
					continue;
				}
				// init, p is empty
				if (j == 0) {
					f[i][j] = false;
					continue;
				}

				// init
				f[i][j] = false;

				// f[i][j] = {
				//             f[i-1][j-1] | p[j-1] = '.' or s[i-1]=p[j-1]
				//               OR
				//             f[i][j-2]   | p[j-1] = '*'
				//               or
				//             f[i-1][j]   | p[j-1] = '*' AND (p[j-2] = '.' or s[i-1]=p[j-2])
				//           }

				// case 1   p = "xxxxx A/."
				if (p.charAt(j - 1) != '*') {
					if (i > 0 && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1))) {
						f[i][j] = f[i - 1][j - 1];
					}
				// case 2   p = "xxxxx *"
				} else {
					// p = "xxxxx A*"  A repeat 0 times
					if (j >= 2) {
						f[i][j] |= f[i][j - 2];
					}
					// p = "xxxxx A*"  A repeat n times
					// p = "xxxxx .*"  . repeat n times
					if (i >= 1 && j >= 2) {
						f[i][j] |= f[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1));
					}
					if () {
							
					}
			}
		}
		return f[m][n];
    }
}
```
