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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = subPathSum(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }
    public int subPathSum(TreeNode root, int sum){
        if(root == null) return 0;
        int res = root.val == sum? 1:0;
        return res + subPathSum(root.left, sum - root.val) + subPathSum(root.right, sum - root.val);
    }
}