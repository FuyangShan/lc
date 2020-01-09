```java
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 0) return -1;
        int lo = 1, hi = n;
        int mid = 0;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (!isBadVersion(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return isBadVersion(lo) ? lo : hi;
    }
}
```
    