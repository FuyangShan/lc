```java
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int i = 0, sum = 0, sign = 1;
        
        //remove leading spaces
        while (i < str.length() && str.charAt(i) == ' ') i++;
        
        // get sign "+" or "-"
        if (i < str.length() && (str.charAt(i) == '+'|| str.charAt(i) == '-')) {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        
        // numbers start from index i;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            sum = sum * 10 + (str.charAt(i++) - '0');
        }
        return sum * sign;
    }
}
```