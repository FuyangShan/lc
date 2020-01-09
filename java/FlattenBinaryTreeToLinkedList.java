//RightToLeft Postorder
class Solution {
    TreeNode cur = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = cur;
        cur = root;
        root.left = null;
    }
}
//LeftToRight Postorder
class Solution {
    public void flatten(TreeNode root) {
        rightNode(root);
    }
    private TreeNode rightNode(TreeNode root) {
        if (root == null) return null;
        TreeNode left = rightNode(root.left);
        TreeNode right = rightNode(root.right);
        if (left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (right != null) return right;
        if (left != null) return left;
        
        return root;
    }
}