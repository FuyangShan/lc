# 347. Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

```java
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap();

        for (int n:nums){
            count.put(n,count.getOrDefault(n, 0)+1);

        }
        PriorityQueue<Integer> myHeap = new PriorityQueue<>((x,y)->(count.get(x) - count.get(y)));
        for (int key:count.keySet()){
            myHeap.add(key);
            if (myHeap.size() > k){
                myHeap.poll();
            }  
        }
        List<Integer> myList = new ArrayList();
        while (!myHeap.isEmpty())
            myList.add(myHeap.poll());
        Collections.reverse(myList);
        return myList;
    }
}
```