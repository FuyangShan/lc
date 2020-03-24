# [86] Partition List 划分链表
https://leetcode.com/problems/partition-list

问题：划分一个链表，把所有小于给定值的节点都移到前面，大于该值的节点顺序不变。

思路：使用两个链表，p1和p2，以此遍历原链表，如果节点的值小于x，就挂载到p1下面，反之则放到p2下面，最后将p2挂载到p1下面就成了。

```java
public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) return head;
    ListNode smallerHead = new ListNode(0);
    ListNode greaterHead = new ListNode(0);
    ListNode smaller = smallerHead;
    ListNode greater = greaterHead;
    while (head != null) {
        ListNode temp = new ListNode(head.val);
        if (head.val < x) {
            smaller.next = temp;
            smaller = smaller.next;
        } else {
            greater.next = temp;
            greater = greater.next;
        }
        head = head.next;
    }
    smaller.next = greaterHead.next;
    return smallerHead.next;
}
```