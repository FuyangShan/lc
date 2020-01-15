public class Solution extends Reader4 {
    
    int buffPtr = 0;
    int buffCnt = 0;
    char[] buff = new char[4];
    
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            // direct write in buff from file
            if (buffPtr == 0) buffCnt = read4(buff); // Cnt letters got read
            // nothing get read, reached end of file
            if (buffCnt == 0) break;
            // write n times or read Cnt times (from last Ptr/buffPtr position)
            while (ptr < n && buffPtr < buffCnt)
                buf[ptr++] = buff[buffPtr++];
            // when buff get all read, start over
            if (buffPtr == buffCnt) buffPtr = 0;
        }
        return ptr;
    }
}
