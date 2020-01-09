class Solution {
    public int findKthLargest(int[] nums, int k) {
        //维护一个size为K的最小堆；
        PriorityQueue<Integer> elements = new PriorityQueue();
        for (int num:nums){
            elements.add(num);
            if (elements.size()>k) elements.poll();
        }
        return elements.peek();
    }
}