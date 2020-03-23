# LinkedList

## 代表例题

* [206. Reverse List](reverse-list.md)
* [92. Reverse Linked List II](reverse-linked-list-ii.md)
* [24. Swap Pairs](swap-nodes-in-pairs.md)
* [25. Reverse Nodes in k-Group](reverse-nodes-in-k-group.md)
* [22. Merge Two Sorted Lists](merge-two-sorted-lists.md)
* [141. Linked List Cycle](linked-list-cycle.md)
* [142. LinkedList Cycle II](linked-list-cycle-ii.md)
* [138. Copy List with Random Pointer](copy-list-with-random-pointer.md)
* [83. Remove Duplicates from Sorted List](remove-duplicates-from-sorted-list.md)
* [2. Add Two Numbers](add-two-numbers.md)
* [160. Intersection of Two Linked Lists](intersection-of-two-linked-lists.md)
* [148. Sort list](sort-list.md)
* [328. Odd Even Linked List]()
* [237. Delete Node in a Linked List]()
* [19. Remove Nth Node From End of List]()
* [203. Remove Linked List Elements]()
* [82. Remove Duplicates from Sorted List II]()
* [369. Plus One Linked List]()
* [234. Palindrome Linked List]()
* [143. Reorder List]()
* [61. Rotate List]()
* [86. Partition List]()
* [147. Insert sort list]()


## 链表删除

### [203] Remove Linked List Elements 移除链表元素
https://leetcode.com/problems/remove-linked-list-elements

问题：删除链表中等于给定值val的所有节点。
Example:
Given: 1 –> 2 –> 6 –> 3 –> 4 –> 5 –> 6, val = 6
Return: 1 –> 2 –> 3 –> 4 –> 5

思路：非常简单，删除就是把要删除的节点前一个的 next 指向别的，把它自己的 next 连上去。注意删除掉next结点的话就不用prev = prev.next了，删除结点时prev.next发生变化所以不用做什么，只有不删除时才向后移动，否则有可能空指针！

```java
public ListNode removeElements(ListNode head, int val) {
    if (head == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head.next != null) {
        if (head.next.val == val) {
            head.next = head.next.next;
        } else {
            head = head.next;
        }
    }
    return dummy.next;
}
```


### [19] Remove Nth Node From End of List 删除链表中倒数第n个节点
https://leetcode.com/problems/remove-nth-node-from-end-of-list


问题：删除链表中倒数第n个节点。
Example:
Given: 1->2->3->4->5, and n = 2
Return: 1->2->3->5

思路：利用双指针快速定位到要删除节点的位置。先用一个fast指针走n步，然后再来一个slow指针从头开始和fast同时向后走，当fast走到链表末尾的时候，slow指针即为倒数第n个结点。

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || head.next == null || n <= 0) return head;
    // 设立头结点
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // 初始化slow,fast
    ListNode slow = dummy, fast = dummy;
    // fast指针先走n步
    for (int i = 0; i < n; i++) {
        fast = fast.next;
    }
    // 两个指针同时移动直到p2到达最后
    while (fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }
    // 删除并返回
    slow.next = slow.next.next;
    return dummy.next;
}
```

### [83] Remove Duplicates from Sorted List 删除重复元素
https://leetcode.com/problems/remove-duplicates-from-sorted-list

问题：Given a sorted linked list, delete all duplicates such that each element appear only once. For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

思路：从这道题我们可以学习一下删除结点的两种方法，可以说各种所长。

第一种是向后比较结点，发现重复就删掉。因为可能会删掉后面的结点，所以一定要注意cur的判空条件。当正常遍历时，cur可能为空，当删掉了后面结点时cur.next可能为空，都要判断。
第二种是向前比较结点，即用prev记录前一个结点的值，发现相同就删掉当前结点，判空条件简单一些，但一定注意prev和cur的更新。因为这道题肯定不会删除head，所以也就没用到dummy头结点。

```java
// Version-1: Compare cur and cur.next without prev
// Note both cur and cur.next could reach null
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode cur = head;
    while (cur != null && cur.next != null) {
        if (cur.val == cur.next.val) {
            // 直接删除掉后面那个重复的节点，并且cur不变
            cur.next = cur.next.next;
        } else {
            // 只有当比较的两个元素不同，cur才移动到下一个节点
            cur = cur.next;
        }
    }
    return head;
}

