class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int lo = 0;
        int hi = n;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // if (citations[mid] == n - mid) return n - mid;
            if (citations[mid] < n - mid) lo = mid + 1;
            else hi = mid;
        }
        return n - lo;
    }
}
