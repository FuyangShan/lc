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