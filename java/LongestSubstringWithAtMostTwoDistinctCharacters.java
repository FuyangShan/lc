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
            if (count <= 2) result = Math.max(result, i - start + 1);
            while (count > 2) {
                char cc = s.charAt(start++);
                if (--map[cc] == 0) count--;
            }
        }
        return result;
    }
}

//sliding window: hashmap
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int start = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
                char cc = s.charAt(start++);
                map.put(cc, map.get(cc) - 1);
                if (map.get(cc) == 0) map.remove(cc);
            }
            result = Math.max(result, i - start + 1);
        }
        
        return result;
    }
}
//sliding window: 3 pointers
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0, j = -1;
        int maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            if (j > -1 && s.charAt(k) != s.charAt(j)) {
                maxLen = Math.max(maxLen, k - i);
                i = j + 1;
            }
            j = k - 1;
        }
        return maxLen > (s.length() - i) ? maxLen : s.length() - i;
    }
}