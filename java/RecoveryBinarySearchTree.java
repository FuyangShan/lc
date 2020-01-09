/* class Solution {
    private static TreeNode first,second,pre;
    public void recoverTree(TreeNode root){
        recover(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void recover(TreeNode root) {
        if (root == null) return;
        recover(root.left);
        if (pre != null && pre.val > root.val){
            if (first == null) first = pre;
            second = root;
        } else if (first != null && first.val < root.val){
            return;
        }
        pre = root;
        recover(root.right);
    }
} */

class Solution {
    public void recoverTree(TreeNode root) {
        recover(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode recover(TreeNode root, int from, int to){
        if (root == null) return root;
        int val = root.val;
        if (val < from || val > to) return root;
        TreeNode left = recover(root.left, from, val-1);
        if (left != null) {
            if (left.val < from || left.val > to){
                return left;
            } else {
                root.val = left.val;
                left.val = val;
                return recover(root, from, to);
            }
        }
        val = root.val;
        TreeNode right = recover(root.right, val+1, to);
        if (right != null){
            if (right.val < from || right.val > to){
                return right;
            } else {
                root.val = right.val;
                right.val = val;
                return recover(root, from, to);
            }
        }
        return null;
    }
}