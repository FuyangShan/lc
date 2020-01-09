```java
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int i = 0;
        if (n >= 2*k){
            for (i = 0; i + 2 * k <= n; i += 2 * k){
                sb.replace(i, i + k, reverseSubStr(sb.subSequence(i, i + k).toString()));
            }
            if ((n - i) < k){
                sb.replace(i, n, reverseSubStr(sb.subSequence(i, n).toString()));
            }else{
                sb.replace(i, i+k, reverseSubStr(sb.subSequence(i, i+k).toString()));
            }
        } else if (n < 2*k && n >= k){
            sb.replace(0,k,reverseSubStr(sb.subSequence(0,k).toString()));
        } else {
            sb.reverse();
        }
        return sb.toString();
    }
    public String reverseSubStr(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
```