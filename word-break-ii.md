# Word Break II
- Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
### Q: add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

- Note:

- The same word in the dictionary may be reused multiple times in the segmentation.
- You may assume the dictionary does not contain duplicate words.

> Example 1:

> Input:
> s = "catsanddog"
> wordDict = ["cat", "cats", "and", "sand", "dog"]
> Output:
> [
> "cats and dog",
> "cat sand dog"
> ]

> Example 2:

> Input:
> s = "pineapplepenapple"
> wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
> Output:
> [
> "pine apple pen apple",
> "pine apple pen apple",
> "pine applepen apple"
> ]
> Explanation: Note that you are allowed to reuse a dictionary word.

> Example 3:

> Input:
> s = "catsandog"
> wordDict = ["cats", "dog", "sand", "and", "cat"]
> Output:
> []

```java
// DFS + Memorization
class Solution {
	HashMap<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
		// store all words in set
		HashSet<String> set = new HashSet<>();
		set.addAll(wordDict);
		return dfs(s, 0, set);
    }
	private List<String> dfs(String s, int index, HashSet<String> set) {
		if (map.containsKey(index)) {
			return map.get(index);
		}
		List<String> res = new ArrayList<>();

		if (index == s.length()) {
			res.add("");
		}
		for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if (set.contains(word)) {
				List<String> list = dfs(s, i, set);
				for (String l : list) {
					res.add(word + (l.equals("") ? "" : " ") + l);
				}
            }
		}
		map.put(index, res);
		return res;
	}
}
// DP
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<>();
		set.addAll(wordDict);

		int n = s.length();
		// f[i] = list of legal strings formed from Dict with s[0,..., i-1]
		List<String>[] f = new ArrayList[n + 1];
		// init
		List<String> initial = new ArrayList<>();
		initial.add("");
		f[0] = initial;

		for (int i = 0; i <= n; i++) {
			List<String> list = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				String word = s.substring(j, i);
				// f[i] = f[j] + " " + word | f[j] != null
				if (f[j].size() > 0 && set.contains(word)) {
					for (String l : f[j]) {
						list.add(l + (l.equals("") ? "" : " ") + word);
					}
				}
                f[i] = list;
			}
		}
		return f[n];
    }
}
```
