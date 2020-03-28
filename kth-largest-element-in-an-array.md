# 215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

```java
class Solution {
    class Tuple implements Comparable<Tuple> {
        int x,y,val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) throw new IllegalArgumentException();
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(new Tuple(i, 0, matrix[i][0]));   
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple e = pq.poll();
            if (e.y == n - 1) continue;
            pq.offer(new Tuple(e.x, e.y + 1, matrix[e.x][e.y + 1]));
        }
        return pq.poll().val;
    }
}
```