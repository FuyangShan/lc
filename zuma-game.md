```java
class Solution {
    
    int MAXCOUNT = 6; // the ball at hands won't excceed 5, so if maxcount stays 6, it failed
    
    public int findMinStep(String board, String hand) {
        int[] hands = new int[26];
        for (char c : hand.toCharArray()) hands[c - 'A']++;
        int res = DFS(board + "#", hands);
        return res == MAXCOUNT ? -1 : res;
    }
    
    public int DFS(String s, int[] hands) {
        s = removeConsecutive(s); // remove 3 or more consecutive letters
        if (s.equals("#")) return 0;
        int res = MAXCOUNT;
        int need = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j)) continue;
            need = 3 - (i - j); // balls needed to remove current consecutive balls
            if (hands[s.charAt(j) - 'A'] >= need) {
                hands[s.charAt(j) - 'A'] -= need;
                res = Math.min(res, need + DFS(s.substring(0, j) + s.substring(i), hands));
                hands[s.charAt(j) - 'A'] += need;
            }
            j = i;
        }
        return res;
    }
    
    // remove consecutive balls longer than 3
    private String removeConsecutive(String board) {
        for (int i = 0, j = 0; i < board.length(); i++) {
            if (board.charAt(j) == board.charAt(i))
                continue;
            if (i - j >= 3) return removeConsecutive(board.substring(0, j) + board.substring(i));
            j = i;
        }
        return board;
    }
}
```