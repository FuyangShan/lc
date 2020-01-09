```java
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                DFS(res, board, i, j, root);
            }
        }
        return res;
        
    }
    public void DFS(List<String> res, char[][] board, int i, int j, TrieNode curr) {
        char c = board[i][j];
        if (c == '#' || curr.links[c - 'a'] == null) return;
        
        curr = curr.links[c - 'a'];
        if (curr.word != null) {
            res.add(curr.word);
            curr.word = null;
        }
        board[i][j] = '#';
        
        if (i > 0) DFS(res, board, i - 1, j, curr);
        if (j > 0) DFS(res, board, i, j - 1, curr);
        if (i < board.length - 1) DFS(res, board, i + 1, j, curr);
        if (j < board[0].length - 1) DFS(res, board, i, j + 1, curr);
        
        board[i][j] = c;
    }
    
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.links[c - 'a'] == null) curr.links[c - 'a'] = new TrieNode();
                curr = curr.links[c - 'a'];
            }
            curr.word = word;
        }
        return root;
    }
    class TrieNode {
        TrieNode[] links = new TrieNode[26];
        String word;
    }
}
```