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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.val <= max(root.left).val) return false;
        if (root.right != null && root.val >= min(root.right).val) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
    public TreeNode min(TreeNode root){
        while (root.left != null) root = root.left;
        return root;
    }
    public TreeNode max(TreeNode root){
        while (root.right != null) root = root.right;
        return root;
    }
}