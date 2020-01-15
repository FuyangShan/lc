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
    public int largestBSTSubtree(TreeNode root) {
        int[] res = largestBST(root);
        return res[3];
    }
    //int[0] is BST or not 1:yes, -1:no
    //int[1] lowest value of bst
    //int[2] highest value of bst
    //int[3] size of the largestBST
    public int[] largestBST(TreeNode root){
        int[] res = new int[4];
        if (root == null) {
            res[0] = 1;
            res[1] = Integer.MAX_VALUE;
            res[2] = Integer.MIN_VALUE;
            res[3] = 0;
            return res;
        }
        int[] left = largestBST(root.left);
        int[] right = largestBST(root.right);
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]){
            res[0] = 1;
            res[1] = left[3] == 0? root.val:left[1];
            res[2] = right[3] == 0? root.val:right[2];
            res[3] = left[3] + right[3] + 1;
        } else {
            res[0] = -1;
            res[3] = Math.max(left[3], right[3]);
        }
        return res;
    }
}