# BFS

## 1. Breadth-First Search
- High level: 由近及远，一层一层遍历node
- Mid level: 用一个Queue来实现
- Lower level: 
    - 从Queue的top中弹一个node, 
    - expand当前node, 
    - generate 邻近的node，并插入队尾
    - 当Queue为空时，结束遍历
> 从Queue弹出之前，记录当前queue的size作为当前层要遍历的node数量
* Q: When should we consider to use BFS to solve a class of questions?
* A: When we deal with the tree-related problem and in the meantime we need to address the relationship on the same level

### 模版
```java
public void BFS(Node root) {
    if (root == null) return;

    Queue<Node> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size(); i++) {
            Node cur = q.poll();
            if (n.left != null) 
                q.offer(n.left);
            if (n.right != null)
                q.offer(n.right);
            System.out.print(cur.val + " ");
        }
        System.out.println();
    }
}
```

## 2. Best-First Search
- 经典算法： Dijkstra's Algorithm
1. usage: Find the shortest path/cost from a single node (source node) to any other nodes in the graph
2. Example problem: 从北京到中国其他所有主要城市的总最短距离是多少？
3. Data Structure: PriorityQueue(min_heap)
4. 解题思路
    - Initial state (start node)
    - Node expansion/Generation rule
    - Termination Condition: all nodes expanded

### 经典考题 （运用Dijkstra‘s Algorithm）
- Given a matrix of size NxN, and for each row the elements are sorted in an ascending order. And for each column the elements are also sorted in an ascending order.
- How to find the k-th smallest element in it?
> 1 2 3 4 5
> 2 3 4 5 6
> 3 4 5 6 7
> 4 5 6 7 8
> 5 6 7 8 9

- Solution: BFS
    1. initial state(start node)
        input[0][0]
    2. node expansion/generate neighbor nodes (right, bottom)
        expand[0][0] : generate input[0][1] + input[1][0]
    3. termination condition
        When the k-th element is popped out of p_queue
    4. De-duplicate visited node



## BFS例题

* [102. Binary Tree Level Order Traversal](binary-tree-level-order-traversal.md)
* [103. Binary Tree Zigzag Level Order Traversal](binary-tree-zigzag-level-order-traversal.md)
* [958. Check Completeness of a Binary Tree](check-completeness-of-a-binary-tree.md)
* [116. Populating Next Right Pointers in Each Node](populating-next-right-pointers-in-each-node.md)
* [117. Populating Next Right Pointers in Each Node II](populating-next-right-pointers-in-each-node-ii.md)
* [261. Graphic Valid Tree](graph-valid-tree.md)
* [310. Minimum Height Trees](minimum-height-trees.md)
* [54. Spiral Matrix](spiral-matrix.md)
* [59. Spiral Matrix II](spiral-matrix-ii.md)
