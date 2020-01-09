# Merge Intervals
- Given a collection of intervals, merge all overlapping intervals.

> Example 1:

> Input: [[1,3],[2,6],[8,10],[15,18]]
> Output: [[1,6],[8,10],[15,18]]
> Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
> Example 2:

> Input: [[1,4],[4,5]]
> Output: [[1,5]]
> Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        //Sort the 2d array;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0]);
            }
        }); 
        //Two Pointers, override in place
        int slow = 0;
        for (int fast = 1; fast < intervals.length; fast++) {
            //no overlap
            if ((intervals[slow][0] - intervals[fast][1]) * (intervals[slow][1] - intervals[fast][0]) > 0) {
                intervals[++slow][0] = intervals[fast][0];
                intervals[slow][1] = intervals[fast][1];
            } else {
                //overlap
                intervals[slow][0] = Math.min(intervals[slow][0], intervals[fast][1]);
                intervals[slow][1] = Math.max(intervals[slow][1], intervals[fast][1]);
            }
        }
        
        //return index 0 - slow
        return Arrays.copyOfRange(intervals, 0, slow + 1);
    }
}
```