// Version-2: compare cur and prev
// Note update of prev and cur
public ListNode deleteDuplicates2(ListNode head) {
    if (head == null || head.next == null) return head;    
    // Invariant: node prior to prev (inclusive) has no duplicates
    ListNode prev = head;    
    ListNode cur = head.next;
    while (cur != null) {
        if (cur.val == prev.val) {
            prev.next = cur.next;
            cur = prev.next;
        } else {
            prev = cur;
            cur = cur.next;
        }
    }
    return head;
}
```

### [82] Remove Duplicates from Sorted List II 删除所有重复元素
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

问题：给定一个有序的链表，删除该链表中所有有重复的节点，重复的结点不保留，返回链表头指针。例如：
给定 1->2->3->3->4->4->5，则返回 1->2->5
给定 1->1->1->2->3，则返回 2->3

思路：因为要删除所有duplicate，而不是只保留一份，所以while循环里必须嵌套循环，发现duplicate就一删到底。如果只用一层循环，那么效果就跟第83题一样了，必须保留一份duplicate，否则下一轮循环时不知道之前重复的是哪个结点。

```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head.next != null && head.next.next != null) {
        if (head.next.val == head.next.next.val) {
            int duplicate = head.next.val;
            while (head.next != null && head.next.val == duplicate) {
                head.next = head.next.next;
            }
        } else {
            head = head.next;
        }
    }
    return dummy.next;
}
```

## 链表反转与旋转

### [206] Reverse Linked List 反转链表
https://leetcode.com/problems/reverse-linked-list

问题：输入一个链表，反转链表后，输出链表的所有元素。

思路：最简单的就是建一个Dummy node，然后不断地将原来List的Node插入到dummy node的后面， 但是这样需要了额外的空间。
更好的方法是用一个variable pre保存前一个node，一个cur保存现在的Node，不断地改变这两个node 的指针关系，并且将pre和cur更新向下两个点。

```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    // 前驱指针prev初始化为空
    ListNode prev = null;
    ListNode cur = head;
    // 访问某个节点cur.next时，要检验cur是否为null
    while (cur != null) {
        ListNode next = cur.next;   // next保存着原来cur.next的地址
        cur.next = prev;            // 使cur指向prev，这样就与后面的链表断开了
        prev = cur;                 // prev指针往后移
        cur = next;                 // cur指针往后移
    }
    // 当cur为null时，prev即为链表尾节点，直接返回作为新反转链表的头
    return prev;
}

// 剑指Offer版本
public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) return head;
    // 逆置后的头结点
    ListNode reversedHead = null;
    ListNode prev = null;
    // 当前头结点
    ListNode cur = head;
    while (cur != null) {
        // 保存后继
        ListNode next = cur.next;

        // next为null的节点为尾节点（翻转后的头结点一定是原始链表的尾结点）
        if (next == null) reversedHead = cur;

        // 逆转的过程，并且能将头结点的 prev 置为 NULL
        cur.next = prev;

        // 指针往后移
        prev = cur; // 前继结点到现任节点，勿忘断链的情形，需要使用 pre 指针保存状态，pre 等价于是后移一个结点
        cur = next; // 现任节点到下一结点，cur 后移一个结点
    }
    return reversedHead;
}

