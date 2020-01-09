```java
class Solution {
    int n; // num of queens
    int[] queens; // col of each queen[row]
    int[] rows; // which col is Queen placed, all rows of this col are under attack
    int[] hills; // which dale is Queen placed, all hills of this dale are under attack
    int[] dales; // which hill is Queen placed, all dales of this hell are under attack
    List<List<String>> output = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        queens = new int[n];
        rows = new int[n];
        hills = new int[2 * n - 1];
        dales = new int[2 * n - 1];
        backtrack(0);
        return output;
    }
    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + n - 1] + dales[row + col];
        return res == 0 ? true : false;
    }
    public void placeQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        hills[row - col + n - 1] = 1;
        dales[row + col] = 1;
    }
    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + n - 1] = 0;
        dales[row + col] = 0;
    }
    public void backtrack(int row) {
        for (int col = 0; col < n; col++) { // for this row, try place Queen in each col
            if (isNotUnderAttack(row, col)) { // if OK to place, proceed place
                placeQueen(row, col);
                if (row + 1 == n) // if this is last row, add to solution
                    addToSolutions();
                else              // if not the last row, go to next row
                    backtrack(row + 1);
                removeQueen(row, col); // setback the last placement
            }   
        }
    }
    public void addToSolutions() {
        List<String> solution = new ArrayList<>();
        for (int row = 0; row < n; row++) { // 
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < queens[row]; col++) {
                sb.append('.');
            }
            sb.append('Q');
            for (int col = queens[row] + 1; col < n; col++) {
                sb.append('.');
            }
            solution.add(sb.toString());
        }
        output.add(solution);
    }
    
}
```