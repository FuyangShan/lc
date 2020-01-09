```java
class Solution {
    public void solveSudoku(char[][] board) {
        DFS(board, 0);
    }
    
    public boolean DFS(char[][] board, int pos) {
        if (pos == 81) return true;
        int i = pos / 9, j = pos % 9; // calculate [i, j] from pos
        if (board[i][j] != '.') return DFS(board, pos + 1); // skip prefilled number;
        
        // get valid number to fill current '.'
        boolean[] flag = new boolean[10]; 
        validate(board, i, j, flag);
        
        for (int k = 1; k <= 9; k++) {
            if (flag[k]) {
                board[i][j] = (char)(k + '0');
                if (DFS(board, pos + 1)) return true;
            }
        }
        board[i][j] = '.'; // if can not solve, in this wrong path revert [i, j] back to '.'
        return false; // wrong path
    }
    
    public void validate(char[][] board, int i, int j, boolean[] flag) {
        Arrays.fill(flag, true);
        for (int k = 0; k < 9; k++) { // exclude number in row, col, sqr
            if (board[i][k] != '.') flag[board[i][k] - '0'] = false; // exclude numbers in row[i]
            if (board[k][j] != '.') flag[board[k][j] - '0'] = false; // exclude numbers in col[j]
            int r = i / 3 * 3 + k / 3;
            int c = j / 3 * 3 + k % 3;
            if (board[r][c] != '.') flag[board[r][c] - '0'] = false; // exclude numbers in sqr
        }
    }
}
```