// dummy node
public ListNode reverseList3(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    ListNode cur = head;
    while (cur != null) {
        ListNode next = cur.next;
        cur.next = dummy.next;
        dummy.next = cur;
        cur = next;
    }
    return dummy.next;
}
```

### [92] Reverse Linked List II 反转部分链表
https://leetcode.com/problems/reverse-linked-list-ii

问题：给定了起始位置m和结束位置n，反转这个区间内的链表。

思路：采用头插法，不断地把要反转的节点插到反转区间头节点的前面。重点就是记录第m个结点的前驱结点和第n个结点的后续结点。

```java
public ListNode reverseListBetween(ListNode head, int m, int n) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    // 找反转区间头节点的前驱，即1->2->3->4->5->NULL中的1，循环过后prev指向1、cur指向2
    for (int i = 0; i < m - 1; i++) {
        prev = prev.next;
    }
    // cur此时是反转区间的头节点
    ListNode cur = prev.next;
    // 在指定区间内不断进行反转
    for (int i = 0; i < n - m; i++) {
        ListNode temp = cur.next;
        cur.next = temp.next;       // 越过cur.next，指向cur.next.next，即本来2->3，现在变成了2->4
        temp.next = prev.next;      // temp指向prev.next，即本来3->4，现在变成了3->2
        prev.next = temp;           // 即本来1->2，现在变成了1->3
        // 经过以上步骤变成了1->3->2->4->5
        // 再经过一次最后变成了1->4->3->2->5
    }
    return dummy.next;
}
```

### [24] Swap Nodes in Pairs 成对交换链表节点
https://leetcode.com/problems/swap-nodes-in-pairs

问题：成对交换链表节点。也就是说，节点1、2交换，节点3、4交换，节点5、6交换...
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

思路：每次跳两个节点，后一个接到前面，前一个接到后一个的后面，最后现在的后一个（也就是原来的前一个）接到下下个结点（如果没有则接到下一个）。

```java
public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode l1 = dummy;
    ListNode l2 = head;
    while (l2 != null && l2.next != null) {
        // 保存下一对的首节点
        ListNode temp = l2.next.next;
        l1.next = l2.next;
        l2.next.next = l2;
        l2.next = temp;
        l1 = l2;
        l2 = l2.next;
    }
    return dummy.next;
}
```


### [25] Reverse Nodes in k-Group 每k个节点翻转
https://leetcode.com/problems/reverse-nodes-in-k-group

问题：将链表按每k个一组进行区间内翻转，Swap Nodes in Pairs其实是这道题k=2的特殊情况。

思路：


```java
public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    while (prev != null) {
        // 当return null，说明反转操作已经完成了（不用reverse）
        prev = reverse(prev, k);
    }
    return dummy.next;
}

public ListNode reverse(ListNode prev, int k) {
    ListNode last = prev;
    // last指针往后移动k+1步，也就是位于反转区间后一个位置
    for (int i = 0; i < k + 1; i++) {
        last = last.next;
        // last为null了，反转区间还如果不够k个元素，就返回null
        if (i != k && last == null) return null;
    }
    // 指向反转区间首元素，也就是逆转后的尾元素
    ListNode tail = prev.next;
    // 跨过首元素，从第二个开始进行链表头插，也就是把cur提到tail的前面
    ListNode cur = prev.next.next;
    // 当cur移到last，说明要反转的区间已操作完毕
    while (cur != last) {
        // 暂存next指针
        ListNode next = cur.next;
        // 2->3 变成 2->1
        cur.next = prev.next;
        // dummy->1 变成 dummy->2
        prev.next = cur;
        // 1->2 变成 1->3
        tail.next = next;
        // 接着cur后移，以处理下一个节点
        cur = next;
    }
    // tail将会是下一个子序列的prev
    return tail;
}
```

### [141] Linked List Cycle 判断链表是否有环
https://leetcode.com/problems/linked-list-cycle

问题：给定一个链表，判断该链表是否有环。

思路：快慢指针同时从链表的头结点出发，快指针fast步长为2，慢指针slow步长为1，如不存在环，快指针到达链表尾部遇到null退出；如果存在环，则某个时刻两者一定在环里相遇(fast==slow)。从而检测到链表中有环。

```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        // fast如果和slow相遇了，证明有环
        if (slow == fast) return true;
    }
    // fast如果走到了null，证明没有环
    return false;
}
```

### [142] Linked List Cycle II 找到环中的第一个节点
https://leetcode.com/problems/linked-list-cycle-ii
https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4

问题：如果一个链表中包含环，请找出该链表的环的入口结点。

思路：前面还是一样，让快慢指针同时走直到在环内相遇。接下来，让快指针回到链表的头部重新走，步长变成了1，那么当两者再次相遇的时候，就是环路的入口了。

```java
public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) return null;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        // 如果相遇了
        if (fast == slow) {
            // 从头有个指针开始走了
            ListNode slow2 = head;
            // 两个指针相遇时也就刚好到达了环的第一个节点，参照博客分析
            while (slow != slow2) {
                slow = slow.next;
                slow2 = slow2.next;
            }
            return slow;
        }
    }
    return null;
}
```

## 链表排序

### [148] Sort List 链表排序
https://leetcode.com/problems/sort-list

问题：排序一个链表，时间复杂度为O(nlogn)。

思路：题目限定了时间必须为O(nlogn)，符合要求只有快速排序，归并排序，堆排序，而根据单链表的特点，最适于用归并排序。

```java
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;    // 如果为空或只有一个点，直接return
    ListNode mid = findMiddle(head);        // 找中点
    ListNode right = sortList(mid.next);    // 对mid的右边链表先排序
    mid.next = null;                        // 这时候才把它断开
    ListNode left = sortList(head);         // 再对mid的左边链表排序
    return merge(left, right);
}

