class Solution {
    int po_idx;
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> in_idx_map;
    
    public TreeNode helper(int in_left, int in_right) {
        
        if (in_left == in_right) return null;
        
        int root_val = postorder[po_idx];
        TreeNode root = new TreeNode(root_val);
        
        int index = in_idx_map.get(root_val);
        
        po_idx--;
        
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index);
        
        return root;
        
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        this.inorder = inorder;
        this.postorder = postorder;
        po_idx = postorder.length - 1;
        in_idx_map = new HashMap<>();
        int idx = 0;
        
        for (int val : inorder) {
            in_idx_map.put(val, idx++);
        }
        return helper(0, postorder.length);
        
    }
}