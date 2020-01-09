```java
class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public MyQueue() {
        stackA = new Stack<Integer>();
        stackB = new Stack<Integer>();

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackB.isEmpty()){
            this.stackATostackB();
        }
        return stackB.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stackB.isEmpty()){
            this.stackATostackB();
        }
        return stackB.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stackA.isEmpty() && stackB.isEmpty()) {
            return true;
        }else{
            return false;
        }
        

    }
    public void stackATostackB(){
        while(! stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```