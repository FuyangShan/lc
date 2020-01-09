# Decode ways
- A message containing letters from A-Z is being encoded to numbers using the following mapping:

>'A' -> 1
>'B' -> 2
>...
>'Z' -> 26

### Q: Given a non-empty string containing only digits, determine the total number of ways to decode it.

>Example 1:

>Input: "12"
>Output: 2
>Explanation: It could be decoded as "AB" (1 2) or "L" (12).
>Example 2:

>Input: "226"
>Output: 3
>Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

```java
// DP
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        // f[i] = decoding ways of first i num 
        int[] f = new int[n+1];
        // init, 
        f[0] = 1;
        f[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            // 123245...45XY
            // there are two possible ways to decode : f[i - 1], f[i - 2]
            // 123245...45X + Y, 123245...45 + XY
            int last = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            // last num & last 2nd num must be legal
            // f[i] = {f[i-1] | isValid(last) + f[i-2] | isValid(second)}
            if(last > 0) 
                f[i] += f[i-1];  
            if(second >= 10 && second <= 26) 
                f[i] += f[i-2];
        }
        // res = f[n];
        return f[n];
    }
}
```