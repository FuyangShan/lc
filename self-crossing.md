```java
class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x.length <= 3) return false;
        for (int i = 3; i < x.length; i++) {
            // line(i) never cross line(i - 1)
            // line(i) never overlap line(i - 2)
            // line(i) could cross line(i - 3)
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
            // line(i) could overlap line(i - 4)
            else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) return true;
            // line(i) could cross line(i - 5)
            else if (i >= 5 && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]) return true;
        }
        return false;
    }
}
```