private ListNode findMiddle(ListNode head) {   // 快慢指针
    ListNode slow = head, fast = head.next;    // 因为不知道新的头是谁，所以要使用dummy node
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}

private ListNode merge(ListNode head1, ListNode head2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;     // 尾指针指向dummy node
    while (head1 != null && head2 != null) {    // 两个头是否为空
        if (head1.val < head2.val) {  // 如果左边的头小
            tail.next = head1;     // 把左边头放到tail里
            head1 = head1.next;
        } else {                        // 如果右边的头小
            tail.next = head2;     // 把右边头放到tail里
            head2 = head2.next;
        }
        tail = tail.next;  //tail往后移
    }
    if (head1 != null) {        // 看左边头还是右边头没分完就分过去
        tail.next = head1;
    } else {
        tail.next = head2;
    }
    return dummy.next;
}
```

### [147] Insertion Sort List 链表插入排序
https://leetcode.com/problems/insertion-sort-list

问题：使用插入排序来排序一个链表。

思路：数组版本的插入排序会不断向前比较，找到合适位置后右移其他大于当前的数据，然后再处理下一个。而链表版本则有两点不同：一是单向链表没法向前比较，所以变通一下，我们每次都从头往后比较，找到大于当前结点值的位置；其二是把当前结点插入到那个位置的操作可以说是普通插入的复杂版本，因为插入的元素本身也有前后结点连接着。所以，遍历当前结点的指针和前面找位置的指针都必须是前一个结点（prev），否则会产生Cycle导致死循环。还有个有趣的现象是，当把插入完成后，当前结点无需移动，因为后面的元素在一点点减少，循环会自己中止的。但注意如果当前结点在前半部分已是最大，无需移动时，这时需要手动移动当前指针以防死循环。

```java
public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = head;
    ListNode temp = null, prev = null;
    while (cur != null && cur.next != null) {
        if (cur.val <= cur.next.val) {
            cur = cur.next;
        } else {
            temp = cur.next;
            cur.next = temp.next;
            prev = dummy;
            while (prev.next.val <= temp.val) {
                prev = prev.next;
            }
            temp.next = prev.next;
            prev.next = temp;
        }
    }
    return dummy.next;
}

public ListNode insertionSortList2(ListNode head) {
    if (head == null) return null;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode cur = head;
    while (cur.next != null) {
        // Find where to insert cur.next, or stop at cur
        ListNode pos = dummy;
        while (pos.next.val < cur.next.val) {
            pos = pos.next;
        }
        //  pos(a),pos.next(b),...cur(c),cur.next(d),cur.next.next(e)
        //  => a,d,b,...,c,e
        if (pos != cur) {
            ListNode tmp = pos.next;
            pos.next = cur.next;
            cur.next = cur.next.next;
            pos.next.next = tmp;
        } else {
            cur = cur.next;
            // error1: cur.next is updated already above, but it must update here!
        }
    }
    return dummy.next;
}
```

## 链表操作

### [143] Reorder List 重排链表
https://leetcode.com/problems/reorder-list

问题：Given a singly linked list L: L0→L1→…→L(n-1)→Ln, reorder it to: L0→Ln→L1→L(n-1)→L2→L(n-2)→…
For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.

思路：这是一道比较综合的链表操作的题目，要按照题目要求给链表重新连接成要求的结果。其实理清思路也比较简单，分三步完成：（1）将链表切成两半，也就是找到中点，然后截成两条链表；（2）将后面一条链表进行reverse操作，就是反转过来；（3）将两条链表按顺序依次merge起来。

```java
public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode temp = null;
    ListNode slow = head, fast = head;
    ListNode l1 = head;
    while (fast != null && fast.next != null) {
        temp = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    // 截断后半部分
    temp.next = null;
    ListNode l2 = reverse(slow);
    merge(l1, l2);
}

public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}

