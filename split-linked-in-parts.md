# [725] Split Linked List in Parts 拆分链表成k部分
https://leetcode.com/problems/split-linked-list-in-parts

问题：给我们一个链表和一个正数k，让我们分割链表成k部分，尽可能的平均分割，如果结点不够了，就用空结点。平均分后多出来的节点优先分配给前面的部分。

思路：常规的链表操作题。

```java
public ListNode[] splitListToParts(ListNode root, int k) {
    ListNode[] res = new ListNode[k];

    int len = 0;
    for (ListNode cur = root; cur != null; cur = cur.next) len++;

    int part = len / k;
    int surplus = len % k;
    ListNode head = root;
    ListNode prev = null;
    for (int i = 0; i < k; i++, surplus--) {
        res[i] = head;
        // 多的部分有k+1个，少的部分有k个
        for (int j = 0; j < part + (surplus > 0 ? 1 : 0); j++) {
            prev = head;
            head = head.next;
        }
        // 与后面部分断开
        if (prev != null) prev.next = null;
    }
    return res;
}
```