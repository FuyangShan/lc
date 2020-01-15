//sliding window: int[256]
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] map = new int[256];
        int result = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c]++;
            while(map[c] > 1) {
                char cc = s.charAt(start++);
                map[cc]--;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
