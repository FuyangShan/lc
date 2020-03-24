# [19] Remove Nth Node From End of List 删除链表中倒数第n个节点
https://leetcode.com/problems/remove-nth-node-from-end-of-list


问题：删除链表中倒数第n个节点。
Example:
Given: 1->2->3->4->5, and n = 2
Return: 1->2->3->5

思路：利用双指针快速定位到要删除节点的位置。先用一个fast指针走n步，然后再来一个slow指针从头开始和fast同时向后走，当fast走到链表末尾的时候，slow指针即为倒数第n个结点。

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || head.next == null || n <= 0) return head;
    // 设立头结点
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // 初始化slow,fast
    ListNode slow = dummy, fast = dummy;
    // fast指针先走n步
    for (int i = 0; i < n; i++) {
        fast = fast.next;
    }
    // 两个指针同时移动直到p2到达最后
    while (fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }
    // 删除并返回
    slow.next = slow.next.next;
    return dummy.next;
}
```