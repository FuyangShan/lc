//sliding window: int[256]
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] map = new int[256];
        int result = 0;
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c]++ == 0) count++;
            if (count <= k) result = Math.max(result, i - start + 1);
            while (count > k) {
                char cc = s.charAt(start++);
                if (--map[cc] == 0) count--;
            }
        }
        return result;
    }
}