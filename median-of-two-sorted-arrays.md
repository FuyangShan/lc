# Median Of Two Sorted Array

- There are two sorted arrays nums1 and nums2 of size m and n respectively.

### Q: Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

- You may assume nums1 and nums2 cannot be both empty.

> Example 1:

> nums1 = [1, 3]
> nums2 = [2]

> The median is 2.0
> Example 2:

> nums1 = [1, 2]
> nums2 = [3, 4]

> The median is (2 + 3)/2 = 2.5

```java
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (getKth(A, 0, B, 0, left) + getKth(A, 0, B, 0, right)) / 2.0;
    }
    private int getKth(int[] A, int aStart, int[] B, int bStart, int k) {

        //base case: A is exhausted or B is exhausted, return the index k - 1 of other array, starting from "start"
        if (aStart >= A.length) return B[bStart + k - 1];
        if (bStart >= B.length) return A[aStart + k - 1];

        // corner case: find the 1st element, since A, B are both sorted, return the smaller 1st element.
        if (k == 1) return Math.min(A[aStart], B[bStart]);
        
        // compare the mid of arrays, e.g. to find the 7th element of merged array, compare 3rd element of each array
        // x x aMid x x x x x...
        // o o bMid o o o o o...
        int aMid = aStart + k / 2 - 1;
        int bMid = bStart + k / 2 - 1;

        // if mid exceed array range, then keep the array, it's safe to lose left half of other array.
        // if mid is within both array, then compare both mid
        int aVal = aMid >= A.length ? Integer.MAX_VALUE : A[aMid];
        int bVal = bMid >= B.length ? Integer.MAX_VALUE : B[bMid];

        // recursively abandon half of the array because that half must be in the left.
        // e.g. aVal < bVal:
        // recursive see the following:
        // x x x aVal x x x ...
        //    o o o bVal o o o ...
        if (aVal < bVal) return getKth(A, aMid + 1, B, bStart, k - k / 2);
        else return getKth(A, aStart, B, bMid + 1, k - k / 2);
    }
}
```
