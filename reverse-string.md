```java
class Solution {
    public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length-1; i >= 0; i--){
            sb.append(s[i]);
        }
        sb.getChars(0, sb.length()-1, s, 0);
        
    }
}
```