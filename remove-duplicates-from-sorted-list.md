# [83] Remove Duplicates from Sorted List 删除重复元素
https://leetcode.com/problems/remove-duplicates-from-sorted-list

问题：Given a sorted linked list, delete all duplicates such that each element appear only once. For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

思路：从这道题我们可以学习一下删除结点的两种方法，可以说各种所长。

第一种是向后比较结点，发现重复就删掉。因为可能会删掉后面的结点，所以一定要注意cur的判空条件。当正常遍历时，cur可能为空，当删掉了后面结点时cur.next可能为空，都要判断。
第二种是向前比较结点，即用prev记录前一个结点的值，发现相同就删掉当前结点，判空条件简单一些，但一定注意prev和cur的更新。因为这道题肯定不会删除head，所以也就没用到dummy头结点。


```java
//iteration
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
//recursion
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = deleteDuplicates(head.next);
        if (head.val == tail.val) return tail;
        head.next = tail;
        return head;
    }
}
```
