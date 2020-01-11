# Binary Tree Level Order Traversal II
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

```java
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
```