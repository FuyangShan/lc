class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[512];
        for (char c : s.toCharArray()) map[c]++;
        int single = 0;
        for (int i : map) {
            if (i % 2 == 1) single++; 
            if (single > 1) return false;
        } 
        return true;
    }
}
