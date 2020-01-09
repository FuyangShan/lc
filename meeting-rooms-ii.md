# Meeting Rooms II
- Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

> Example 1:

> Input: [[0, 30],[5, 10],[15, 20]]
> Output: 2
> Example 2:

> Input: [[7,10],[2,4]]
> Output: 1

```java

// sort and iteration
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        //sort start time and end time
        Arrays.sort(starts);
        Arrays.sort(ends);
        int sum = 0;
        int j = 0;
        //meeting starts chronologically
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[j]) { //if new meeting starts early than 1st meeting ends, then open a new meeting room
                sum++;
            } else { //if new meeting starts later than 1st meeting ends, no need to open a new one.
                j++; //1st meeting room was taken by this new meeting, so next available room should now be examined
            }
        }
        return sum;
    }
}

//minHeap
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        //sort by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        //construct a minHeap to add meetings, using ending time as key
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(intervals[0]);
        
		// meeting starts chronogically
        //if new meeting starts later than the 1st meeting room end time, then the 1st meeting is free, no need to open a new meeting.
        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek()[1] <= intervals[i][0]) pq.poll();
            pq.offer(intervals[i]);
        }

        //return how many meeting rooms were opened
        return pq.size();
    }
}

```