public void merge(ListNode l1, ListNode l2) {
    while (l1 != l2) {
        ListNode n1 = l1.next;
        ListNode n2 = l2.next;
        l1.next = l2;
        if (n1 == null) break;
        l2.next = n1;
        l1 = n1;
        l2 = n2;
    }
}
```

### [61] Rotate List 旋转链表
https://leetcode.com/problems/rotate-list

问题：把后k个rotate到list前面去，k可以超过list本身长度。
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

思路：用walker-runner定位到要旋转的那个结点，然后将下一个结点设为新表头，并且把当前结点设为表尾。

```java
public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    ListNode index = head;
    int len = 1;
    // 得到链表长度
    while (index.next != null) {
        index = index.next;
        len++;
    }
    // 因为k可能大于链表长度len，所以需要取余处理
    k %= len;

    // 链表首尾连成一个环
    index.next = head;
    // 得到新的链表头
    for (int i = 1; i < len - k; i++) {
        head = head.next;
    }
    // res是新的head
    ListNode res = head.next;
    // 断开环
    head.next = null;
    return res;
}
```

### [86] Partition List 划分链表
https://leetcode.com/problems/partition-list

问题：划分一个链表，把所有小于给定值的节点都移到前面，大于该值的节点顺序不变。

思路：使用两个链表，p1和p2，以此遍历原链表，如果节点的值小于x，就挂载到p1下面，反之则放到p2下面，最后将p2挂载到p1下面就成了。

```java
public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) return head;
    ListNode smallerHead = new ListNode(0);
    ListNode greaterHead = new ListNode(0);
    ListNode smaller = smallerHead;
    ListNode greater = greaterHead;
    while (head != null) {
        ListNode temp = new ListNode(head.val);
        if (head.val < x) {
            smaller.next = temp;
            smaller = smaller.next;
        } else {
            greater.next = temp;
            greater = greater.next;
        }
        head = head.next;
    }
    smaller.next = greaterHead.next;
    return smallerHead.next;
}
```

### [328] Odd Even Linked List 奇偶链表
https://leetcode.com/problems/odd-even-linked-list

问题：给我们一个链表，分开奇偶节点（奇偶指的是节点位置而不是节点上的值），所有奇节点在前，偶节点在后。例如，给出链表1->2->3->4->5->NULL，应返回链表1->3->5->2->4->NULL。

思路：新建两个链表，分别存储奇数位置和偶数位置的节点，最后将两个链表接上，得到的结果即为所求。
这种不是删除结点而是移动重新插入结点的问题要注意：prev/cur等游标指针的移动，是不是后面结点被移走了就不用移动了，是不是后面结点移走了就null了等等。

```java
public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;
    // 因为odd肯定在even之前，所以只需要判断even和even.next不为空就可以
    while (even != null && even.next != null) {
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    // 偶链表连在奇链表后面
    odd.next = evenHead;
    return head;
}
```

### [725] Split Linked List in Parts 拆分链表成k部分
https://leetcode.com/problems/split-linked-list-in-parts

问题：给我们一个链表和一个正数k，让我们分割链表成k部分，尽可能的平均分割，如果结点不够了，就用空结点。平均分后多出来的节点优先分配给前面的部分。

思路：常规的链表操作题。

```java
public ListNode[] splitListToParts(ListNode root, int k) {
    ListNode[] res = new ListNode[k];

    int len = 0;
    for (ListNode cur = root; cur != null; cur = cur.next) len++;

    int part = len / k;
    int surplus = len % k;
    ListNode head = root;
    ListNode prev = null;
    for (int i = 0; i < k; i++, surplus--) {
        res[i] = head;
        // 多的部分有k+1个，少的部分有k个
        for (int j = 0; j < part + (surplus > 0 ? 1 : 0); j++) {
            prev = head;
            head = head.next;
        }
        // 与后面部分断开
        if (prev != null) prev.next = null;
    }
    return res;
}
```

### [234] Palindrome Linked List 判断链表是否是回文串
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

## 进位加法

### [2] Add Two Numbers 两个链表相加
https://leetcode.com/problems/add-two-numbers

问题：给定两个链表分别代表两个非负整数。数位以倒序存储，并且每一个节点包含一位数字。将两个数字相加并以链表形式返回。

思路：

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int sum = 0;
    while (l1 != null || l2 != null) {
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }
        cur.next = new ListNode(sum % 10);
        sum /= 10;
        cur = cur.next;
    }
    if (sum == 1) cur.next = new ListNode(1);
    return dummy.next;
}
```

### [445] Add Two Numbers II 两个链表倒序相加
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

## 链表合并

### [21] Merge Two Sorted Lists 合并两个有序链表

问题：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

思路：

