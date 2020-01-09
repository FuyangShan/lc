class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n = s.length(), m = t.length();
        if (n - m == 1) return deleted(s, t);
        else if (m - n == 1) return deleted(t, s);
        else if (m == n) return replaced(t, s);
        else return false;
        
    }
    
    public boolean deleted(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(i + 1).equals(t.substring(i));
        }
        return true;
    }

    public boolean replaced(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(i + 1).equals(t.substring(i + 1));
        }
        return false;
    }
    
}
