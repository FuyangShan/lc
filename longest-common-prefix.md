# Longest Common Prefix
- Write a function to find the longest common prefix string amongst an array of strings.

- If there is no common prefix, return an empty string "".

> Example 1:

> Input: ["flower","flow","flight"]
> Output: "fl"
> Example 2:

> Input: ["dog","racecar","car"]
> Output: ""
> Explanation: There is no common prefix among the input strings.

```java

// Traverse array, binary search prefix
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0) return "";
        
        int minLen = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                index = i;
            }
        }
        String minStr = strs[index];
        
        int len = minStr.length();
        
        int left = 0, right = len, mid;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isStartFrom(minStr.substring(0, mid), strs)) left = mid + 1;
            else right = mid - 1;
        }
        return minStr.substring(0, left - 1);
    }
    
    public boolean isStartFrom(String pre, String[] strs) {
        for (int i = 0; i < strs.length; i++)
            if (!strs[i].startsWith(pre))
                return false;
        return true;
    }
}

// Trie
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Trie t = new Trie();
        int max = 0;
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            index = strs[i].length() > max ? i : index;
            max = Math.max(max, strs[i].length());
            t.insert(strs[i]);
        }
        
        StringBuilder prefix = new StringBuilder();
        TrieNode curr = t.root;
        for (char c : strs[index].toCharArray()) {
            if (curr.children[c - 'a'] != null && t.numChildren(curr) == 1 && !curr.isWord) {
                prefix.append(curr.children[c - 'a'].val);
                curr = curr.children[c - 'a'];
            } else break;
        }
        return prefix.toString();
    }
}

class TrieNode {
    char val;
    TrieNode[] children;
    boolean isWord;
    public TrieNode(char x) {
        val = x;
        children = new TrieNode[26];
        isWord = false;
    }
}

class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('.');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode(c);
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    public int numChildren(TrieNode curr) {
        int num = 0;
        for (TrieNode trieNode : curr.children) {
            if (trieNode != null) num++;
        }
        return num;
    }
}
```
