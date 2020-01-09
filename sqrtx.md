```java
//初始边界为1和 x / 2, corner case是x == 1时

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int lo = 1, hi = x / 2, mid = 0;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (mid < x / mid) lo = mid;
            else hi = mid;
        }
        return hi <= x / hi ? hi : lo;
    }
}
```