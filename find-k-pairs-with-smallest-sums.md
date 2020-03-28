# 373. Find K Pairs with Smallest Sums

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]


```java
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> que = new PriorityQueue<>((a,b)->a.get(0)+a.get(1)-b.get(0)-b.get(1));
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) {
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[0]);
            pair.add(0);
            que.offer(pair);
        }
        while(k-- > 0 && !que.isEmpty()){
            List<Integer> cur = que.poll();
            List<Integer> sol = new ArrayList<>();
            sol.add(cur.get(0));
            sol.add(cur.get(1));
            res.add(sol);
            if(cur.get(2) == nums2.length-1) continue;
            List<Integer> next = new ArrayList<>();
            next.add(cur.get(0));
            next.add(nums2[cur.get(2) + 1]);
            next.add(cur.get(2) + 1);
            que.offer(next);
        }
        return res;
    }
}
```