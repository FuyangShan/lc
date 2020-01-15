class Solution {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return "";
        if (k == 0) return s;
        
        // <c, freq>
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        // descending freq of Characters pq<c, freq>
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        
        // result stringbuilder
        StringBuilder sb = new StringBuilder();
        
        // appended entry to be added to wait queue
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();   
        
        for (int i = 0; i < s.length(); i++) {
            // when i not reach end yet, but pq is empty
            if (pq.isEmpty()) return "";
            // get the first entry in pq
            Map.Entry<Character, Integer> curr = pq.poll();
            // append c in sb
            sb.append(curr.getKey());
            // reduce the freq of c by 1
            curr.setValue(curr.getValue() - 1);
            // add the entry to waitQueue
            waitQueue.offer(curr);
            // when k elements get appended in sb and added in wait queue
            if (waitQueue.size() == k) {
                Map.Entry<Character, Integer> front = waitQueue.poll();
                if (front.getValue() > 0) pq.offer(front);
            }
        }
        
        return sb.toString();

    }
}