```java
public ListNode Merge(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    else if (list2 == null) return list1;

    // 新建一个头节点，用来存合并的链表
    ListNode dummy = new ListNode(0);
    dummy.next = null;
    ListNode head = dummy;
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            head.next = list1;
            head = list1;
            list1 = list1.next;
        } else {
            head.next = list2;
            head = list2;
            list2 = list2.next;
        }
    }

    // 把未结束的链表连接到合并后的链表尾部
    if (list1 != null) head.next = list1;
    if (list2 != null) head.next = list2;
    return dummy.next;
}
```

### [23] Merge k Sorted Lists 合并k个有序链表
https://leetcode.com/problems/merge-k-sorted-lists

问题：

思路：
```java
public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode(0);
    if (lists == null || lists.length == 0) return dummy.next;

    int len = lists.length;
    ListNode cur = dummy;
    PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    });
    // 把所有List的首节点（如果不为空）都放入优先队列中
    for (int i = 0; i < len; i++) {
        if (lists[i] != null) {
            queue.add(lists[i]);
        }
    }
    while (queue.size() != 0) {
        // 从优先队列中取出一个最小的
        ListNode node = queue.poll();
        cur.next = node;
        cur = cur.next;
        if (node.next != null) queue.add(node.next);
    }
    return dummy.next;
}
```

### [160] Intersection of Two Linked Lists 两个相交链表的交点
https://leetcode.com/problems/intersection-of-two-linked-lists

问题：找出两个单链表相交的开始处。

思路：两个单链表相交只可能为“>-”型，因为单链表只有一个next指针。如果两个单链表有共同的节点，那么从第一个共同节点开始，后面的节点都会重叠，直到链表结束。
因此我们分别从head1,head2开始遍历两个链表获得其长度len1与len2。假设len1>=len2，那么指针p1由head1开始向后移动len1-len2步。指针p2=head2，下面p1、p2每次向后前进一步并比较p1和p2是否相等，如果相等即返回该结点，否则说明两个链表没有交点。

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode nodeA = headA, nodeB = headB;
    int lenA = 0, lenB = 0;
    // 计算链表A的长度
    while (nodeA != null) {
        nodeA = nodeA.next;
        lenA++;
    }
    // 计算链表B的长度
    while (nodeB != null) {
        nodeB = nodeB.next;
        lenB++;
    }
    // 让较长的链表先飞一会
    for (int i = 0; i < Math.abs(lenA - lenB); i++) {
        if (lenA < lenB) headB = headB.next;
        else if (lenA > lenB) headA = headA.next;
    }
    while (headA != null && headB != null) {
        if (headA == headB) return headA;
        headA = headA.next;
        headB = headB.next;
    }
    return null;
}
```


### [138] Copy List with Random Pointer 复制复杂链表（包含一个随机指针）
https://leetcode.com/problems/copy-list-with-random-pointer

问题：

思路：复杂链表，其结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任一结点或者NULL。第一步根据原始链表的每个结点N，创建对应的N’，把N’链接在N的后面；第二步是设置复制出来的链表上的结点的m_pSibling；第三步是把这个长链表拆分成两个：把奇数位置的结点链接起来就是原始链表，把偶数位置的结点链接出来就是复制出来的链表。

```java
public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode iter = head, next;

    // First round: make copy of each node,
    // and link them together side-by-side in a single list.
    while (iter != null) {
        next = iter.next;

        RandomListNode copy = new RandomListNode(iter.label);
        iter.next = copy;
        copy.next = next;

        iter = next;
    }

    // Second round: assign random pointers for the copy nodes.
    iter = head;
    while (iter != null) {
        if (iter.random != null) {
            iter.next.random = iter.random.next;
        }
        iter = iter.next.next;
    }

    // Third round: restore the original list, and extract the copy list.
    iter = head;
    RandomListNode pseudoHead = new RandomListNode(0);
    RandomListNode copy, copyIter = pseudoHead;

    while (iter != null) {
        next = iter.next.next;

        // extract the copy
        copy = iter.next;
        copyIter.next = copy;
        copyIter = copy;

        // restore the original list
        iter.next = next;

        iter = next;
    }

    return pseudoHead.next;
}

### [109] Convert Sorted List to Binary Search Tree 有序链表转BST

问题：将一个排好序的链表转成一个平衡二叉树。

