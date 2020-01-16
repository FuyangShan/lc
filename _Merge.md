public class Merge{
    public int[] merge(int[] a, int[] b){
        int n1 = a.length, n2 = b.length;
        int[] res = new int[n1+n2];
        int i = 0,j = 0,k = 0;
        while (i < n1 && j < n2){
            if (a[i]<=b[j]) {
                res[k] = a[i];
                i++;
            }else{
                res[k] = b[j];
                j++;
            }
        }
        if(i < n1){
            while(i < n1){
                res[k] = a[i];
                i++;
                k++;
            }
        }
        if(j < n2){
            while(j < n2){
                res[k] = b[j];
                j++;
                k++;
            }
        }
    }
}