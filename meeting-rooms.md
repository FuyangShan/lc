# Meeting Rooms

- Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

> Example 1:

> Input: [[0,30],[5,10],[15,20]]
> Output: false

> Example 2:

> Input: [[7,10],[2,4]]
> Output: true

```java
// sort and traverse
public boolean canAttendMeetings(Interval[] intervals) {
  if (intervals == null)
    return false;

  // Sort the intervals by start time
  Arrays.sort(intervals, new Comparator<Interval>() {
    public int compare(Interval a, Interval b) { return a.start - b.start; }
  });
  // meeting starts chronologically, verify if there is overlap
  for (int i = 1; i < intervals.length; i++)
    if (intervals[i].start < intervals[i - 1].end)
      return false;
  
  return true;
}

// sort with Binary Search
class Solution {
     public boolean canAttendMeetings (int[][] intervals) {
        int n = intervals.length;
        sort(intervals, 0, n - 1);
        
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
                
        }
        return true;
    }
    
    private void sort (int[][] a, int start, int end) {
        if (start > end) {
            return;
        }
        int s = start;
        int e = end;
        int p = start + (end - start) / 2;
        int median = a[p][0];
        
        while (s < e) {
            while (a[s][0] < median) {
                s++;
            }
            while (median < a[e][0]) {
                e--;
            }
            if (s <= e) {
                int[] t = a[s];
                a[s] = a[e];
                a[e] = t;
                s++;
                e--;
            }
        }
        if (s < end) {
            sort(a, s, end);
        }
        if (start < e) {
            sort(a, start, e);
        }
    }
}
```
