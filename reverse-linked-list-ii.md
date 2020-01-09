# 92. Reverse Linked List II
```java
// ... → n0 → n1 → n2 → n3 → n4 → ... → null 反转 n1 - n3
// 创建dummy并设为head
// 偏移head m - 1次找到n0并记做 head 和 prev，找到 n1 并记作 n1 和 curr，从 n1 开始翻转 // m - n + 1 次
// curr → pre, pre 和 curr 同时进一位, 持续翻转直到最后一次迭代：prev = n3, curr = n4
// 将之前记录的 n0 (head) → n3 (prev) 并且 n1 (n1) → n4 (curr)
//  最终...→ n0 → n3 → n2 → n1 → n4 →...

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode prev = head;
        ListNode n1 = head.next, curr = head.next;
        for (int j = m - 1; j < n; j++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        n1.next = curr;//之前记下的n1派上了用场
        head.next = prev; //之前记下的head派上了用场
        return dummy.next;
    }
}
```
