# Delete Nodes And Return Forest
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

 

Example 1:



Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.

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
    
    HashSet<Integer> set;
    List<TreeNode> res;
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        DFS(root, true);
        return res;
        
    }

    // preorder traverse
    // whether to add to list depends on:
    // 1. if it's deleted -> if children are roots
    // 2. if it's root <- if parent is deleted
    // while traversing, we need to update the children status...
    private TreeNode DFS(TreeNode node, boolean isRoot) {
        if (node == null) return node;
        boolean deleted = set.contains(node.val);
        
        if (isRoot && !deleted) res.add(node);
        node.left = DFS(node.left, deleted);
        node.right = DFS(node.right, deleted);
        
        return deleted ? null : node;
        
    }
}
```