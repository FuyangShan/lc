# LinkedList

### 代表例题

链表删除
* [203. Remove Linked List Elements](remove-linked-list-elements.md)
* [19. Remove Nth Node From End of List](remove-nth-node-from-end-of-list.md)
* [83. Remove Duplicates from Sorted List](remove-duplicates-from-sorted-list.md)
* [82. Remove Duplicates from Sorted List II](remove-duplicates-from-sorted-list-ii.md)
* [237. Delete Node in a Linked List](delete-node-in-a-linked-list.md)
链表反转与旋转
* [206. Reverse List](reverse-list.md)
* [92. Reverse Linked List II](reverse-linked-list-ii.md)
* [24. Swap Pairs](swap-nodes-in-pairs.md)
* [25. Reverse Nodes in k-Group](reverse-nodes-in-k-group.md)
环
* [141. Linked List Cycle](linked-list-cycle.md)
* [142. LinkedList Cycle II](linked-list-cycle-ii.md)
链表排序
* [148. Sort list](sort-list.md)
* [147. Insert sort list](insert-sort-list.md)
链表操作
* [143. Reorder List](reorder-list.md)
* [61. Rotate List](rotate-list.md)
* [86. Partition List](partition-list.md)
* [328. Odd Even Linked List](odd-even-linked-list.md)
* [725. Split Linked List in Parts](split-linked-in-parts.md)
* [234. Palindrome Linked List](palindrome-linked-list.md)
进位加法
* [2. Add Two Numbers](add-two-numbers.md)
* [445. Add Two Numbers II](add-two-numbers-ii.md)
链表合并
* [21. Merge Two Sorted Lists](merge-two-sorted-lists.md)
* [23. Merge k Sorted Lists](merge-k-sorted-lists.md)
* [160. Intersection of Two Linked Lists](intersection-of-two-linked-lists.md)
其他
* [138. Copy List with Random Pointer](copy-list-with-random-pointer.md)
* [109. Convert Sorted List to Binary Search Tree](convert-sorted-list-to-binary-search-tree.md)
* [kth element to last element](kth-element-to-last-element.md)
* [print from tail to head](print-from-tail-to-head.md)


### 解题技巧
- slow，fst双指针，因为链表无法得知长度，所以尝试用这种方法来达到某种效果（长度、检测环等）
- 对于涉及链表长度的问题，往往会通过两个指针进行几何变换来得到想要的差额==要好好画图理解思考
- 使用一些临时变量来存储next指针，以完成插入删除等操作
- 对于插入和删除等操作，往往需要一个额外的指针来记录其前面的节点，再编程之前好好思考其间关系效果会比较好
- 对一些依赖于后面节点才可以完成的操作，使用递归的方式来解决
- 对于有些题目提前使用循环获得其链表的长度也是一种有效的方法
- 对于要考虑最后几个节点的操作，有事可以再遍历之前先将头指针向后移动k个节点
- 插入、删除操作往往需要使用目标节点前面的节点，所以往往会定义一个新的链表节点其next指针指向head节点
