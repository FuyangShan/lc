```java
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>(); // result 
        HashMap<String, List<String>> nodeNeighbors = new HashMap<>(); // neighbor nodes of each node
        HashMap<String, Integer> distance = new HashMap<>(); // distance to begin of each node
        List<String> tempList = new ArrayList<>(); // each path
        HashSet<String> dict = new HashSet<>(wordList); // all words
        tempList.add(beginWord);
        dict.add(beginWord); // a dict contain all nodes

        bfs(beginWord, endWord, dict, distance, nodeNeighbors);
        dfs(beginWord, endWord, distance, nodeNeighbors, res, tempList);
        
        return res;
    }
    // BFS put all neighbors of each node in nodeNeighbors
    public void bfs(String beginWord, String endWord, HashSet<String> dict, HashMap<String, Integer> distance, HashMap<String, List<String>> nodeNeighbors){
        for (String word : dict) nodeNeighbors.put(word, new ArrayList<String>());
        Queue<String> queue = new LinkedList<>();
        distance.put(beginWord, 0);
        queue.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < size; i++){
                String cur = queue.poll();
                for (String neighbor : getNeighbors(cur, dict)){
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(cur) + 1);
                        if (neighbor.equals(endWord)){
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            if (foundEnd) break;
        }
    }
    public List<String> getNeighbors(String cur, HashSet<String> dict){
        List<String> res = new ArrayList<>();
        char[] curChrs = cur.toCharArray();

        for (char chr = 'a'; chr <= 'z'; chr++){
            for (int i = 0; i < curChrs.length; i++){
                if (chr == curChrs[i]) continue;
                char old_chr = curChrs[i];
                curChrs[i] = chr;
                if (dict.contains(String.valueOf(curChrs)))
                    res.add(String.valueOf(curChrs));
                curChrs[i] = old_chr;
            }
        }
        return res;
    }     

    public void dfs(String cur, String endWord, HashMap<String,Integer> distance, HashMap<String, List<String>> nodeNeighbors, List<List<String>> res, List<String> sol){
        if (cur.equals(endWord)){
            res.add(new ArrayList<>(sol));
        } else {
            for (String neighbor: nodeNeighbors.get(cur)){
                if (distance.get(neighbor) == distance.get(cur) + 1){
                    sol.add(neighbor);
                    dfs(neighbor, endWord, distance, nodeNeighbors, res, sol);
                    sol.remove(sol.size() - 1);
                }
            }
        }
    }
}
```