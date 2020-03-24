# [138] Copy List with Random Pointer 复制复杂链表（包含一个随机指针）
https://leetcode.com/problems/copy-list-with-random-pointer

问题：

思路：复杂链表，其结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任一结点或者NULL。第一步根据原始链表的每个结点N，创建对应的N’，把N’链接在N的后面；第二步是设置复制出来的链表上的结点的m_pSibling；第三步是把这个长链表拆分成两个：把奇数位置的结点链接起来就是原始链表，把偶数位置的结点链接出来就是复制出来的链表。


```java
//先复制next，再复制random，最后split， 注意原list和新list要分别split

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = new Node(0,null,null);
        dummy.next = head;
        while (head != null) {
            Node newNode = new Node(head.val, head.next, head.random);
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
        head = dummy.next;
        while (head != null && head.next != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }  
            head = head.next.next;
        }
        head = dummy.next;
        dummy.next = head.next;
        while (head != null && head.next != null) {
            Node temp = head.next;
            head.next = head.next.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
```