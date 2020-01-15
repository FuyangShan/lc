class ListNode {
    int k;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int k, int val) {
        this.k = k;
        this.val = val;
        prev = null;
        next = null;
    }
}
class LRUCache {

    private int count;
    private int capacity;
    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map;
    
    public LRUCache(int capacity) {
        int count = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        ListNode curr = map.get(key);
        if (curr == null) return -1;
        else {
            moveToHead(curr);
            return curr.val;
        }
    }
    
    public void put(int key, int value) {
        
        ListNode curr = map.get(key);
        if (curr == null) {
            count++;
            ListNode newNode = new ListNode(key,value);
            map.put(key, newNode);
            addNode(newNode);
            if(count > capacity) {
                int lastKey = tail.prev.k;
                map.remove(lastKey);
                removeTail();
                count--;
            }
        } else {
            curr.val = value;
            moveToHead(curr);
        }
    }
    //add new node right after head
    public void addNode(ListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    //move node to head
    public void removeTail() {
        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
        tail.val = 0;
    }
    private void moveToHead(ListNode node) {
        remove(node);
        addNode(node);
    }
    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
}
