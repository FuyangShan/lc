# 1086. High Five

https://leetcode.com/problems/high-five/

Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.

Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.

 

Example 1:

Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation: 
The average of the student with id = 1 is 87.
The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 

Note:

1 <= items.length <= 1000
items[i].length == 2
The IDs of the students is between 1 to 1000
The score of the students is between 1 to 100
For each student, there are at least 5 scores

```java
class Solution {
    public int[][] highFive(int[][] items) {
        // find top 5 scores of each student, and return the result
        // use <id, score_queue> to store the all items
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            // create a score queue for student(id);
            if (!map.containsKey(id)) map.put(id, new PriorityQueue<Integer>());
            PriorityQueue<Integer> q = map.get(id);
            q.add(score);
            if (q.size() > 5) q.poll(); // if we have 6 scores, poll the smallest one
        }
        
        int n = map.size(); // we have total n students
        int[][] result = new int[n][2];
        
        // iterate each record to get average of student(key) in the record Map
        for (Map.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()) {
            int sum = 0;
            while (!e.getValue().isEmpty()) {
                sum += e.getValue().poll();
            }
            result[e.getKey() - 1][0] = e.getKey();
            result[e.getKey() - 1][1] = sum / 5;
        }
        return result;
    }
}
```