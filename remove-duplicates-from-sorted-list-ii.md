# [82] Remove Duplicates from Sorted List II 删除所有重复元素
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

问题：给定一个有序的链表，删除该链表中所有有重复的节点，重复的结点不保留，返回链表头指针。例如：
给定 1->2->3->3->4->4->5，则返回 1->2->5
给定 1->1->1->2->3，则返回 2->3

思路：因为要删除所有duplicate，而不是只保留一份，所以while循环里必须嵌套循环，发现duplicate就一删到底。如果只用一层循环，那么效果就跟第83题一样了，必须保留一份duplicate，否则下一轮循环时不知道之前重复的是哪个结点。

```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head.next != null && head.next.next != null) {
        if (head.next.val == head.next.next.val) {
            int duplicate = head.next.val;
            while (head.next != null && head.next.val == duplicate) {
                head.next = head.next.next;
            }
        } else {
            head = head.next;
        }
    }
    return dummy.next;
}
```