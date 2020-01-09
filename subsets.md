```java
// S1 : DFS backtrack
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    public void backtrack(int[] nums, int start, List<Integer> sol, List<List<Integer>> res){
        res.add(new ArrayList<>(sol));
        for (int i = start; i < nums.length; i++){
            sol.add(nums[i]);
            backtrack(nums, i + 1, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}
// S2 : BFS
class Solution {
    public List<List<Integer>> subsets_BFS(int[] nums) {
        if(nums == null || nums.length <= 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>(); 
        queue.offer(new ArrayList<Integer>());

        for(int i=0; i<nums.length; i++){
            int levelSize = queue.size();
            for(int j=0; j<levelSize; j++){
                List<Integer> polled = queue.poll();
                //Left child - Reuse parent's array list obj
                List<Integer> leftChild = polled;
                queue.offer(leftChild);
                //Left child has reused the parent's arraylist.. So right child creates a new copy
                List<Integer> rightChild = new ArrayList<>(polled);
                rightChild.add(nums[i]);
                queue.offer(rightChild);
            }	
        }
        res.addAll(queue);
        return res;
    }
}
```