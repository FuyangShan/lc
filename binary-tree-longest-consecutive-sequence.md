# Binary Tree Longest Consecutive Sequence
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:

Input:

   2
    \
     3
    / 
   2    
  / 
 1

Output: 2 

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.

```java
class Solution {
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        max(root, Integer.MIN_VALUE, 1);
        return max;
    }
    private void max(TreeNode root, int parent, int len) {
        if (root == null) return;
        if (root.val - parent == 1) len++;
        else len = 1;
        max = Math.max(max, len);
        if (root.left != null || root.right != null) {
            max(root.left, root.val, len);
            max(root.right, root.val, len);
        }
    }
}
```