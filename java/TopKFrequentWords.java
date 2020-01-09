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