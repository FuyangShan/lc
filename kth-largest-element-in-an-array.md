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