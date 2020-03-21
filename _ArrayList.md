# ArrayList

- Implement List
- set();
- get();
- add(int index, E val);
- add(E val);
- remove(int index);
- isEmpty();
- size();


```java
public class ArrayList<T> implements List {
    private T[] array; //the current maximum capacity is default 10;
    private int size; //the actual count of elements;

    public ArrayList<T>() {
        this.array = new T[10];
        this.size = 0;
    }
    public void add(int index, T val) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        } else {
            if (this.array.length == this.size) { //current capacity reached
                T[] newArray = new T[this.array.length * 1.5]; //expand the capacity of array
                for (int i = 0; i < index;  i++) {
                    newArray[i] = array[i]; //deep copy before index
                }
                for (int i = index + 1; i < this.size + 1; i++) {
                    newArray[i] = array[i - 1]; //deep copy after index
                }
                newArray[index] = val;
                this.array = newArray;
            } else { //current capacity not reached
                for (int i = this.size; i > index; i--) {
                    array[i] = array[i - 1]; //deep copy after index
                }
                this.array[index] = val;
            }
            this.size++;
        }
    }
    public boolean add(T val) {
        if (this.array.length == this.size) { //current capacity reached
            T[] newArray = new T[this.array.length * 1.5]; //expand the capacity of array
            for (int i = 0; i < this.size; i++) {
                newArray[i] = array[i]; //deep copy
            }
            newArray[size] = val;
            this.array = newArray;
        } else { //current capacity not reached
            this.array[size] = val;
        }
        this.size++;
        return true;
    }
    public int size() {
        return this.size;
    }
    public T get(int index) {
        return this.array[index];
    }
    public void set(int index, T val) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        } else {
            this.array[index] = val;
        }
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        } else {
            for (int i = index; i < this.size - 1; i++) {
                array[i] = array[i + 1];
            } 
            this.size--;
            if (this.array.length > this.size * 1.5) {
                T[] newArray = new T[this.size * 1.5];
                for (int i = 0; i < this.size; i++) {
                    newArray[i] = array[i];
                }
                this.array = newArray;
            }
        }
    }
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }
}
```
