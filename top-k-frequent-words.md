# Top K Frequent Words
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.


```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        //maxHeap 从高频到低频
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            //String a = new element, String b = passed element
            public int compare(String a, String b) {
                //if freq_A = freq_B -> order_A.compareTo(order_B)
                return map.get(b) == map.get(a) ? a.compareTo(b) : map.get(b) - map.get(a); //return 1 to sift down  otherwise -1 to sift up.
            }
        });

        for (String s : map.keySet()) {
            pq.offer(s);
        }
            
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }
}
```