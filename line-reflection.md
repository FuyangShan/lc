```java
class Solution {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            set.add(point[0] + "#" + point[1]); // hash int[]
        }
        int sum = max + min;
        for (int[] point : points) {
            if (!set.contains((sum - point[0]) + "#" + point[1]))
                return false;
        }
        return true;
    }
}
```