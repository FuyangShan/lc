# Count of Smaller Numbers After Self
- You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

> Example:

> Input: [5,2,6,1]
> Output: [2,1,1,0]
> Explanation:
> To the right of 5 there are 2 smaller elements (2 and 1)
> To the right of 2 there is only 1 smaller element (1)
> To the right of 6 there is 1 smaller element (1)
> To the right of 1 there is 0 smaller element


```java
class Node {
	// build BST
	Node left, right;
	// leftSum = total nodes in left-subtree
	// dup = how many duplicated node was visited
	int val, leftSum = 0, dup = 0;
	public Node(int val) {
		this.val = val;
	}
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		Integer[] res = new Integer[n];
		if (n == 0) return Arrays.asList(res);

		// initialize a root
		Node root = new Node(nums[n - 1]);

		// insert node from end of nums
		for (int i = n - 1; i >= 0; i--) {
			res[i] = insert(root, nums[i]);
		}

		return Arrays.asList(res);
    }

	private int insert(Node root, int num) {
		int sum = 0;

		while (root.val != num) {
			// num insert to left-subtree
			if (root.val > num) {
				root.leftSum++;
				if (root.left == null) root.left = new Node(num);
				root = root.left;
			// num insert to right-subtree
			} else {
				sum += root.leftSum + root.dup;
				if (root.right == null) root.right = new Node(num);
				root = root.right;
			}
		}
		// update root.dup for each insertion
		root.dup++;
		// all visited sum + curr root's leftSum
		return sum + root.leftSum;
	}
}
```
