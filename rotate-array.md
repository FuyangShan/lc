# Rotate Array
- Given an array, rotate the array to the right by k steps, where k is non-negative.

> Example 1:

> Input: [1,2,3,4,5,6,7] and k = 3
> Output: [5,6,7,1,2,3,4]
> Explanation:
> rotate 1 steps to the right: [7,1,2,3,4,5,6]
> rotate 2 steps to the right: [6,7,1,2,3,4,5]
> rotate 3 steps to the right: [5,6,7,1,2,3,4]
> Example 2:

> Input: [-1,-100,3,99] and k = 2
> Output: [3,99,-1,-100]
> Explanation:
> rotate 1 steps to the right: [99,-1,-100,3]
> rotate 2 steps to the right: [3,99,-1,-100]

```java
// shift
class Solution {
    public void rotate(int[] nums, int k) {
        while (k > 0){
            int last = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--){
                nums[i + 1] = nums[i];
            }
            nums[0] = last;
            k--;
        }
    }
}
// copy
class Solution{
    public void rotate(int[] nums, int k){
        int n = nums.length; 
        int[] copyNums = new int[n];
        for (int i = 0;i<n;i++){
            copyNums[i] = nums[i];
        }
        for (int i = 0;i < n;i++){
            nums[(i + k)%n] = copyNums[i]; 
        }
    }
}
// cyclic replacement
class Solution{
    public void rotate(int[] nums, int k){
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++){
            int current = start;
            int prev = nums[start];
            do{
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
```
