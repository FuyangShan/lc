class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (chars.length != strs.length) return false;
        
        HashMap<Character, String> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            char C = chars[i];
            String S = strs[i];
            if (map.containsKey(C)) {
                if (!map.get(C).equals(S)) return false;
            } else {
                if (!map.containsValue(S)) {
                    map.put(C, S);
                } else return false;
            }
        }
        
        return true;
    }
}
