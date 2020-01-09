//BFS
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
                } else hasNull = true; //mark hasNull if left is empty
        
                if (curr.right != null) {
                    if (hasNull) return false;
                    q.add(curr.right);
                } else hasNull = true; //mark hasNull if right is empty
            } 
        }    
        return true;
    }
}
