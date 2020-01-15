class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || s.length() < t.length()) return "";
        
        int minLen = Integer.MAX_VALUE; 
        int count = t.length();
        int start = 0;
        int minStart = 0;
        
        int[] map = new int[256];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c]-- > 0) count--;
            while (count == 0) {
                if (minLen > i - start + 1) {
                    minLen = i - start + 1;
                    minStart = start;
                }
                char cc = s.charAt(start++);
                if (++map[cc] > 0) count++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}