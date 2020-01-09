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