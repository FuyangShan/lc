# Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
```java
//BFS
class Solution{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        //Queue for root to be traversed
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //mark the sequence of traversal
        boolean isLeft = true;
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            if (!isLeft) Collections.reverse(temp); //reverse the list of temp
            result.add(temp);
            isLeft = !isLeft;
        }
        return result;
    }
}



//DFS
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        zigzagLevelOrder(root, 0);
        return res;
    }

    public void zigzagLevelOrder(TreeNode root, int level){
        if (root == null) return;
        if (res.size() == level){
            res.add(new ArrayList<Integer>());
        }
        if (level % 2 == 0){
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0,root.val);
        }
        zigzagLevelOrder(root.left,level+1);
        zigzagLevelOrder(root.right,level+1);
    }
}
```