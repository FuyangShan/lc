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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean hasNull = false;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    if (hasNull) return false;
                    q.add(curr.left);
                } else hasNull = true;
    
                if (curr.right != null) {
                    if (hasNull) return false;
                    q.add(curr.right);
                } else hasNull = true;
            } 
        }    
        return true;
    }
}