# Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

```java
class Solution {
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> in_idx_map;
    
    public TreeNode helper(int in_left, int in_right) {
        //if no elements are getting rooted, return null
        if (in_left == in_right) {
            return null;
        }
        //create root node using increamental preorder index : pre_idx
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        //get the position of root node in inorder array, at this moment, all elements in the left of root node is left_subtree, all elements in the right root node is right_subtree.
        int index = in_idx_map.get(root_val);
        //recursively increase pre_idx to get the next root.
        pre_idx++;
        
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);
        
        return root;   
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        this.preorder = preorder;
        this.inorder = inorder;
        in_idx_map = new HashMap<>();
        int idx = 0;
        for (int val : inorder) {
            in_idx_map.put(val, idx++);
        }
        return helper(0, inorder.length);
    }
}
```