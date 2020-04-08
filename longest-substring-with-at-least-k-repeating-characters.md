```java
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) return 0;
        
        // save freq of each char of string in array
        int[] map = new int[26];
        for (char c : s.toCharArray()) map[c - 'a']++;
        
        // validate this string, if true return len(s)
        boolean isValid = true;
        for (int freq : map) 
            if (freq > 0 && freq < k) isValid = false;
        if (isValid) return s.length();
        
        // otherwise split the string with infrequent char, then validate each substring
        int result = 0;
        int start = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map[s.charAt(j) - 'a'] < k) { // s[j] is a invalid char, recursively call this method for [start, j]
                result = Math.max(result, longestSubstring(s.substring(start, j), k));
                start = j + 1; // continue call F[j + 1, ...]
            }
        }
        result = Math.max(result, longestSubstring(s.substring(start), k)); // validate the last section
        
        return result;
    }
}
```