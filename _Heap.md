# Heap
- A Min-Heap is a complete binary tree in which the value in each internal node is smaller than or equal to the values in the children of that node.
- Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

- Arr[(i - 1) / 2] returns its parent node.
- Arr[(2 * i) + 1] returns its left child node.
- Arr[(2 * i) + 2] returns its right child node

```java
class MinHeap {
	private int[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		heap[0] = Integer.MIN_VALUE;
	}

	//find the parent node value
	private int parent(int pos) {
		return pos / 2;
	}

	//find left/right position
	private int leftChild(int pos) {
		return pos * 2;
	}
	privae int rightChild(int pos) {
		return pos * 2 + 1;
	}

	//find if the position is leaf
	private boolean isLead(int pos) {
		return (pos >= (size / 2) && pos <= size);
	}

	//swap method to heapify the structure
	private void swap(int fpos, int spos) {
		int temp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = temp;
	}

	//heapify the node at pos
	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (Heap[pos] > Heap[leftChild(pos)]
					|| Heap[pos] > Heap[rightChild(pos)]) {
				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	//insert funtion → shift up ??
	public void insert(int element) {
		if (size >= maxsize) {
			return;
		}
		Heap[++size] = element;
		int cur = size;

		while (Heap[cur] < Heap[parent(cur)]) {
			swap(cur, parent(cur));
			cur = parent(cur);
		}
	}

	//function to build the min-heap
	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public int remove() {
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--]; //move the last one up
		minHeapify(FRONT); //then shift down
		return popped;
	}
}
```
