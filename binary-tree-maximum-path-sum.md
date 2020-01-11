# Binary Tree Maximum Path Sum
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42


```java
//创建一个方法来得到->某个参与MaxPath的root的gain
//后序遍历,得到两个子节点的gain
//方法返回 root.val + Math.max(left_gain, right_gain) 解释如下：
//首先root必须参与（否则不符合方法的定义，参与MaxPath的root），
//其次选择gain较大的一个分支来加入MaxPath, 只能有一个分支加入MaxPath，要么从左上来，要么从右上来，
//如果两个子节点的gain都小于0，则两个子节点都不参与root的MaxPath；
//
//遍历的同时，创建一个临时由[左子节点-节点-右子节点]构成的完整Path，如果maxPath小于Path，则更新maxPath；
class Solution {
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return maxPath;
    }
    private int max_gain(TreeNode root) {
        if (root == null) return 0;
        int left_gain = Math.max(0,max_gain(root.left));
        int right_gain = Math.max(0,max_gain(root.right));
        int price = root.val + left_gain + right_gain;
        maxPath = Math.max(maxPath,price);
        return root.val + Math.max(left_gain, right_gain);
    }
}
```