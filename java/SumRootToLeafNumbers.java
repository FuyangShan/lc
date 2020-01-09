/* 
class Solution {
    public int sumNumbers(TreeNode root) {
        List<String> res = new ArrayList<>();
        sumNums(root,"", res);
        int result = 0;
        for (int i = 0; i < res.size(); i++){
            result += Integer.parseInt(res.get(i));
        }
        return result;
    }
    public void sumNums(TreeNode root,String s,List<String> res){
        if (root == null) return;
        s += Integer.toString(root.val);
        sumNums(root.left,s,res);
        sumNums(root.right,s,res);
        if (root.left == null && root.right == null) 
            res.add(s);
        s = s.substring(0,s.length() - 1);
    }
} */


class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNums(root, 0);
    }
    public int sumNums(TreeNode root, int path){
        if (root == null) return 0;
        path = (path*10) + root.val;
        int left = sumNums(root.left, path);
        int right = sumNums(root.right, path);
        if (root.left == null && root.right == null){
            return path;
        }
        return left + right;
    }
}