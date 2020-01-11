# Pancake Sorting

Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.

Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

 

Example 1:

Input: [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 
Example 2:

Input: [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.

```java
//[3,2,4,1]
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int i = A.length; i > 1; i--){
            int maxIndex = largestIndex(A,i);
            reverse(A, maxIndex+1);
            reverse(A, i);
            if (maxIndex > 0) res.add(maxIndex+1);
            res.add(i);
        }
        return res;

    }
    // find the largest number index in first k elements
    public int largestIndex(int[] arr,int k){
        int max = 0;
        for (int i = 0; i < k; i++){
            if (arr[i] > arr[max]) max = i;
        }
        return max;
    }
    // reverse first k elements of arr
    public void reverse(int[] arr,int k){
        int[] temp = new int[k];
        for (int i = 0; i < k; i++){
            temp[i] = arr[i];
        }
        int j = 0;
        for (int i = k-1; i >= 0; i--){
            arr[i] = temp[j];
            j++;
        }
    }
}
```