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