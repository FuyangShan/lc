# Paint House II
- There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

- The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...

### Q: Find the minimum cost to paint all houses.

- Note:
- All costs are positive integers.

> Example:

> Input: [[1,5,3],[2,9,4]]
> Output: 5
> Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
> Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5. 

```java
// DP in place
class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        // min1, min2 = the 1st-least, 2nd-least cost to paint the current house
        int min1 = -1, min2 = -1;
    
        for (int i = 0; i < n; i++) {
            // cache the last color of 1st, 2nd least costs to paint previous houses
            int last1 = min1, last2 = min2;
            
            for (int j = 0; j < k; j++) {
                
                if (j != last1) { // we can paint last house 'last1' color
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else { // we can paint last house 'last2' color
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }
                
                // find the color of 1st, 2nd least costs to paint the current house i
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        return costs[costs.length - 1][min1];
    }
}
```
