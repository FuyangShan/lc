public class MergeSort{
    public int[] merge(int[] arr){
        sort(arr, 0, arr.length - 1);
        return arr;
    }
    public void merge(int[] arr,int l,int m,int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int k = l;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) left[i] = arr[i + l];
        for (int j = 0; j < n2; j++) right[j] = arr[j + m + 1];
        int i = 0,j = 0;
        while (i < n1 && j < n2){
            if (left[i] < right[j]){
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < n1){
            arr[k++] = left[i++];
        }

    }
    public void sort(int[] arr,int l, int r){
        if (l < r){
            int m = l + (r - l)/2;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
}
