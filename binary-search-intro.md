# Binary Search

- 参考模版：
- https://segmentfault.com/a/1190000016825704


```java
// 标准模版
class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

// 左边界
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}

// 左边界（有重复元素）
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left] == target ? left : -1;
    }
}

// 万能
class Solution {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid;
			} else {
				right = mid;
			} else {
				// depend on intent when find target
			}
		}
		// post processing
		if (nums[left] == target) {
			return left;
		} else if (nums[right] == target) {
			return right;
		} else {
			return -1;
		}
	}
}


```

### 代表例题

* [374. Guess Number Higher or Lower](guess-number-higher-or-lower.md)
* [278. Find the first bad version](first-bad-version.md)
* [162.	Find Peak Element](find-peak-element.md)
* [34. Find First and Last Position of Element in Sorted Array](find-first-and-last-position-of-element-in-sorted-array.md)
* [33. Search in Rotated Sorted Array](search-in-rotated-sorted-array.md)
* [81. Search in Rotated Sorted Array II](search-in-rotated-sorted-array-ii.md)
* [69. sqrt(x)](sqrtx.md)
* [153. Find Minimum in Rotated Sorted Array](find-minimum-in-rotated-sorted-array.md)
* [154. Find Minimum in Rotated Sorted Array II](find-minimum-in-rotated-sorted-array-ii.md)
* [475. Heaters](heaters.md)
* [74. Search a 2D Matrix](search-a-2d-matrix.md)
* [240. Search a 2D Matrix II](search-a-2d-matrix-ii.md)
* [4. Median of Two Sorted Arrays](median-of-two-sorted-arrays.md)
* [162. Find Peak Element](find-peak-element.md)
* [35. Search Insert Position](search-insertion-position.md)
* [350. Intersection of Two Arrays II]()
