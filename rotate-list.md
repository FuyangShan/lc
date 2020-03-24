# [61] Rotate List 旋转链表
https://leetcode.com/problems/rotate-list

问题：把后k个rotate到list前面去，k可以超过list本身长度。
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

思路：用walker-runner定位到要旋转的那个结点，然后将下一个结点设为新表头，并且把当前结点设为表尾。

```java
public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    ListNode index = head;
    int len = 1;
    // 得到链表长度
    while (index.next != null) {
        index = index.next;
        len++;
    }
    // 因为k可能大于链表长度len，所以需要取余处理
    k %= len;

    // 链表首尾连成一个环
    index.next = head;
    // 得到新的链表头
    for (int i = 1; i < len - k; i++) {
        head = head.next;
    }
    // res是新的head
    ListNode res = head.next;
    // 断开环
    head.next = null;
    return res;
}
```