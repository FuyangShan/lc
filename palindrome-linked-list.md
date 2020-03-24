# [234] Palindrome Linked List 判断链表是否是回文串
https://leetcode.com/problems/palindrome-linked-list

问题：判断一个链表是否为回文链表。

思路：简单解法很容易，遍历链表时用一个ArrayList存所有值，然后检查ArrayList就行了。注意：ArrayList里的是Integer，判断相等要用equals而不能用==！O(1)空间做法与第143题非常像！就是用快慢指针找到链表中点后，反转后半链表，然后从前后两个方向模仿数组那样检查Palindrome。注意：终止条件是right!=mid或left、right都不为空，如果只检查left!=right的话会空指针或死循环！同时关于reverse，不能用“头插法”，因为我们要在reverse完成后从后往前做比较，“头插法”是不合适的！
链表比字符串难的地方就在于不能通过坐标来直接访问，而只能从头开始遍历到某个位置。那么根据回文串的特点，我们需要比较对应位置的值是否相等，那么我们首先需要找到链表的中点，这个可以用快慢指针来实现。我们使用快慢指针找中点的原理是fast和slow两个指针，每次快指针走两步，慢指针走一步，等快指针走完时，慢指针的位置就是中点。
我们还需要用栈，每次慢指针走一步，都把值存入栈中，等到达中点时，链表的前半段都存入栈中了，由于栈的后进先出的性质，就可以和后半段链表按照回文对应的顺序比较了。
这道题的Follow Up让我们用O(1)的空间，那就是说我们不能使用Stack了，那么我们可以在找到中点后，将后半段的链表原地反转一下，这样我们就可以按照回文的顺序比较了。

```java
public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    // 找中点
    ListNode mid = findMiddle(head);
    // 对中点后的节点进行反转
    mid.next = reverse(mid.next);
    // 分别对两部分[head,mid)和[mid.next,null)的值一一进行比较
    ListNode p = head;
    ListNode q = mid.next;
    while (p != null && q != null) {
        if (p.val != q.val) return false;
        p = p.next;
        q = q.next;
    }
    return true;
}

private ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

private ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
```