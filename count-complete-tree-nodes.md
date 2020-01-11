# Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

```java
//Preorder O(N) O(1)
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
}
//Binary Search^2 O(logN^2) O(1)
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int d = depth(root);
        if (d == 0) return 1;
        
        int lo = 0, hi = (int)Math.pow(2, d) - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (exists(mid, d, root)) lo = mid + 1;
            else hi = mid - 1;
        }
        return (int)Math.pow(2, d) - 1 + lo;
        
    }
    private boolean exists(int idx, int d, TreeNode root) {
        int lo = 0, hi = (int)Math.pow(2, d) - 1; //the last index of last level
        int mid;
        
        for (int i = 0; i < d; i++) { //climbing down d times to check if there is node at idx.
            mid = lo + (hi - lo) / 2;
            if (mid < idx) {
                root = root.right;
                lo = mid + 1;
            } else { //mid >= idx
                root = root.left;
                hi = mid;
            }
        }
        return root != null;
    }
    private int depth(TreeNode root) {
        int d = 0; //get the depth of tree, level # below root;
        while (root.left != null) {
            root = root.left;
            d++;
        }
        return d;
    }
}
```

