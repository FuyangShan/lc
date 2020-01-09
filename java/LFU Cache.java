class LFUCache {
    class Node {
        int key, value, freq;
        Node prev, next;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }
    class DLList {
        Node head, tail;
        int size;
        DLList () {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        void add(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;
        }
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            else return null;
        }
    }
    int capacity, size, min;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLList> listMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        listMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = nodeMap.get(key);
        if (node != null) { //key exists
            node.value = value;
            update(node);
        } else { //key doesn't exists
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            if (size == capacity) { //if size reach capapcity, remove the lastList's tail, and remove the node in nodeMap;
                DLList lastList = listMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1; //new key added, first used
            DLList newList = listMap.getOrDefault(1, new DLList());
            newList.add(newNode);
            listMap.put(1, newList);
        }
    }
    private void update(Node node) {
        DLList oldList = listMap.get(node.freq);
        oldList.remove(node);
        if (node.freq == min && oldList.size == 0) min++;
        node.freq++;
        DLList newList = listMap.getOrDefault(node.freq, new DLList());
        newList.add(node);
        listMap.put(node.freq, newList);
    }
}