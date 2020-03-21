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