思路：对于一个二叉树来说，左子树一定小于根节点，而右子树大于根节点。所以我们需要找到链表的中间节点，这个就是根节点，链表的左半部分就是左子树，而右半部分则是右子树，我们继续递归处理相应的左右部分，就能够构造出对应的二叉树了。
这题的难点在于如何找到链表的中间节点，我们可以通过fast，slow指针来解决，fast每次走两步，slow每次走一步，fast走到结尾，那么slow就是中间节点了。
取中点作为当前函数的根。这里的问题是对于一个链表我们是不能常量时间访问它的中间元素的，这时候就要利用到树的中序遍历了，按照递归中序遍历的顺序对链表结点一个个进行访问，而我们要构造的二分查找树正是按照链表的顺序来的。思路就是先对左子树进行递归，然后将当前结点作为根，迭代到下一个链表结点，最后再递归求出右子树即可。整体过程就是一次中序遍历，时间复杂度是O(n)，空间复杂度是栈空间O(logn)。

```java
public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return new TreeNode(head.val);

    return build(head, null);
}

private TreeNode build(ListNode start, ListNode end) {
    if (start == end) return null;

    ListNode fast = start;
    ListNode slow = start;
    // fast走到结尾，那么slow就是中间节点了，即BST的根节点
    while (fast != end && fast.next != end) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // 递归处理相应的左右部分，链表的左半部分就是左子树，而右半部分则是右子树
    TreeNode node = new TreeNode(slow.val);
    node.left = build(start, slow);
    node.right = build(slow.next, end);

    return node;
}
```

### [面试题13] 在O(1)时间内删除链表节点
问题：只给定单链表中某个结点p(并非最后一个结点)，删除该结点。

思路：首先是放p中数据，然后将p.next的数据复制到p中，接下来删除p.next即可。

```java
public void deleteNode(ListNode head, ListNode toBeDeleted) {
    if (head == null || toBeDeleted == null) return;

    // 链表有多个节点，要删除的结点不是尾结点: O(1) 时间
    if (toBeDeleted.next != null) {
        ListNode next = toBeDeleted.next;
        toBeDeleted.val = next.val;
        toBeDeleted.next = next.next;
        next = null;
    } else if (head == toBeDeleted) {
        // 链表只有一个结点，删除头结点（也是尾结点）:O(1) 时间
        toBeDeleted = null;
        head = null;
    } else {
        // 链表有多个节点，要删除的是尾节点: O(n) 时间
        ListNode temp = head;
        while (temp.next != toBeDeleted) {
            temp = temp.next;
        }
        temp.next = null;
    }
}
```

### [面试题15] 链表中倒数第k个结点
https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a

问题：输入一个链表，输出该链表中倒数第k个结点。

思路：使用两个节点p1和p2，快指针先从表头走k-1步，从第k步开始两个快慢指针一起走，直到快指针走到尾节点退出while循环。由于两个指针的距离保持在k-1，当快指针到达链表的尾结点时，慢指针正好是倒数第k个结点。注意：k大于链表长度的情况要返回null。

```java
public ListNode findKthToTail(ListNode head, int k) {
    if (head == null || k < 1) return null;
    ListNode fast = head;
    ListNode slow = head;
    for (int i = 0; i < k - 1; i++) {
        // 链表节点数可能小于k
        if (fast.next != null)
            // 快指针先走k-1步
            fast = fast.next;
        else
            return null;
    }
    // 快指针走到尾节点就退出循环
    while (fast.next != null) {
        // 从第k步开始，两个指针一起走
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
}
```

### [面试题5] 从尾到头打印链表
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

解题技巧
slow，fst双指针，因为链表无法得知长度，所以尝试用这种方法来达到某种效果（长度、检测环等）
对于涉及链表长度的问题，往往会通过两个指针进行几何变换来得到想要的差额==要好好画图理解思考
使用一些临时变量来存储next指针，以完成插入删除等操作
对于插入和删除等操作，往往需要一个额外的指针来记录其前面的节点，再编程之前好好思考其间关系效果会比较好
对一些依赖于后面节点才可以完成的操作，使用递归的方式来解决
对于有些题目提前使用循环获得其链表的长度也是一种有效的方法
对于要考虑最后几个节点的操作，有事可以再遍历之前先将头指针向后移动k个节点
插入、删除操作往往需要使用目标节点前面的节点，所以往往会定义一个新的链表节点其next指针指向head节点

作者：野狗子嗷嗷嗷
链接：https://www.jianshu.com/p/490cb181946f
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。