```java
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        // (minX, minY) -> (maxX, maxY)
        int area = 0;
        HashSet<String> set = new HashSet<>();
        
        for (int[] rect : rectangles) {
            
            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);
            
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            String s1 = rect[0] + " " + rect[1]; //left-bot corner Pt
            String s2 = rect[0] + " " + rect[3]; //right-bot corner Pt
            String s3 = rect[2] + " " + rect[1]; //left-top corner Pt
            String s4 = rect[2] + " " + rect[3]; //right-top corner Pt
            
            if (!set.add(s1)) set.remove(s1); // add if not exist, remove if exist -> validate it's even occuring
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }
        
        if (set.contains(minX + " " + minY) && // four corner Pt should remain unremoved
            set.contains(minX + " " + maxY) &&
            set.contains(maxX + " " + minY) &&
            set.contains(maxX + " " + maxY) &&
            set.size() == 4 && // only four are remaining
            area == (maxX - minX) * (maxY - minY)
           ) return true;
        
        return false;
    }
}
```
