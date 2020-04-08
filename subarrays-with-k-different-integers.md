# 992. Subarrays with K Different Integers

Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.

 

Example 1:

Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
Example 2:

Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Note:

1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length

```java
/*
    maintain two sliding window, 
    add element at right index into windows
    
    window 1 store K distinct elements
    window 2 store K-1 distinct elements
    
    if window1 has K+1 elements, remove left1, and slide left1
    if window2 has K elements, remove left2, and slide left2
    
    if left2-left1 > 0, left2 pointing to 1st Kth element
    so substring[left1,....left2] are good, there are total left2-left1 substring
    
    
*/


class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int right = 0;
        int left1 = 0, left2 = 0, res = 0;
        Window w1 = new Window();
        Window w2 = new Window();
        for (; right < A.length; right++) {
            int cur = A[right];
            w1.add(cur);
            w2.add(cur);
            
            while (w1.dist() > K)
                w1.remove(A[left1++]);
            while (w2.dist() >= K) 
                w2.remove(A[left2++]);
            
            res += left2 - left1;
        }
        return res;
    }
}

class Window {
    Map<Integer,Integer> map;
    int exist;
    
    public Window() {
        map = new HashMap<>();
        exist = 0;
    }
    
    public void add(int n) {
        map.put(n, map.getOrDefault(n, 0) + 1);
        if (map.get(n) == 1) exist++;
    }
    public void remove(int n) {
        map.put(n, map.get(n) - 1);
        if (map.get(n) == 0) exist--;
    }
    public int dist() {
        return exist;
    }
}
```