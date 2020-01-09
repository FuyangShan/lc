```java
//dummy → n1 → n2 → n3…
//dummy → n2 → n1 → n3...

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null){
            ListNode n1 = head.next, n2 = head.next.next;
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            head = n1;
        }
        return dummy.next;
    }
}

//recursion
class Solution {
   public ListNode swapPairs(ListNode head) {
       if (head == null || head.next == null) return head;
       ListNode newNode = swapPairs(head.next.next);
       ListNode newHead = head.next;
       head.next.next = head;
       head.next = newNode;
       return newHead;
   }
}
```