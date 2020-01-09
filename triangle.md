# Triangle
- Given a triangle
### Q: find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

> example, given the following triangle
> [
>      [2],
>     [3,4],
>    [6,5,7],
>   [4,1,8,3]
> ]
> 2 + 3 + 5 + 1 = 11

```java
// o(n^2) space
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
		int n = triangle.get(m - 1).size();
		// f[i][j] = minimum total sum within triangle (i,j) to (m, n)
		int[][] f = new int[m + 1][n + 1];
		for (int j = 0; j <= n; j++) {
			f[m][j] = 0;
		}
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
			}
		}

		return f[0][0];
    }
}



// O(n) space
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
		int m = triangle.size();
		// f[i] = minimum total path for first i rows
        int[] f = new int[m + 1];

        for (int i = m - 1; i >= 0; i--){
			int n = triangle.get(i).size();
            for (int j = 0; j < n; j++){
                f[j] = Math.min(f[j], f[j + 1]) + triangle.get(i).get(j);
            }
        }
        return f[0];
    }
}
```
