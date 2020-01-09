class Solution {
    int pos = 0;
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        String num = "";
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            if (isLetter(s.charAt(i))) sb.append(s.charAt(i));
            else if (isDigit(s.charAt(i))) num += s.charAt(i);
            else if (s.charAt(i) == '[') {
                pos = i + 1;
                String next = decodeString(s);
                for (int j = 0; j < Integer.valueOf(num); j++) sb.append(next);
                num = "";
                i = pos;
            }
            else if (s.charAt(i) == ']') {
                pos = i;
                return sb.toString();
            }
        }
        return sb.toString();
    }
    public boolean isLetter(char a) {
        return ((a <= 'Z' && a >= 'A') || (a >= 'a' && a <= 'z'));
    }
    public boolean isDigit(char a) {
        return a <= '9' && a >= '0';
    }
}