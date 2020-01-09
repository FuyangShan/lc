
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        path(res,new ArrayList<>(),root,sum);
        return res;
    }
    private static void path(List<List<Integer>> res, List<Integer> cur, TreeNode node, int sum){
        if (node == null) return;
        cur.add(node.val);
        path(res,cur,node.left,sum - node.val);
        path(res,cur,node.right,sum - node.val);
        if (node.val == sum && (node.left == null && node.right == null)){
            res.add(new ArrayList<>(cur));
        }
        cur.remove(cur.size() - 1);
    }
}