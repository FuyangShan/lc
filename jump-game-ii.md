# Jump Game II
>Input: [2,3,1,1,4]
>Output: 2
>Explanation: The minimum number of jumps to reach the last index is 2.
>Jump 1 step from index 0 to 1, then 3 steps to the last index.

```java

// DP
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // f[i] = minimum jumps to get to nums[i]
        int[] f = new int[n];
        // init
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            f[i] = Integer.MAX_VALUE;
            // enumerate from 0 to i-1
            for (int j = 0; j < i; j++) {
                // f[i] = Max{f[j] + 1 | f[j] != MAX_VALUE && nums[j] > i-j}
                if (f[j] < Integer.MAX_VALUE && nums[j] >= i - j) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n - 1];
    }
}

// DP in place
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int reachable = 0;
        int step = 0;
        int start = 0;
        while (reachable < nums.length - 1){
            int range = reachable;
            for (int i = start; i <= range; i++){
                reachable = Math.max(reachable, i + nums[i]);
            }
            start = range + 1;
            step++; 
        }
        return step;
    }
}

// BFS
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int steps = 0;
        set.add(0);
        q.add(0);
        while (!q.isEmpty()){
            int size = q.size();
            steps++;
            for (int i = 0; i < size; i++){
                int index = q.poll();
                if (nums.length - 1 - index <= nums[index]) return steps;
                for (int j = 1; j <= nums[index]; j++){
                    if (!set.contains(index + j) && index + j < nums.length){
                        set.add(index + j);
                        q.add(index + j);
                    }
                }
            }
        }
        return steps;
    }
}


```