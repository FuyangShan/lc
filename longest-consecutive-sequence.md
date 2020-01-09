# Longest Consecutive Sequence

- Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

- Your algorithm should run in O(n) complexity.

> Example:

> Input: [100, 4, 200, 1, 3, 2]
> Output: 4
> Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int i : nums) hash.add(i); //get the unique numbers;
        
        int longest = 0; //the final res
        int len = 0; //the len of each consecutive sequence
        
        for (int i : hash) {
            if (!hash.contains(i - 1)) { //start counting len from the head of sequence
                len = 1; //start from 1
                while (hash.contains(i + 1)) { //increase len while consecutive
                    len++;
                    i++;
                }
            }
            longest = Math.max(longest, len); //update longest;
        }
        return longest;
    }
}
```
