//1st method

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
    
//2nd Method
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                    right = mid;
            } else {
                    left = mid + 1;
            }
        }
        return left;
    }     
}
    