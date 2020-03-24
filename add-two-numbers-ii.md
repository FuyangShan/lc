# [445] Add Two Numbers II 两个链表倒序相加
https://leetcode.com/problems/add-two-numbers-ii

问题：

思路：

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    while (l1 != null) {
        s1.push(l1.val);
        l1 = l1.next;
    }
    while (l2 != null) {
        s2.push(l2.val);
        l2 = l2.next;
    }

    int cn = 0;
    while (!s1.isEmpty() || !s2.isEmpty()) {
        int val = cn;
        if (!s1.isEmpty()) {
            val += s1.pop();
        }
        if (!s2.isEmpty()) {
            val += s2.pop();
        }
        // 产生进位cn
        cn = val / 10;
        val = val % 10;
        stack.push(val);
    }

    // 当l1、l2都到达链表尾且有进位时
    if (cn != 0) stack.push(cn);

    while (!stack.isEmpty()) {
        cur.next = new ListNode(stack.pop());
        cur = cur.next;
    }

    return dummy.next;
}
```