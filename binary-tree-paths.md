# Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }
    private void helper(TreeNode root, String path, List<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            path += root.val + "";
            res.add(path);
        } else {
            path += root.val + "->";
            helper(root.left, path, res);
            helper(root.right, path, res);
        }
    }
}
```