```java
//O →...→ 1 → 2
//        |   |
//        4 ← 3
//    s     r
//快慢指针n0, n1从head出发：
//第一次相聚用了 k steps, n1: k = s + nr
//                      n2: 2k = s + mr  
//                           |
//                           k = (m - n)r => k = r    (m - n = 1)
//                                           k = s + nr 
//                                           | 
//                                           s = (1 - n)r
//双指针n0',n1分别从head和第k步处 (k = s + nr)同时出发:
//O →......→ 1 → 2
//           |   |
//           4 ← 3
//  (1 - n)r   r
//第二次相遇会在节点处相遇，因为n0'和 n1 经过（1 - n)r 步之后均到达节点
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        slow = head;
        while (slow != null && fast != null) {
            if (slow == fast) return slow;
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }
}
```