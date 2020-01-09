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