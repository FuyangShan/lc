//[3,2,4,1]
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int i = A.length; i > 1; i--){
            int maxIndex = largestIndex(A,i);
            reverse(A, maxIndex+1);
            reverse(A, i);
            if (maxIndex > 0) res.add(maxIndex+1);
            res.add(i);
        }
        return res;

    }
    // find the largest number index in first k elements
    public int largestIndex(int[] arr,int k){
        int max = 0;
        for (int i = 0; i < k; i++){
            if (arr[i] > arr[max]) max = i;
        }
        return max;
    }
    // reverse first k elements of arr
    public void reverse(int[] arr,int k){
        int[] temp = new int[k];
        for (int i = 0; i < k; i++){
            temp[i] = arr[i];
        }
        int j = 0;
        for (int i = k-1; i >= 0; i--){
            arr[i] = temp[j];
            j++;
        }
    }
}