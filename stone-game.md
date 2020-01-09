# Stone Game
- Alex and Lee play a game with piles of stones.  
- There are an even number of piles arranged in a row, 
- and each pile has a positive integer number of stones piles[i].

- The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

- Alex and Lee take turns, with Alex starting first.  
- Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.

- Assuming Alex and Lee play optimally, return ***True*** if and only if Alex wins the game.

 

>Example 1:

>Input: [5,3,4,5]
>Output: true
>Explanation: 
>Alex starts first, and can only take the first 5 or the last 5.
>Say he takes the first 5, so that the row becomes [3, 4, 5].
>If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
>If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
>This demonstrated that taking the first 5 was a winning move for Alex, so we return true.

```java

// DP
class Solution {
    public boolean stoneGame(int[] piles) {
        if (piles == null || piles.length == 0) return true;
        int n = piles.length;
        // f[i][j] = how many "more" stones someone can have than rival,
        // when facing piles[i]...piles[j]
        int[][] f = new int[n][n];
        // init, when facing "only" piles[i],
        // he can have piles[i] "more" stones than rival
        for (int i = 0; i < n; i++) {
            f[i][i] = piles[i];
        }
        // iterate from len = 2 to len = n
        for (int len = 2; len <= n; len++) {
            // ------ len -------
            // n-len -------- n-1
            //   i             j
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // case 1: take head piles[i], cause rival to be f[i + 1][j]
                // case 2: take tail pilse[j], cause rival to be f[i][j - 1]
                // optimally choose the better choice
                f[i][j] = Math.max(piles[i] - f[i + 1][j], piles[j] - f[i][j - 1]);
            }
        }
        
        return f[0][n - 1] >= 0;
    }
}
```