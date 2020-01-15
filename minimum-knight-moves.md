# Minimum Knight Moves

- In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

- A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

![1197](https://assets.leetcode.com/uploads/2018/10/12/knight.png)

- Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.

 

> Example 1:

> Input: x = 2, y = 1
> Output: 1
> Explanation: [0, 0] → [2, 1]

> Example 2:

> Input: x = 5, y = 5
> Output: 4
> Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]

```java
// BFS
class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        // 8 moves knight can do
        int[][] move = new int[][] {{1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};    
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        
        int len = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int curX = curr[0];
                int curY = curr[1];
                if (curX == x && curY == y) return len;
                for (int[] m : move) {
                    int nxtX = curX + m[0];
                    int nxtY = curY + m[1];
					// de-dup symmetric solutions
                    if (!visited.contains(nxtX + "," + nxtY) && (nxtX >= -1 && nxtY >= -1)) {
                        q.add(new int[] {nxtX, nxtY});
                        visited.add(nxtX + "," + nxtY);
                    }
                }
            }
            len++;
        }
        return -1;
    }
}

// DFS
class Solution {
    public int minKnightMoves(int x, int y) {
        Map<String, Integer> map=new HashMap<>();
        // base case
		map.put("0,0", 0);
		map.put("1,0", 3);
		map.put("1,1", 2);
		map.put("2,0", 2);
        return helper(x, y, map);
    }

	private int helper(int x, int y, Map<String, Integer> map) {
        // Sysmetrical of axis
		x = Math.abs(x);
		y = Math.abs(y);
        // Sysmetrical of diagonal
		if(x < y) {
			int temp = x;
			x = y;
			y = temp;
		}
		String s = x + "," + y;
		if(map.containsKey(s)) return map.get(s);
		int temp = Math.min(helper(x - 2, y - 1, map), helper(x - 1, y - 2, map)) + 1;
		map.put(s, temp);
		return temp;
	}
}
```
