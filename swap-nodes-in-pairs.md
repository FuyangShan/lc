# [24] Swap Nodes in Pairs 成对交换链表节点
https://leetcode.com/problems/swap-nodes-in-pairs

问题：成对交换链表节点。也就是说，节点1、2交换，节点3、4交换，节点5、6交换...
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

思路：每次跳两个节点，后一个接到前面，前一个接到后一个的后面，最后现在的后一个（也就是原来的前一个）接到下下个结点（如果没有则接到下一个）。


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