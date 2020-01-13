# Shortest Word Distance III

- Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

- word1 and word2 may be the same and they represent two individual words in the list.

> Example:

> Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

> Input: word1 = “makes”, word2 = “coding”
> Output: 1

> Input: word1 = "makes", word2 = "makes"
> Output: 3

```java
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int index = -1;
        int d = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (!word2.equals(word1)) {
                if (words[i].equals(word1)) index1 = i;
                if (words[i].equals(word2)) index2 = i;
                if (index1 != -1 && index2 != -1) d = Math.min(d, Math.abs(index1 - index2));
            } else {
                if (words[i].equals(word1) && index == -1) index = i;
                else if (words[i].equals(word1)) {
                    d = Math.min(d, i - index);
                    index = i;
                }
            }
        }
        
        return d;
    }
}
```
