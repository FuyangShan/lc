# Campus Bikes

- On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.

- Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike) pair with the shortest Manhattan distance between each other, and assign the bike to that worker. (If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index; if there are multiple ways to do that, we choose the pair with the smallest bike index). We repeat this process until there are no available workers.
- The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
- Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.

 

> Example 1:

![1057](https://assets.leetcode.com/uploads/2019/03/06/1261_example_1_v2.png)

> Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
> Output: [1,0]
> Explanation: 
> Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
> Example 2:


![1057-2](https://assets.leetcode.com/uploads/2019/03/06/1261_example_2_v2.png)

> Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
> Output: [0,2,1]
> Explanation: 
> Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].

```java
class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
		// Define a pq sort ascending by manhattan_dist, then worker id, lastly bikes id 
        Queue<int[]> q = new PriorityQueue<int[]>((a, b)->(a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]));
        int i = 0;
        for (int[] worker : workers) {
            int j = 0;
            for (int[] bike : bikes) {

				// throw triplets{manhattan dist, worker_id, bike_id} into pq
				q.add(new int[]{Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]), i, j++});
            }
            i++;
        }
        int[] res = new int[n];

		// note if worker was assigned with a bike (-1 = not assigned)
        Arrays.fill(res, -1);

		// note if bike was assigned to a worker
        Set<Integer> visited = new HashSet<>();

        while (visited.size() < n) {
            int[] temp = q.poll();

			// if this worker or bike was not assigned yet...
            if (res[temp[1]] == -1 && !visited.contains(temp[2])) {   

				// assing a bike to this worker
                res[temp[1]] = temp[2];

				// note this bike is assigned
                visited.add(temp[2]);
            }
        }
        return res;
    }
}
```
