# 1268. Search Suggestions System

https://leetcode.com/problems/search-suggestions-system/


```java
// to memorize what words are there with a certain prefix, we can build a prefix trie to store words
// ["mobile","mouse","moneypot","monitor","mousepad"]
//             m
//             o
//      b      n       u
//      i.    e. i.    s
//.     l.    y. t     e!
//      e!    p. o     p
//.           o. r!    a
//            t!       d!


class Solution {
    class TrieNode {
        char c;
        TrieNode[] nexts;
        String word;
        PriorityQueue<String> pq;
        TrieNode(char c) {
            pq = new PriorityQueue<>((a, b) -> (b.compareTo(a)));
            this.c = c;
            nexts = new TrieNode[26];
            word = null;
        }
    }
    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode('0');
        }
        public void addWord(String word) {
            if (word == null) return;
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (cur.nexts[i] == null) cur.nexts[i] = new TrieNode(c);
                cur = cur.nexts[i];
                cur.pq.add(word);
                if (cur.pq.size() > 3) cur.pq.poll();
            }
            cur.word = word;
        }
        
        public List<String> searchWords(String prefix) {
            List<String> list = new ArrayList<>();
            if (prefix == null) return list;
            int i = 0;
            TrieNode cur = root;
            while (!prefix.equals(cur.word) && i < prefix.length()) {
                int cc = prefix.charAt(i++) - 'a';
                if (cur.nexts[cc] == null) break;
                cur = cur.nexts[cc];
            }
            while (!cur.pq.isEmpty()) {
                list.add(cur.pq.poll());
            }
            for (String s : list) {
                cur.pq.add(s);
            }
            Collections.reverse(list);
            return list;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Trie t = new Trie();
        for (String pro : products) {
            t.addWord(pro);
        }
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> sol = t.searchWords(searchWord.substring(0, i + 1));
            res.add(sol);
        }
        return res;
    }
}
```



```java
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    PriorityQueue<String> pq = new PriorityQueue<>(3, (s1,s2) -> s1.compareTo(s2)); 
    List<List<String>> list = new ArrayList<>();
    
    for(int i = 1; i<=searchWord.length(); i++){
        String temp = searchWord.substring(0, i);
        for(String s : products){
            if(s.startsWith(temp)){
                pq.offer(s);
            }
        }
        List<String> temp_list = new ArrayList<>();
        for(int j = 0; j<3; j++){
            if(pq.peek() != null){
                temp_list.add(pq.poll());
            }
        }
        pq.clear();
        list.add(temp_list);
    }
    return list;
    }
}
```