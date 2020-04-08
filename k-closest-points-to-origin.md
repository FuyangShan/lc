# 973. K Closest Points to Origin

https://leetcode.com/problems/k-closest-points-to-origin/

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)



```java

/*
Solution1:
   [1,3],[-2,2]  k = 1
   
   1. Maintain a size K maxHeap to store points, farthest point (away from (0,0)) are always to be the top of pq.
   2. if maxHeap more than full (size k + 1), poll the top out
   3. after scanning all points, the remaining K points are closest points to (0,0)

*/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // maxHeap sorted by euclidean distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (
            b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]
        ));
        
        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > K) pq.poll();
        }
        
        int[][] res = new int[K][2];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            res[i][0] = p[0];
            res[i++][1] = p[1];
        }
        
        return res;
    }
}


/*
Solution2:
    Quick Partition: sort the array so first K elements are sorted ascending
    1. in the array, randomly pick a pivot index from start to the end
    2. swap start and pivot
    3. shift all element smaller or equal to pivot distance to prior pivot, shift all element larger than pivot distance to after pivot
    4. get the updated index of pivot to be mid
    5. if start-to-mid is longer than K, then we only need to sort array[start...mid-1] for first K elements
    6. if start-to-mid is shorter than K, then we only need to sort array[mid+1, end] for first K - leftLen elements
*/
import java.util.concurrent.ThreadLocalRandom;

class Solution {
    int[][] points;
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        sort(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void sort(int i, int j, int K) {
        if (i >= j) return;
        int k = ThreadLocalRandom.current().nextInt(i, j);
        swap(i, k);

        int mid = partition(i, j);
        int leftLength = mid - i + 1;
        if (K < leftLength)
            sort(i, mid - 1, K);
        else if (K > leftLength)
            sort(mid + 1, j, K - leftLength);
    }

    public int partition(int i, int j) {
        int oi = i;
        int pivot = dist(i);
        i++;

        while (true) {
            while (i < j && dist(i) <= pivot)
                i++;
            while (i <= j && dist(j) > pivot)
                j--;
            if (i >= j) break;
            swap(i, j);
        }
        swap(oi, j);
        return j;
    }

    public int dist(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
}
```