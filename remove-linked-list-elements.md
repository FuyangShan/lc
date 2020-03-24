# [203] Remove Linked List Elements 移除链表元素
https://leetcode.com/problems/remove-linked-list-elements

问题：删除链表中等于给定值val的所有节点。
Example:
Given: 1 –> 2 –> 6 –> 3 –> 4 –> 5 –> 6, val = 6
Return: 1 –> 2 –> 3 –> 4 –> 5

思路：非常简单，删除就是把要删除的节点前一个的 next 指向别的，把它自己的 next 连上去。注意删除掉next结点的话就不用prev = prev.next了，删除结点时prev.next发生变化所以不用做什么，只有不删除时才向后移动，否则有可能空指针！

```java
public ListNode removeElements(ListNode head, int val) {
    if (head == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head.next != null) {
        if (head.next.val == val) {
            head.next = head.next.next;
        } else {
            head = head.next;
        }
    }
    return dummy.next;
}
```