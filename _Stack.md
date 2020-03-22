# Stack

```java
public class MyStack {
	private int size;
	private long[] stackArray;
	private int top;

	public MyStack(int s) {
		size = s;
		stackArray = new long[size];
		top = -1;
	}

	public void push(long j) {
		stackArray[++top] = j;
	}

	public long pop() {
		stackArray[top--] = j;
	}

	public long peek() {
		stackArray[top] = j;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top = size - 1;
	}

	public int size() {
		return top + 1;
	}
}
```
