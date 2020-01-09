```java
//1st Method
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while(lo + 1 < hi){
            int mid = lo +(hi - lo) / 2;
            if (guess(mid) > 0) {
                    lo = mid;
            } else if (guess(mid) < 0) {
                    hi = mid;
            } else {
                    return mid;
            }
        }
        return guess(lo) == 0 ? lo : hi;
    }
}
    
//2nd method
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        int mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == 1) lo = mid + 1;
            else hi = mid;
        }
        return lo;        
    }
}
```