class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        StringBuilder sb = new StringBuilder();
        int[] map = new int[256];
        for (char c : s.toCharArray()) map[c]++;
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 != 0) sb.append((char)i);
        }
        if (sb.length() > 1) return res;
        int len = s.length();
        permutate(map, sb, len, res);
        
        return res;
    }
    public void permutate(int[] map, StringBuilder sb, int len, List<String> res) {
        if (sb.length() == len) {
            res.add(sb.toString());
            return;
        } 
        
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 1) {
                sb.insert(0, (char)i);
                sb.append((char)i);
                map[i] -= 2;
                permutate(map, sb, len, res);
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
                map[i] += 2;
            }
        }
    }
}