# Intersection of Two Arrays
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> mySet = new HashSet();
        Set<Integer> newSet = new HashSet();
        List<Integer> resList = new ArrayList();
        for (int num:nums1){
            mySet.add(num);
        }
        for (int num:nums2){
            if (mySet.contains(num)){
                newSet.add(num);
            }
        }
        for (int i:newSet){
            resList.add(i);
        }
        int[] finalList =new int[resList.length];
        for (int i = 0;i<resList.length;i++){
            finalList[i] = resList[i];
        }
        return finalList;
    }
}
```