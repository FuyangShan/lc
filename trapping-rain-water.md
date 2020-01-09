# Trapping Rain Water
- Given n non-negative integers representing an elevation map where the width of each bar is 1
### Q: compute how much water it is able to trap after raining.

> Example:
> Input: [0,1,0,2,1,0,1,3,2,1,2,1]
> Output: 6

```java
//DP
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int res = 0;
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}

//Two Pointers
class Solution {
    public int trap(int[] height) {
        int total = 0, maxLeft = 0, maxRight = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                if (height[i] < maxLeft) total += maxLeft - height[i];
                else maxLeft = height[i];
                i++;
            } else {
                if(height[j] < maxRight) total += maxRight - height[j];
                else maxRight = height[j];
                j--;
            }
        }
        return total;
    }
}
```
