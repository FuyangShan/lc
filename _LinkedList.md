//Implement List
//set();
//get();
//add(int index, E val);
//add(E val);
//remove(int index);
//isEmpty();
//size();

//Design a LinkedList with ListNode
public class LinkedList<E>{
    private ListNode head;
    private ListNode tail;
    private int size;
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public void addHead(E val) {
        ListNode node = new ListNode(val);
        if (this.size == 0) {
            tail = node;
        } else {
            node.next = head;
            head.pre = node;
        }
        head = node;
        size++;
    }
    public void addTail(E val) {
        ListNode node = new ListNode(val);
        if (this.size == 0) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }
    public void add(int index, E val) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        } else {
            if (index == 0) { //call addHead;
                this.addHead(val);
            } else if (index == size - 1) { //call addTail
                this.addTail(val);
            } else {
                ListNode node = new ListNode(val);
                ListNode prev = head;
                for (int i = 0; i < index - 1; i++) {
                    prev = prev.next;
                }
                ListNode curr = prev.next;
                prev.next = node;
                node.pre = prev;
                node.next = curr;
                curr.pre = node;
            }
            this.size++;
        }
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    public void set(int index, T val) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        } else {
            ListNode curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            curr.val = val;
        }
    }
    public int size() {
        return size;
    }
}
