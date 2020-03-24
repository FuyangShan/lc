# [328] Odd Even Linked List 奇偶链表
https://leetcode.com/problems/odd-even-linked-list

问题：给我们一个链表，分开奇偶节点（奇偶指的是节点位置而不是节点上的值），所有奇节点在前，偶节点在后。例如，给出链表1->2->3->4->5->NULL，应返回链表1->3->5->2->4->NULL。

思路：新建两个链表，分别存储奇数位置和偶数位置的节点，最后将两个链表接上，得到的结果即为所求。
这种不是删除结点而是移动重新插入结点的问题要注意：prev/cur等游标指针的移动，是不是后面结点被移走了就不用移动了，是不是后面结点移走了就null了等等。

```java
public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;
    // 因为odd肯定在even之前，所以只需要判断even和even.next不为空就可以
    while (even != null && even.next != null) {
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    // 偶链表连在奇链表后面
    odd.next = evenHead;
    return head;
}
```