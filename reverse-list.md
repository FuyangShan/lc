# [206] Reverse Linked List 反转链表
https://leetcode.com/problems/reverse-linked-list

问题：输入一个链表，反转链表后，输出链表的所有元素。

思路：最简单的就是建一个Dummy node，然后不断地将原来List的Node插入到dummy node的后面， 但是这样需要了额外的空间。
更好的方法是用一个variable pre保存前一个node，一个cur保存现在的Node，不断地改变这两个node 的指针关系，并且将pre和cur更新向下两个点。

```java
// dummy: temp → dummy.next, dummy → temp, return dummy.next
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }
}


//curr → pre, pre 和 curr同时进一位, return pre；
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

//recursion: head.next → head, head → null, return p;
class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newNode = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newNode;
    }
}
```