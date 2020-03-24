# [160] Intersection of Two Linked Lists 两个相交链表的交点
https://leetcode.com/problems/intersection-of-two-linked-lists

问题：找出两个单链表相交的开始处。

思路：两个单链表相交只可能为“>-”型，因为单链表只有一个next指针。如果两个单链表有共同的节点，那么从第一个共同节点开始，后面的节点都会重叠，直到链表结束。
因此我们分别从head1,head2开始遍历两个链表获得其长度len1与len2。假设len1>=len2，那么指针p1由head1开始向后移动len1-len2步。指针p2=head2，下面p1、p2每次向后前进一步并比较p1和p2是否相等，如果相等即返回该结点，否则说明两个链表没有交点。

```java
//先建环，快慢指针第一次相遇后，指针1回到head，指针2从原位置同速继续遍历，直到再次相遇即为相交点
//注意如果不相交，则第一次则不会相遇，返回null
//注意找到相交点之后，要把环解开复原链表结构

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode circleA = headA;
        while (circleA.next != null) circleA = circleA.next;
        circleA.next = headB;
        ListNode slow = headA, fast = headA;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow == null || fast == null || fast.next == null) {
            circleA.next = null;
            return null;
        }
        slow = headA;
        while (slow != null && fast != null) {
            if (slow == fast) break;
            slow = slow.next;
            fast = fast.next;
        }
        circleA.next = null;
        return slow;
    }
}
```