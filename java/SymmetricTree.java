/* class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root, root);
    }
    public boolean isSymmetric(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }
} */


class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left) && left.val == right.val;
    }
}