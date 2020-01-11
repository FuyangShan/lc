# Count Univalue Subtrees
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4
```java
class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        isValid(root, root.val);
        return count;
    }
    private boolean isValid(TreeNode root, int parent) {
        if (root == null) return true;
        boolean left = isValid(root.left, root.val);
        boolean right = isValid(root.right, root.val);
    
        if (!left || !right) return false;
        count++;
        return root.val == parent;
    }
}
```