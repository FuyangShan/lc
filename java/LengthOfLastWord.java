class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        // remove tailing " "
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') len--;
            else break;
        }
        String newString = s.substring(0, len);
        
        for (int i = newString.length() - 1; i >= 0; i--) {
            if (newString.charAt(i) == ' ') return newString.length() - 1 - i;
        }
        
        return newString.length();
    }
}