```java
// BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int len = 0;
        Queue<String> q = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>(wordList);
        q.add(beginWord);
        set.add(endWord);

        while (!q.isEmpty()){
            int n = q.size();
            for (int i = 0; i < n; i++){
                String former = q.poll();
                if (former.equals(endWord)) return len + 1;
                wordMatch(former, set, q);
            }
            len++;
        }
        return 0;
    }
    public void wordMatch(String w, Set<String> set, Queue<String> q) {
        for (int i = 0; i < w.length(); i++) {
            char[] word = w.toCharArray();
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (word[i] == c) continue;
                word[i] = c;
                String s = String.valueOf(word);
                if (set.contains(s)) {
                    set.remove(s);
                    q.offer(s);
                }
            }
        }
    }
}
```