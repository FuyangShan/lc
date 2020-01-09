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