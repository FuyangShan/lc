```java
class MedianFinder {

    private PriorityQueue<Integer> left; //maxHeap
    private PriorityQueue<Integer> right; //minHeap
    int count;
    
    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> (b - a));
        right = new PriorityQueue<>();
        count = 0;
    }
    
    public void addNum(int num) {
        if (left.size() == 0 && right.size() == 0) right.add(num);
        else if (left.size() == 0) {
            right.add(num);
            left.add(right.poll());
        } else {
            if (num > right.peek()) {
                right.add(num);
                if (right.size() - left.size() > 1) left.add(right.poll());
            } else {
                left.add(num);
                if (left.size() - right.size() > 1) right.add(left.poll());
            }
        }
        count++;
    }
    
    public double findMedian() {
        if (count % 2 == 0) return ((double)left.peek() + (double)right.peek()) / 2.0;
        else {
            if (left.size() > right.size()) return (double)left.peek();
            else return (double)right.peek();
        }
    }
}
```