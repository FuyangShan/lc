# Sort List
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

```java
//MergeSort: 循环sort，第一遍，两个两个节点sort，遍历整个链表， 第二遍四个四个sort，遍历整个链表。。。最后一遍1/2 * n 个节点与剩下节点sort，完成sort
//先拆成1 vs 2，3 vs 4，5 vs 6...n-1 vs n，每组内部进行双指针sort，后合并1-2-3-4...-n
//再拆成1-2 vs 3-4, 5-6 vs 7-8,...n-3 - n2 vs n-1 - n, 每组内部进行双指针sort，后合并为1-2-3-4...-n
//再拆成...，每组内...，后合并为1-2-3-4...-n
//最后一次合并之后完成sort
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int n = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null) {
            head = head.next;
            n++;
        }
        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy, curr = dummy.next;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, step);
                curr = split(right, step);
                prev = merge(left, right, prev);
            }
        }
        return dummy.next;
    }
    private ListNode split(ListNode head, int step) {
        if (head == null) return head;
        while (head.next != null && step > 1) {
            head = head.next;
            step--;
        } 
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode curr = prev;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            }
            else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left != null) curr.next = left;
        else if (right != null) curr.next = right;
        while (curr.next != null) curr = curr.next;
        return curr;
    }
}
```