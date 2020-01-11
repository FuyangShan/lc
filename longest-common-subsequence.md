# Longest Common Subsequence

Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.


```java
class Solution {
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		// f[i][j] = longest common subsequence of text1 [0, m-1] and text2 [0, n-1]
		int[][] f = new int[m+ 1][n + 1];
		
		for (int i = 0; i <=m; i++) {
			for (int j = 0; j <= n; j++) {
				// init
				if (i == 0 || j == 0) {
					f[i][j] = 0;
					continue;
				}
				// normal transition function
				// f[i][j] = Max{f[i-1][j], f[i][j-1], f[i-1][j-1]+1 | t1[i] = t2[j]}
				f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
				}
		}
		return f[m][n];	
	}
}
```
