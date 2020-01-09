class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }
    private void helper(TreeNode root, String path, List<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            path += root.val + "";
            res.add(path);
        } else {
            path += root.val + "->";
            helper(root.left, path, res);
            helper(root.right, path, res);
        }
    }
}