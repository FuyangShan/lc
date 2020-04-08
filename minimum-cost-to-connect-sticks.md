# 1167. Minimum Cost to Connect Sticks

You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

 

Example 1:

Input: sticks = [2,4,3]
Output: 14
Example 2:

Input: sticks = [1,8,3,5]
Output: 30

```java
/*
    1,3,5,8
      4 5 8
        8 9
         17 
    1 * 3 + 3 * 3 + 5 * 2 + 8 * 1    

*/
class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : sticks) {
            pq.add(s);
        }
        
        int cost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            cost += (first + second);
            pq.add(first + second);
        }
        
        return cost;
    }
}
```