# Array

## Classic Questions

### Q1. Find the common numbers between two sorted arrays a[N], b[M], N, M

S1: Binary Search
	1. for each element X in the shorter array, we run a binary search in the longer array
	Time O(m * log(n))  m <<< n
	Space O(1)
S2: Store targets in shorter array 
	1. HashMap to store all elements from the shorter array, to optimize the space complexity
	2. for each element in the longer array, we check if against the hashmap
	Time O(m + n)
	Space O(min(m + n))
S3: two pointers
	1. use i to point at M, use j to point at N
	2. check i agains j
	3. increment the smaller pointer
	Time O(m + n)
	Space O(1)

## Question List

* [Array Manipulation](array-manipulation.md)
    * [27. Remove Element](remove-element.md)
    * [26. Remove Duplicates from Sorted Array](remove-duplicates-from-sorted-array.md)
    * [80. Remove Duplicates from Sorted Array II](remove-duplicates-from-sorted-array-ii.md)
    * [283. Move Zeros](move-zeroes.md)
	* [189. Rotate Array](rotate-array.md)
	* [48. Rotate Image](rotate-image.md)
    * [31. Next Permutation](next-permutation.md)
	* [56. Merge Intervals](merge-intervals.md)
	* [252. Meeting Rooms](meeting-rooms.md)
	* [253. Meeting Rooms II](meeting-rooms-ii.md)
	* [228. Summary Ranges](summary-ranges.md)
	* [163. Missing Ranges](missing-ranges.md)
    * [23. Merge K Sorted Lists](merge-k-sorted-lists.md)

* [Array State](array-state.md)
	* [277. Find the Celebrity](find-the-celebrity.md)
	* [334. Increasing Triplet Subsequence](increasing-triplet-subsequence.md)
	* [134. Gas Station](gas-station.md)
	* [169. Majority Element](majority-element.md)
	* [229. Majority Element II](majority-element-ii.md)
	* [243. Shortest Word Distance](shortest-word-distance.md)
	* [244. Shortest Word Distance II](shortest-word-distance-ii.md)
	* [245. Shortest Word Distance III](shortest-word-distance-iii.md)
	* [128. Longest Consecutive Sequence](longest-consecutive-sequence.md)
	* [11. Container With Most Water](container-with-most-water.md)
	* [42. Trapping Rain Water](trapping-rain-water.md)
	* [164. Maximum Gap](maximum-gap.md)
	* [135. Candy](candy.md)
	* [299. Bulls and Cows](bulls-and-cows.md)
    * [389. Find the Difference](find-the-difference.md)
    * [1. Two Sum](two-sum.md)
    * [167. Two Sum II](two-sum-ii-input-array-is-sorted.md)
    * [15. Three Sum](three-sum.md)
    * [18. Four Sum](four-sum.md)
	
* [Array Bucket](array-bucket.md)
	* [41. First Missing Positive](first-missing-positive.md)
	* [274. H-Index](h-index.md)
	* [275. H-Index II](h-index-ii.md)
	* [287. Find the Duplicate Number](find-the-duplicate-number.md)
	* [442. Find All Duplicates in an Array](find-all-duplicates-in-an-array.md)
	* [289. Game of Life](game-of-life.md)

* [Array Prefix](array-prefix.md)
	* [325. Maximum Size Subarray Sum Equals k](maximum-size-subarray-sum-equals-k.md)
	* [209. Minimum Size Subarray Sum](minimum-size-subarray-sum.md)
	* [238. Product of Array Except Self](product-of-array-except-self.md)
	
	* [330. Patching Array 没解决](patching-array.md)
	* [321. Create Maximum Number没解决](create-maximum-number.md)
	* [327. Count of Range Sum没解决](count-of-range-sum.md)
	* [57. Insert Interval没解决](insert-interval.md)

