# [237] Delete Node in a Linked List

问题：只给定单链表中某个结点p(并非最后一个结点)，删除该结点。

思路：首先是放p中数据，然后将p.next的数据复制到p中，接下来删除p.next即可。

```java
public void deleteNode(ListNode head, ListNode toBeDeleted) {
    if (head == null || toBeDeleted == null) return;

    // 链表有多个节点，要删除的结点不是尾结点: O(1) 时间
    if (toBeDeleted.next != null) {
        ListNode next = toBeDeleted.next;
        toBeDeleted.val = next.val;
        toBeDeleted.next = next.next;
        next = null;
    } else if (head == toBeDeleted) {
        // 链表只有一个结点，删除头结点（也是尾结点）:O(1) 时间
        toBeDeleted = null;
        head = null;
    } else {
        // 链表有多个节点，要删除的是尾节点: O(n) 时间
        ListNode temp = head;
        while (temp.next != toBeDeleted) {
            temp = temp.next;
        }
        temp.next = null;
    }
}
```