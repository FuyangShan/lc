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