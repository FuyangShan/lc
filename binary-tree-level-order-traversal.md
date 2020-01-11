# Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

```java
//BFS
class Solution{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        //Queue for root to be traversed
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
                result.add(temp);
        }
        //107. Binary Tree Level Order Traversal II
        //Collections.reverse(res);
        return result;
    }
}




//DFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int level = 0;
        levelOrder(root, res, 0);
        return res;
    }
    public void levelOrder(TreeNode root, List<List<Integer>> list, int level){
        if (root == null) return;
        if (list.size() == level){
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        levelOrder(root.left, list, level + 1);
        levelOrder(root.right, list, level + 1);
    }
}
```