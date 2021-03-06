# 378. Kth Smallest Element in a Sorted Matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
```java
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for (int i = 0; i < n; i++){
            pq.offer(new Tuple(0,i,matrix[0][i]));
        }
        for (int j = 0; j < k - 1; j++){
            Tuple t = pq.poll();
            if (t.x == n - 1) continue;
            pq.offer(new Tuple(t.x+1,t.y,matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }
}
class Tuple implements Comparable<Tuple>{
    int x, y,val;
    public Tuple(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
    public int compareTo(Tuple that){
        return this.val - that.val;
    }
}
```