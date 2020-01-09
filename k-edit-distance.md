# K Edit Distance
- Given a set of strings which just has lower case letters and a target string
### Q: output all the strings for each the edit distance with the target no greater than k.

- You have the following 3 operations permitted on a word:

- Insert a character
- Delete a character
- Replace a character

> Example 1:

> Given words = `["abc", "abd", "abcd", "adc"]` and target = `"ac"`, k = `1`
> Return `["abc", "adc"]`
> Input:
> ["abc", "abd", "abcd", "adc"]
> "ac"
> 1
> Output:
> ["abc","adc"]

```java
class TrieNode {
	TrieNode[] next;
	boolean isWord;
	String word;

	public TrieNode() {
		next = new TrieNode[26];
		isWord = false;
	}
	// insert a word called wordStr from root
	public static void Insert(TrieNode root, String wordStr) {
		char[] word = wordStr.toCharArray();
		TrieNode curr = root;
		for (int i = 0; i < word.length; i++) {
			int c = word[i] - 'a'; // 0 ~ 25
			if (curr.next[c] == null ) {
				curr.next[c] = new TrieNode();
			}
			curr = curr.next[c];
		}
		curr.isWord = true;
		curr.word = wordStr;
	}
}


public class Solution {

	char[] target = null;
	int K = 0;
	int[] f = null; // f[i] = edit distance from target[0, ..., i-1] to "prefix"
	int n = 0;
	List<String> res = null;

	// at node curr, prefix pre
	// f = f[pre][0 ~ n]
	// todo: pre-->(pre, 'a'), ..., (pre, 'z')
	private void dfs(TrieNode curr, int[] f) {
		// nf[j] = f[pre + target[j-1]][0 ~ n]
		int[] nf = new int[n + 1];
		// whether curr is word
		if (curr.isWord) {
			if (f[n] <= K) {
				res.add(curr.word);
			}
		}
		
		for (int i = 0; i < 26; i++) {
			if (curr.next[i] == null) {
				continue;
			}
			nf[0] = f[0] + 1;
			for (int j = 1; j <= n; j++) {
				// f[i][j] = Min {f[i-1][j]+1, f[i-1][j-1]+1, f[i][j-1]+1}
				nf[j] = Math.min(Math.min(nf[j - 1] + 1, f[j] + 1), f[j - 1] + 1);
				int c = target[j - 1] - 'a';
				if (c == i) {
					// f[i][j] = Min {f[i][j], f[i-1][j-1] | A[i-1]=target[j-1]
					nf[j] = Math.min(nf[j], f[j - 1]);
				}
			}
			dfs(curr.next[i], nf);
		}
	}
	/*
	* @param words: a set of stirngs
	* @param target: a target string
	* @param k: An integer
	* @return: output all the strings that meet the requirements
	*/
	public List<String> kDistance(String[] words, String targetStr, int k) {
		target = targetStr.toCharArray();
		n = target.length;
		K = k;
		res = new ArrayList<>();

		// init trie
		TrieNode root = new TrieNode();
		for (int i = 0; i < word.length; i++) {
			TrieNode.Insert(root, words[i]);
		}
 
		// init f
		// f[""][0 ~ n]
		f = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			f[i] = i;
		}

		// dfs
		dfs(root, f);

		// return result
		return res;
	}
}
```
