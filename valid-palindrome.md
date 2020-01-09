```java
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++; j--;
        }
        return true;
    }
}
```