/* 
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
    public void traversal(TreeNode root, List<Integer> list){
        if (root == null) return;
        if (root.left != null) traversal(root.left, list);
        if (root.right != null) traversal(root.right, list);
        list.add(root.val);
    }
} */


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root = null) return null;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if (curr.left != null) {
                stack.push(curr.left);
                curr.left = null;
            } else if (curr.right != null){
                stack.push(curr.right);
                curr.right = null;
            } else {
                res.add(curr.val);
                stack.pop();
            }
        }
        return res;
    }
}