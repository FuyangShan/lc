class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result *= 26;
            result++;
            result += (s.charAt(i) - 'A');
        }
        return result;
    }
}