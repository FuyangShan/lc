# Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

 ```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right != null) return height(root.right)>1? false:true;
        if (root.right == null && root.left != null) return height(root.left)>1? false:true;
        if (root.left !=null && root.right != null)
            return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(height(root.left) - height(root.right)) <= 1);
        return true;
    }
    public int height(TreeNode root){
        if (root == null) return 0;
        if (root.left == null) return height(root.right) + 1;
        if (root.right == null) return height(root.left) + 1;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right)+1;
    }
}
```
