# [143] Reorder List 重排链表
https://leetcode.com/problems/reorder-list

问题：Given a singly linked list L: L0→L1→…→L(n-1)→Ln, reorder it to: L0→Ln→L1→L(n-1)→L2→L(n-2)→…
For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.

思路：这是一道比较综合的链表操作的题目，要按照题目要求给链表重新连接成要求的结果。其实理清思路也比较简单，分三步完成：（1）将链表切成两半，也就是找到中点，然后截成两条链表；（2）将后面一条链表进行reverse操作，就是反转过来；（3）将两条链表按顺序依次merge起来。

```java
public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode temp = null;
    ListNode slow = head, fast = head;
    ListNode l1 = head;
    while (fast != null && fast.next != null) {
        temp = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    // 截断后半部分
    temp.next = null;
    ListNode l2 = reverse(slow);
    merge(l1, l2);
}

public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}

public void merge(ListNode l1, ListNode l2) {
    while (l1 != l2) {
        ListNode n1 = l1.next;
        ListNode n2 = l2.next;
        l1.next = l2;
        if (n1 == null) break;
        l2.next = n1;
        l1 = n1;
        l2 = n2;
    }
}
```