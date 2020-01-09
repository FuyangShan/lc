# Largest Number
- Given a list of non negative integers, arrange them such that they form the largest number.

> Example 1:

> Input: [10,2]
> Output: "210"
> Example 2:

> Input: [3,30,34,5,9]
> Output: "9534330"

```java
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        //pq to rearrange the sequence by customized comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String ab = a + "" + b;
                String ba = b + "" + a;
                return ba.compareTo(ab);
            }
        });
        //add numbers in pq
        for (int i : nums) pq.offer(i);
        //if it's all 0, return "0"
        String res = "";
        if (pq.peek() == 0) return "0";
        //poll and add numbers as string at back of result
        while (!pq.isEmpty()) res += pq.poll();
        
        return res;
    }
}
```
