# 763. Partition Labels

A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.



```java
class Solution {
    public List<Integer> partitionLabels(String S) {
        // scan the string and store <char, count>
        int[] count = new int[26]; // count[0] is occurance number of char
        for (char c : S.toCharArray()) count[c -'a']++;
        
        Window win = new Window(count);
        List<Integer> res = new ArrayList<>();
        int lastIndex = 0;
        int i = 0;
        // create a window and add elements into window until all elements in window reached their cap, add index+1 into result list
        while (i < S.length()) {
            win.add(S.charAt(i)); // add current char
            if (win.isFull()) { // when full, add length to result
                win = new Window(count); // reset window
                res.add(i - lastIndex + 1); // calculate the length
                lastIndex = i + 1;
            }
            i++;
        }
        return res;
    }
}

class Window {
    private int[] target;
    private int[] current;
    private int goal;
    private boolean isFull;
    public Window(int[] count) {
        target = count;
        current = new int[26];
        isFull = false;
    }
    
    public void add(char x) {
        int c = x - 'a';
        if (current[c] == 0) { // new char added, increase the goal
            goal++;
        }
        current[c]++;
        if (current[c] == target[c]) goal--; // if c reached goal, goal--
        if (goal == 0) isFull = true;
    }
    
    public boolean isFull() {
        return isFull;
    } 
        
}
```