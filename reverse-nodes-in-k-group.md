```java
//iteration
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            head = reverse(head,k);
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head, int k) {
        ListNode next = head;
        for (int i = 0; i < k; i++) {
            if (next.next == null) return next;
            next = next.next;
        }
        ListNode n1 = head.next, prev = null, curr = head.next;
        for (int i = 0; i < k; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = prev;
        n1.next = curr;
        return n1;
    }
}

//recursion
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode next = head, n0 = head;
        for (int i = 0; i < k; i++) {
            if (next == null) return head;
            n0 = next;
            next = next.next;
        }
        ListNode newNode = reverseKGroup(next, k);
        ListNode prev = null, curr = head;
        for (int i = 0; i < k; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = newNode;
        return n0;
    }
}
```