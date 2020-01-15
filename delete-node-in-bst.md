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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else 
        {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    public int minValue(TreeNode root){
        int minv = root.val;
        while(root.left != null){
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }
}