class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) addWord(words[i], root, i);
        for (int i = 0; i < words.length; i++) search(res, root, words, i);
        return res;
    }
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
    public void addWord(String word, TrieNode root, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (root.links[j] == null) root.links[j] = new TrieNode();
            
            if (isPalindrome(word, 0, i)) root.list.add(index);
            
            root = root.links[j];
        }
        root.index = index;
        root.list.add(index);
    }
    public void search(List<List<Integer>> res, TrieNode root, String[] words, int i) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) 
                res.add(Arrays.asList(i, root.index));
            root = root.links[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }
        
        for (int j : root.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        } 
    }
    class TrieNode { // current TrieNode represents xxxx'curr'
        TrieNode[] links; // letter before the current TrieNode
        int index; // -1 => no word ends with current TrieNode, 0 => words[0] ends with curr-root 
        List<Integer> list; // i : list => word[i] ends with curr-root nodes && leaf-(curr - 1) nodes is Palindrome
        public TrieNode() {
            links = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
}