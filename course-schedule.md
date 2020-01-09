```java
//BFS
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 ||prerequisites.length == 0) return true;
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0)
                q.add(i);
        }
        int canFinishCount = q.size();
        while (!q.isEmpty()){
            int prerequisite = q.poll();
            for (int i = 0; i < prerequisites.length; i++){
                if (prerequisites[i][1] ==  prerequisite){
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0){
                        canFinishCount++;
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return (canFinishCount == numCourses);
    }
}

//DFS
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        boolean[] finished = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<Integer>();
        for (int[] pre : prerequisites){
            graph[pre[1]].add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++){
            if (!dfs(graph, finished, visited, i)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(ArrayList<Integer>[] graph, boolean[] finished, boolean[] visited, int course) {
        if (finished[course]){
            return true;
        } else if (visited[course]) {
            return false;
        } else {
            visited[course] = true;
        }

        for (int i = 0; i < graph[course].size(); i++){
            if (!dfs(graph, finished, visited, graph[course].get(i))){
                return false;
            }
        }
        finished[course] = true;
        return true;
    }
}
```


