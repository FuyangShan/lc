# Alien Dictionary

Input: nums = [1,3], n = 6
Output: 1 
Explanation:
Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.
Example 2:

Input: nums = [1,5,10], n = 20
Output: 2
Explanation: The two patches can be [2, 4].
Example 3:

Input: nums = [1,2,2], n = 5
Output: 0

```java
class Solution {
    
    StringBuilder sb = new StringBuilder();
    
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Integer, Set<Integer>> map = buildTrieAndMap(words);
        boolean valid = topologicalSort(map);
        return valid ? sb.toString() : "";
        
    }
    
    private boolean topologicalSort(Map<Integer, Set<Integer>> map) {
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        buildIndegree(indegreeMap, map);
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> pair : indegreeMap.entrySet()) {
            int key = pair.getKey();
            int value = pair.getValue();
            if (value == 0) queue.offer(key);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int key = queue.poll();
                for (Integer v : map.get(key)) {
                    indegreeMap.put(v, indegreeMap.get(v) - 1);
                    if (indegreeMap.get(v) == 0) queue.offer(v);
                }
                indegreeMap.remove(key);
                char c = (char)(key + 'a');
                sb.append(c);
            }
        }
        if (!indegreeMap.isEmpty()) return false;
        return true;
    }
    
    private void buildIndegree(Map<Integer, Integer> indegreeMap, Map<Integer, Set<Integer>> map) {
        for (Map.Entry<Integer, Set<Integer>> pair : map.entrySet()) {
            int key = pair.getKey();
            int count = 0;
            for (Set<Integer> set : map.values()) {
                if (set.contains(key)) count++;
            }
            indegreeMap.put(key, count);
        }
    }

    private Map<Integer, Set<Integer>> buildTrieAndMap(String[] words) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        TrieNode root = new TrieNode();
        TrieNode curr = root;
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int pos = c - 'a';
                if (curr.next[pos] == null) curr.next[pos] = new TrieNode();
                
                if (curr.prev != -1 && curr.prev != pos) {
                    if (!map.containsKey(curr.prev)) map.put(curr.prev, new HashSet<>());
                    map.get(curr.prev).add(pos);
                }
                
                if (!map.containsKey(pos)) map.put(pos, new HashSet<>());
                curr.prev = pos;
                curr = curr.next[pos];
            }
            curr = root;
        }
        
        return map;
    }
    
    class TrieNode {
        TrieNode[] next;
        int prev;
        public TrieNode() {
            next = new TrieNode[26];
            prev = -1;
        }
    }
}
```
