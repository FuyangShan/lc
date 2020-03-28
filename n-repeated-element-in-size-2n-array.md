# N-Repeated Element in Size 2N Array
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.

 

Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2
Example 3:

Input: [5,1,5,2,5,3,5,4]
Output: 5
 

Note:

4 <= A.length <= 10000
0 <= A[i] < 10000
A.length is even

```java
class Solution {
    public int repeatedNTimes(int[] A) {
        int candidate1 = A[0];
        int candidate2 = A[1];
        
        if (candidate1 == candidate2) return candidate1;
        
        for (int i = 2; i < A.length; i++) {
            if (A[i] == candidate1 || A[i] == candidate2) {
                return A[i];
            } else {
                candidate2 = A[i];
                candidate1 = candidate2;
            }
        }    
        return candidate1;
    }
}


class Solution {
    public int repeatedNTimes(int[] A) {
        Set setA = new HashSet();
        for (int i: A){
            setA.add(i);
            if (setA.contains(i)) return i;
        }
        return -1;
    }
}
```