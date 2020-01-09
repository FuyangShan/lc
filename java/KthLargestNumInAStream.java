class KthLargest {
    PriorityQueue<Integer> minHeap;
    int kthValue;
    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue();
        kthValue = k;

        for (int i:nums){
            add(i);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size()>kthValue){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */