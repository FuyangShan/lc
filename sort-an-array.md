# Sort an Array
Given an array of integers nums, sort the array in ascending order.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]

```java

// Selection Sort
// Select the minimum number from array and swap it with the head of list, repeat the process moving towards end.
class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            this.swap(nums,i,min);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//Insersion Sort
//
class Solution {
    public int[] sortArray(int[] arr) {
        for (int i = 1; i < arr.length; i++){
            int j = i - 1;
            int current = arr[i];
            while (j >= 0 && arr[j] > current){
                arr[j+1] = arr[j];
                j--; 
            }
            arr[j+1] = current;
        }
        return arr;
    }
}

//Merge Sort
class Solution {
    public int[] sortArray(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr;
        }
        int n1 = n/2;
        int n2 = n - n/2;
        int[] left  = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++){
            left[i] = arr[i];
        } 
        for (int j = 0; j < n2; j++){
            right[j] = arr[j + n1];
        }
        return merge(sortArray(left),sortArray(right));
        
    }   
    public int[] merge(int[] left, int[] right){
        int i = 0,j = 0, count = 0;
        int[] res = new int[left.length + right.length];
        while (i < left.length && j < right.length){
            if (left[i] > right[j]){
                res[count] = right[j];
                count++;
                j++;
            } else {
                res[count] = left[i];
                count++;
                i++;
            }
        }
        if (i < left.length){
            while (i<left.length){
                res[count]=left[i];
                i++;
                count++;
            }
        } 
        if (j < right.length){
            while (j<right.length){
                res[count]=right[j];
                j++;
                count++;
            }
        }
        return res;
    }    
}

//Quick Sort
class Solution {
    int[] arr;
    public int[] sortArray(int[] arr) {
        this.arr = arr;
        sort(0,arr.length - 1);
        return arr;
    }
    public void sort(int l, int r){
        if (l < r){
            int pi = partition(l,r);
            sort(l,pi - 1);
            sort(pi+1,r);
        }
    }
    public int partition(int l,int r){
        int pivot = arr[r];
        int i = l - 1;
        for (int j = i + 1; j < r; j++){
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }
} */

//HeapSort
class Solution {
    int[] arr;
    public int[] sortArray(int[] arr) {
        this.arr = arr;
        sort(arr);
        return arr;
    }
    public void sort(int[] arr){
        int n = arr.length;
        for (int i = n/2 - 1; i >= 0; i--){
            heapify(arr,n,i);
        }
        for (int i = n - 1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,i,0);
        }
    }
    public void heapify(int[] arr, int n, int i){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]){
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]){
            largest = r;
        }
        if (largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr,n,largest);
        }
    }
}

//Bubble Sort
class Solution {
    int[] arr;
    public int[] sortArray(int[] nums) {
        this.arr = nums;
        sort(arr);
        return arr;
    }
    public void sort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1;i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
} 

//Count Sort
class Solution {
    int[] arr;
    public int[] sortArray(int[] nums) {
        this.arr = nums;
        return sort(arr);
    }
    public int[] sort(int[] arr){
        // get the max and min of arr
        int max = Arrays.stream(arr).max().getAsInt(); 
        int min = Arrays.stream(arr).min().getAsInt(); 
        int range = max - min + 1; 
        // create a count array
        int[] count= new int[range]; 
        // create a output array
        int[] output = new int[arr.length];
        Arrays.fill(count, 0);

        //store count of occurence of each element from arr into count array 
        for (int i = 0; i < arr.length;i++){
            count[arr[i] - min]++;
        }

        //store the actual position of each element in arr
        for (int i = 1; i < range; i++){
            count[i] += count[i-1];
        }

        //put the element to the actual position in the output array
        for (int i = 0; i < arr.length; i++){
            count[arr[i]-min]--;
            output[count[arr[i]-min]] = arr[i];
        }
        return output;
    }
} 
```
