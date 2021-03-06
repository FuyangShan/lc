# Shortest Word Distance
- Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

> Example:

> Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

> Input: word1 = “coding”, word2 = “practice”
> Output: 3
> Input: word1 = "makes", word2 = "coding"
> Output: 1

```java
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int d = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) index1 = i;
            if (words[i].equals(word2)) index2 = i;
            if (index1 != -1 && index2 != -1) {
                d = Math.min(d, Math.abs(index1 - index2));
            }  
        }
        return d;
    }
}
```
