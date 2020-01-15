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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null) return q == null;
        if (q == null) return p == null;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
}
