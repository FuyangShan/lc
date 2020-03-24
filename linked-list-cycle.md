# [141] Linked List Cycle 判断链表是否有环
https://leetcode.com/problems/linked-list-cycle

问题：给定一个链表，判断该链表是否有环。

思路：快慢指针同时从链表的头结点出发，快指针fast步长为2，慢指针slow步长为1，如不存在环，快指针到达链表尾部遇到null退出；如果存在环，则某个时刻两者一定在环里相遇(fast==slow)。从而检测到链表中有环。

```java
//快慢指针，相遇就是有环；

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
```