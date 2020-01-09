# Pascal's Triangle II
- Given a non-negative index k where k ≤ 33, 
### Q:return the kth index row of the Pascal's triangle.

- Note that the row index starts from 0.
> Input: 3
> Output: [1,3,3,1]
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
    public List<Integer> getRow(int rowIndex) {
        List<Integer> sol = new ArrayList<>();
        sol.add(1); // row index starts from 0
        return recursion(rowIndex, sol);
    }
    public List<Integer> recursion(int rowIndex, List<Integer> sol){
        if (rowIndex == 0){
            return sol;
        } else {
			// construct new line
            List<Integer> nSol = new ArrayList<>();
			// add leading '1'
            nSol.add(1);
			// add internal nums
            for (int i = 0; i < sol.size() - 1; i++){
                nSol.add(sol.get(i) + sol.get(i + 1));
            }
			// add tailing '1'
            nSol.add(1);
			// recursively return last row
            return recursion(rowIndex - 1, nSol);
        }
    }
}
```
