```java
class Solution {
    public String generateNewCode(String curCode, int position, int dir) {
        char [] c = curCode.toCharArray();    //[‘0’, ‘0’, ‘0’, ‘0’]
        int oldC = c[position] - '0';                  
        int newC = oldC + dir;   // 1 - >2,,,,1 - >0 // 0 - 1 = -1
        newC %= 10;
        c[position] = (char)newC;  
        //generate my char array to string
        return new String(c);
    }
    public int openLock(String[] deadends, String target) {
    // use to quickly check if the node is in deadends : O(1)
        Set<String> dde = new HashSet<String>();
        for(int i = 0; i < deadends.length; i++) {
            dde.add(deadends[i]);
        }

        String origin = "0000";
        Queue<String> q = new LinkedList<String>();
        if (target.equals(origin)) {
            return 0;
        } else if (dde.contains(origin)) {
            return -1;
        }

        Set<String> visited = new HashSet<String>();

        q.offer(origin);
        visited.add(origin);

        int result = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            result++;
            while (n > 0) {
                String cur = q.poll();
                int[] det = new int[]{ 1, -1};
                // 1: 0 -> 1 , 1->2...
                // - 1: 0->9 , 1- >0...
                for(int i = 0; i < 4; i++) {
                    for(int d = 0; d < 2; d++) {
                        //det[d] with position i in String
                        String newCode = generateNewCode(cur, i, det[d]);

                        //meet the target: return result;
                        if(newCode.equals(target)) return result;
                        if(dde.contains(newCode)) continue;
                        if(visited.contains(newCode)) continue;
                
                        q.offer(newCode);
                        visited.add(newCode);
                    }
                }
                n--;
            }
        }
        return -1;
    }
}
```