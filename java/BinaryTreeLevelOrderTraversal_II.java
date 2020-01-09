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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        List<Integer> firstLevel = new ArrayList<>();
        firstLevel.add(root.val);
        list.add(firstLevel);
        int curr = 0;
        int currLevel = 0;
        while (curr < nodeList.size()){
            int lastLevelCount = list.get(currLevel++).size();
            List<Integer> level = new ArrayList<>();
            for (int i = curr; i < curr + lastLevelCount; i++){
                TreeNode left = nodeList.get(i).left;
                TreeNode right = nodeList.get(i).right;
                if (left != null){
                    level.add(left.val);
                    nodeList.add(left);
                }
                if (right != null){
                    level.add(right.val);
                    nodeList.add(right);
                }
            }
            if (level.size() != 0) list.add(level);
            curr += lastLevelCount;    
        }
        Collections.reverse(list);
        return list;
    }
}