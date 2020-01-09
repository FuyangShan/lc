# Merge K sorted lists
- Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

> Example:

> Input:
> [
>	1->4->5,
>	1->3->4,
>	2->6
> ]
> Output: 1->1->2->3->4->4->5->6

```java
//BFS, minHeap
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        //maintain a minHeap comparing node's value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        //add all nodes in minHeap
        for (ListNode node : lists) if (node != null) pq.offer(node);
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        //add the following node when polling front node
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            prev.next = curr;
            prev = curr;
            if (curr.next != null) pq.offer(curr.next);
        }
        
        return dummy.next;
    }
}

//Recursive, divide and conquer
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        merge(lists, dummy);
        return dummy.next;
    }
    public void merge(ListNode[] lists, ListNode dummy) {
        int n = lists.length;
        if (n == 1) { //base case, all lists merged into 1 ListNode
            dummy.next = lists[0];
            return;
        }
        ListNode[] newLists = new ListNode[(n + 1) / 2];
        //merge two ListNode in one
        for (int i = 0; i < n; i += 2) {
            if (i == n - 1) newLists[i / 2] = mergeTwoLists(lists[i], null);
            else newLists[i / 2] = mergeTwoLists(lists[i], lists[i + 1]);
        }
        merge(newLists, dummy); //recursive merge
    }
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (a != null || b != null) {
            if (a == null) {
                prev.next = b;
                b = b.next;
            } else if (b == null) {
                prev.next = a;
                a = a.next;
            }  else {
                if (a.val < b.val) {
                    prev.next = a;
                    a = a.next;
                } 
                else {
                    prev.next = b;
                    b = b.next;
                }
            }
            prev = prev.next; 
        }
        return dummy.next;
    }
}
```
