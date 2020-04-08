Given A, B, C, find any string of maximum length that can be created such that no 3 consecutive characters are same. There can be at max A 'a', B 'b' and C 'c'.

Example 1:

Input: A = 1, B = 1, C = 6
Output: "ccbccacc"
Example 2:

Input: A = 1, B = 2, C = 3
Output: "acbcbc"

```java
// BFS (best first search)
public class Main {
    public static void main(String[] args) {
        System.out.println(longestStringWO3ConsecutiveChars(0, 1, 1));
        System.out.println(longestStringWO3ConsecutiveChars(1, 1, 1));
        System.out.println(longestStringWO3ConsecutiveChars(10, 1, 1));
        System.out.println(longestStringWO3ConsecutiveChars(15, 1, 1));
        
    }
    public static String longestStringWO3ConsecutiveChars(int A, int B, int C) {
        // rank the count of char descending
        // always append top char which has most remaining
        // try append 2 char as much as possible, if still left, add remaining back to p_queue
        PriorityQueue<Map.Entry<Character, Integer>> p_queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        Map<Character, Integer> char_map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        char_map.put('a', A);
        char_map.put('b', B);
        char_map.put('c', C);
        
        for (Map.Entry<Character, Integer> e : char_map.entrySet()) {
            if (e.getValue() > 0) p_queue.offer(e);
        }
        char pre = ' ';
        while (!p_queue.isEmpty()) {
            Map.Entry<Character, Integer> e = p_queue.poll();
            if (e.getKey() == pre) { // same with last element appended
                Map.Entry<Character, Integer> e2 = p_queue.poll();
                append(sb, e2, p_queue);
                if (e2 == null) continue; // if e is last element, finish
                pre = e2.getKey();
                p_queue.offer(e);
            } else { // different with last element appended 
                append(sb, e, p_queue); // safe to add e.key
                pre = e.getKey(); // update pre
            }
        }
        return sb.toString(); 
    }
    public static void append(StringBuilder sb, Map.Entry<Character, Integer> e, PriorityQueue<Map.Entry<Character, Integer>> p_queue) {
        if (e == null) return;
        int count = e.getValue();
        if (count > 1) { // 2 or more e.key remained
            sb.append(e.getKey()).append(e.getKey());
            count -= 2;
        } else if (count == 1) { // only 1 e.key remained
            sb.append(e.getKey());
            count--;
        }
        if (count > 0) { // only add e back to queue when still remaining
            e.setValue(count);
            p_queue.offer(e);
        }
    }
}
```


```java
// DFS
public class Main {
    public static void main(String[] args) {
        String s = longestStringWO3ConsecutiveChars(1, 1, 6);
        System.out.println(s);
    }
    static String res = "";
    public static String longestStringWO3ConsecutiveChars(int a, int b, int c) {
        
        int[] count = new int[3]; // count[0] = count_a, count[1] = count_b, count[2] = count_c;
        dfs(a, b, c, count, new StringBuilder());
        return res;
    }
    public static void dfs(int a, int b, int c, int[] count, StringBuilder sb) {
        if (a < 0 || b < 0 || c < 0 || count[0] > 2 || count[1] > 2 || count[2] > 2) return;
        if (sb.length() > res.length()) {
            res = sb.toString();
        }
        for (int i = 0; i < 3; i++) {
            sb.append((char)('a' + i));
            int[] nCount = Arrays.copyOf(count, 3);
            nCount[i]++;
            nCount[(i + 1)%3] = 0;
            nCount[(i + 2)%3] = 0;
            if (i == 0) dfs(a-1, b, c, nCount, sb);
            if (i == 1) dfs(a, b-1, c, nCount, sb);
            if (i == 2) dfs(a, b, c-1, nCount, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
```