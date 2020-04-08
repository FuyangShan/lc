# Tree

## Definition
- Tree is an undirected graph in which any two vertices are connected by exactly one path, or equivalently a connected acyclic undirected graph

### Binary Tree
- For every node, at most two children without cycle -> DAG(directed acyclic graph)

* Binary Tree 往往是最常见的，和recursion结合最紧密的面试题目类型
* Reason:
    - 每层的node具备的性质，专递的值和下一层的性质往往一致，比较容易定义recursive rule
    - Base case（generally）：null pointer under the leaf node

> Example: getTreeHeight(TreeNode root) 
- Base case: root == null return 0
- Return: Math.max(leftHeight, rightHeight);
- Time: O(n)
- Space: O(n)

### Balanced Binary Tree
> Example: isBalanced(TreeNode root)
- if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1 ) 
    return -1;
- Base case: root == null 
    return 0
- Return: Math.max(leftHeight, rightHeight) + 1

### Complete Binary Tree
- For each level, except the last level, it should be filled completely, last level should be filled as left as possible

### Full Binary Tree

### Balanced Search Tree
- For each node, ABS(left subtree height - right subtree height) <= 1


## Tree Traversal

### Pre-Order
> For each node, do operations in order of: **cur, left, right**
### In-Order
> For each node, do operations in order of: **left, cur, right**
### Post-Order
> For each node, do operations in order of: **left, right, cur**




* [144. Binary Tree Preorder Traversal](binary-tree-preorder-traversal.md)
* [94. Binary Tree Inorder Traversal](binary-tree-inorder-traversal.md)
* [145. Binary Tree Postorder Traversal](binary-tree-postorder-traversal.md)
* [104. Maximum Depth of Binary Tree](maximum-depth-of-binary-tree.md)
* [111. Minimum Depth of Binary Tree](minimum-depth-of-binary-tree.md)
* [110. Balanced Binary Tree](balanced-binary-tree.md)
* [101. Symmetric Tree](symmetric-tree.md)
* [100. Same Tree](same-tree.md)
* [226. Invert Binary Tree](invert-binary-tree.md)
* [98. Validate Binary Search Tree](validate-binary-search-tree.md)
* [333. Largest BST Subtree](largest-bst-subtree.md)
* [102. Binary Tree Level Order Traversal](binary-tree-level-order-traversal.md)
* [107. Binary Tree Level Order Traversal II](binary-tree-level-order-traversal-ii.md)
* [257. Binary Tree Paths](binary-tree-paths.md)
* [112. Path Sum](path-sum.md)
* [113. Path Sum II](path-sum-ii.md)
* [437. Path Sum III](path-sum-iii.md)
* [129. Sum Root to Leaf Numbers](sum-root-to-leaf-numbers.md)
* [298. Binary Tree Longest Consecutive Sequence](binary-tree-longest-consecutive-sequence.md)
* [124. Binary Tree Maximum Path Sum](binary-tree-maximum-path-sum.md)
* [250. Count Univalue Subtrees](count-univalue-subtrees.md)
* [103. Binary Tree Zigzag Level Order Traversal](binary-tree-zigzag-level-order-traversal.md)
* [235. Lowest Common Ancestor of a BST](lowest-common-ancestor-of-a-binary-search-tree.md)
* [236. Lowest Common Ancestor of a Binary Tree](lowest-common-ancestor-of-a-binary-tree.md)
* [108. Convert Sorted Array to Binary Search Tree](convert-sorted-array-to-binary-search-tree.md)
* [109. Convert Sorted List to Binary Search Tree](convert-sorted-list-to-binary-search-tree.md)
* [270. Closest Binary Search Tree Value](closest-binary-search-tree-value.md)
* [272. Closest Binary Search Tree Value II](closest-binary-search-tree-value-ii.md)
* [99. Recover Binary Search Tree](recovery-binary-search-tree.md)
* [114. Flatten Binary Tree to Linkedlist](flatten-binary-tree-to-linked-list.md)
* [222. Count Complete tree nodes](count-complete-tree-nodes.md)
* [105. Construct Binary Tree from Preorder and Inorder Traversal](construct-binary-tree-from-preorder-and-inorder-traversal.md)
* [106. Construct Binary Tree from Inorder and Postorder Traversal](construct-binary-tree-from-inorder-and-postorder-traversal.md)
* [116. Populating Next Right Pointers in Each Node](populating-next-right-pointers-in-each-node.md)
* [117. Populating Next Right Pointers in Each Node II](populating-next-right-pointers-in-each-node-ii.md)
* [314. Binary Tree Vertical Order Traversal]()
* [450. Delete Node in a BST](delete-node-in-bst.md)
* [572. SubTree of another Tree](subtree-of-another-tree.md)
* [199. Binary Tree Right Side View]()
* [337. House Robber III]()
* [366. Find Leaves of Binary Tree]()
* [173. Binary Search Tree Iterator]()
* [230. Kth Smallest Element in a BST]()
* [297. Serialize and Deserialize Binary Tree]()
* [285. Inorder Successor in BST]()
* [156. Binary Tree Upside Down]()
* [255. Verify Preorder Sequence in Binary Search Tree]()
* [96. Unique Binary Search Trees]()
* [95. Unique Binary Search Trees II]()
* [331. Verify Preorder Serialization of a Binary Tree]()
