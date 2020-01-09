# Dungeon Game

- The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

- The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

- Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

- In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 

### Q: Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

>For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

>-2 (K)	-3	    3
>-5	    -10	    1
>10	    30	    -5 (P)
 
```java
// DP
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;
        
        //f[i][j] = the hp needed at dungeon[i][j]
        int[][] f = new int[m + 1][n + 1];
        // init
        f[m - 1][n] = 1;
        f[m][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int need = 0; 
                // f[i][j] = {Min(f[i][j+1], f[i+1][j]) - dungeon[i][j]}
                if (i == m - 1) need = f[i][j + 1] - dungeon[i][j];
                else if (j == n - 1) need = f[i + 1][j] - dungeon[i][j];
                else  need = Math.min(f[i + 1][j], f[i][j + 1]) - dungeon[i][j];
                f[i][j] = need <= 0 ? 1 : need;
            }
        }
        return f[0][0];
    }
}
```