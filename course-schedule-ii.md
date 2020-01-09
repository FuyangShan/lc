```java
// Topo Sort
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[]{}; // corner case
        int[] indegree = new int[numCourses]; // how many pre is required for the course;
        int[] order = new int[numCourses]; // order of number of course;
        int index = 0;
        Queue<Integer> q = new LinkedList<>(); // Queue to store non pre-required course;
        for (int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++; // in the pre requirements, add 1 if the course need 1 another pre;
        }
        
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                order[index++] = i; // Add the non pre-required course to the order;
                q.add(i); // add the number of the non pre-requried course to Queue;
            }
        }
        while (!q.isEmpty()){
            int pre = q.poll(); // the current 1st completed course from non pre-required course Queue;
            for (int i = 0; i < prerequisites.length; i++){
                if (prerequisites[i][1] == pre){ // from the pre requirement list, find the course needing "pre" as pre;
                    indegree[prerequisites[i][0]]--; // Completed one for pre for course;
                    if (indegree[prerequisites[i][0]] == 0){ // if all pre are completed for the course;
                        order[index++] = prerequisites[i][0]; // add the completed course to order
                        q.add(prerequisites[i][0]); // add the completed course to non pre-required  course list.
                    }
                }
            } // when all non pre-required courses are completed, exit while.
        }
        return (index==numCourses)? order: new int[0]; // if all courses has been completed, then the order contains all courses in order
    }
}
```