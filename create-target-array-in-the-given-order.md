# 1389. Create Target Array in the Given Order

Given two arrays of integers nums and index. Your task is to create target array under the following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.

```java
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        // insert nums[i] at index index[i];
        for (int i = 0; i < index.length; i++) {
            for (int j = 0; j < i; j++) {
                if (index[j] >= index[i]) index[j]++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[index[i]] = nums[i];
        }
        return res;
    }
}

```