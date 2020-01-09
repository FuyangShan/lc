/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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