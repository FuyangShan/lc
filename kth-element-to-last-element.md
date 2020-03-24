# 链表中倒数第k个结点
https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a

问题：输入一个链表，输出该链表中倒数第k个结点。

思路：使用两个节点p1和p2，快指针先从表头走k-1步，从第k步开始两个快慢指针一起走，直到快指针走到尾节点退出while循环。由于两个指针的距离保持在k-1，当快指针到达链表的尾结点时，慢指针正好是倒数第k个结点。注意：k大于链表长度的情况要返回null。

```java
public ListNode findKthToTail(ListNode head, int k) {
    if (head == null || k < 1) return null;
    ListNode fast = head;
    ListNode slow = head;
    for (int i = 0; i < k - 1; i++) {
        // 链表节点数可能小于k
        if (fast.next != null)
            // 快指针先走k-1步
            fast = fast.next;
        else
            return null;
    }
    // 快指针走到尾节点就退出循环
    while (fast.next != null) {
        // 从第k步开始，两个指针一起走
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
}
```