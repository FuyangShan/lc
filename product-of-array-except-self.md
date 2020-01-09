# Product of Array Except Self

- Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

> Example:

> Input:  [1,2,3,4]
> Output: [24,12,8,6]
```java
//2 passes
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        //store prod of left in res first
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1]; 
        }
        int right = 1;
        //update res by multiple all right element
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}

//3 passes
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(l, 1);
        Arrays.fill(r, 1);
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = l[i] * r[i];
        }
        
        return res;
    }
}
```
