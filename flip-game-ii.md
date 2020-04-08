```java
class Solution {
    
    HashMap<String, Boolean> map = new HashMap<>();
    
    public boolean canWin(String s) {
        
        if (s == null || s.length() < 2) return false;
        
        if (map.containsKey(s)) return map.get(s);
        
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                if (!canWin(new String(chars))) {
                    chars[i] = '+';
                    chars[i + 1] = '+';
                    map.put(new String(chars), true);
                    return true;
                }
                chars[i] = '+';
                chars[i + 1] = '+';
            }
        }
        
        map.put(new String(chars), false);
        return false;
    }
}
```