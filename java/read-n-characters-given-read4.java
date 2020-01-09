//S1: use temp[]
public class Solution extends Reader4 {
    public int read(char[] buf, int n) {
        int count = 0; // returned value of each read4 call
        int total = 0; //
        char[] temp = new char[4];
        
        while (total < n) {
            count = read4(temp); // return 0~4
            count = Math.min(count, n - total); // when total exceed n, count should be leftover
            
            for (int i = 0; i < count; i++) { // write in buf from temp[]
                buf[total++] = temp[i];
            }
            if (count < 4) break; // if count is less than 4, no more to read
        }
        return total;
    }
}
//S2: Use Queue
public class Solution extends Reader4 {
    public int read(char[] buf, int n) {
        int count = 0;
        Queue<Character> q = new LinkedList<>();

        while (count <= n) {
            int r = read4(buf);
            count += r;
            for (int i = 0; i < buf.length && buf[i] != (char) 0; i++) {
                q.offer(buf[i]);
                buf[i] = (char) 0;
            }
            if (r < 4)
                break;
        }
        int i = 0;
        while (!q.isEmpty())
            buf[i++] = q.poll();
        if (count > n)
            count = n;
        return count;
    }
}
