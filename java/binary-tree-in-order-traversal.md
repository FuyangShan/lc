/*
//递归遍历 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
    public void traversal(TreeNode root, List<Integer> list){
        if (root == null) return;
        if (root.left != null)
            traversal(root.left, list);
        list.add(root.val);
        if (root.right != null)
            traversal(root.right, list);
    }
} */


//利用stack辅助进行循环遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}