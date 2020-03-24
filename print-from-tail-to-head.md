# Print From tail to head
https://www.nowcoder.com/questionTerminal/d0267f7f55b3412ba93bd35cfa8e8035

问题：输入一个链表，从尾到头打印链表每个节点的值。

思路：

```java
/**
 * 用栈保存遍历结果
 */
public List<Integer> printListFromTailToHead(ListNode head) {
    List<Integer> results = new ArrayList<>();
    if (head == null) return results;
    Stack<Integer> stack = new Stack<>();
    ListNode node = head;
    // 只要链表未到达表尾
    while (node != null) {
        // 就依次遍历链表并添加到Stack中
        stack.push(node.val);
        node = node.next;
    }
    // 只要栈不空
    while (!stack.isEmpty()) {
        // 就不断地将元素添加到List中，并出栈
        results.add(stack.pop());
    }
    return results;
}

/**
 * 头插法
 */
public List<Integer> printListFromTailToHeadToucha(ListNode head) {
    ArrayList<Integer> results = new ArrayList<>();
    if (head == null) return results;
    ListNode node = head;
    while (node != null) {
        // 头插法
        results.add(0, node.val);
        node = node.next;
    }
    return results;
}

/**
 * 递归
 */
public List<Integer> printListFromTailToHeadRec(ListNode head) {
    List<Integer> results = new ArrayList<>();
    if (head == null) return results;
    dfs(head, results);
    return results;
}

private void dfs(ListNode head, List<Integer> results) {
    if (head != null) {
        if (head.next != null) {
            // 因为要反过来输出链表，所以先递归输出后面的节点
            dfs(head.next, results);
        }
        // 再输出自身
        results.add(head.val);
    }
}
```