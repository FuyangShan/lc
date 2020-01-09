# Pascal's Triangle

- Given a non-negative integer numRows
### Q: generate the first numRows of Pascal's triangle.
> Input: 5
> Output:
> [
>      [1],
>     [1,1],
>    [1,2,1],
>   [1,3,3,1],
>  [1,4,6,4,1]
> ]

```java

// DFS 
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(numRows, new ArrayList<Integer>(), res);
        return res;
    }
    public void recursion(int numRows, List<Integer> sol, List<List<Integer>> res){
        if (numRows == 0){
            return;
        } else {
			List<Integer> nSol = new ArrayList<>();
			// Leading '1'
			nSol.add(1);
			// skip line 1
			if (sol.size() > 0) {
				// add inner num
				for (int i = 0; i < sol.size() - 1; i++) {
					nSol.add(sol.get(i) + sol.get(i + 1));
				}
				// add tailing '1'
				nSol.add(1);
			}
			res.add(nSol);
			recursion(numRows - 1, nSol, res);
        }
    }
}

// DP
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // Add leading '1' 
            row.add(1);

            // Add inner num 
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // Add tailing '1' 
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}
```
