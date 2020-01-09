# Word Break
- Given a non-empty string s and a dictionary wordDict containing a list of non-empty words
### Q: determine if s can be segmented into a space-separated sequence of one or more dictionary words.

- Note:

- The same word in the dictionary may be reused multiple times in the segmentation.
- You may assume the dictionary does not contain duplicate words.

> Example 1:

> Input: s = "leetcode", wordDict = ["leet", "code"]
> Output: true
> Explanation: Return true because "leetcode" can be segmented as "leet code".

> Example 2:

> Input: s = "applepenapple", wordDict = ["apple", "pen"]
> Output: true
> Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
> Note that you are allowed to reuse a dictionary word.

> Example 3:

> Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
> Output: false

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		// f[i] = if (first i chars) s[0, ..., i-1] can be broken with dict
        boolean[] f = new boolean[n + 1];
        HashSet<String> hash = new HashSet<>();
        hash.addAll(wordDict);
        f[0] = true;
        for (int i = 1; i <= n; i++){
			// yyyyyy xxxxxxxxxx
			// 0  j-1|j      i-1|i
            for (int j = 0; j < i; j++){
				// f[i] = {f[j] | s[j,i-1] exists}
                f[i] = f[j] && hash.contains(s.substring(j, i));
                if (f[i]) break;
            }
        }
        return f[n];
    }
}
```
