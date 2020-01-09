```java
class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len == 0) return 0;
        if (len <= 2) return len;
        int res = 0;
        for (int i = 0; i < len; i++) { // start Pt
            
            HashMap<String, Integer> map = new HashMap<>(); // <slope, count> map
            int overlap = 0; // count of overlap Pt with Start Pt
            int maxLine = 0; // the max Pt in the line(slope);
            
            for (int j = i + 1; j < len; j++) { // end Pt
                
                int x = points[j][0] - points[i][0]; // delta x
                int y = points[j][1] - points[i][0]; // delta y
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }       
                int gcd = generateGCD(x, y); // convert delta x, y into x0, y0
                x /= gcd;
                y /= gcd;
        
                String slope = String.valueOf(x) + String.valueOf(y); // String slope as key
                int count = map.getOrDefault(slope, 0);
                map.put(slope, ++count); // add curr Pt in the line(slope)
                maxLine = Math.max(maxLine, count); // update maxLine
            }
            res = Math.max(res, maxLine + overlap + 1); // add overlap Pt and start Pt
        }
        return res;
        
    }
    private int generateGCD(int x, int y) {
        if (y == 0) return x;
        return generateGCD(y, x % y);
    }
}
```