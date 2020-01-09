class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        
        // store <char, str> using HashMap
        HashMap<Character, String> map = new HashMap<>();
        // store the mapped string using HashSet
        HashSet<String> set = new HashSet<>();
        
        return isMatch(pattern, 0, str, 0, map, set);
    }
    
    public boolean isMatch(String pat, int pi, String str, int si, HashMap<Character, String> map, HashSet<String> set) {
        // when both pointers reach the end at same time, return true, otherwise, false
        if (pi == pat.length() && si == str.length()) return true;
        if (pi == pat.length() || si == str.length()) return false;
        // get the current pattern char to match
        char c = pat.charAt(pi);
        // check if c exists in <c, s> map
        if (map.containsKey(c)) {
            // c exists in map
            String s = map.get(c);
            // if the rest of str NOT matches the mapped s
            if (!str.startsWith(s, si)) return false;
            // if head of str matches with mapped s, continue to match the rest
            return isMatch(pat, pi + 1, str, si + s.length(), map, set);
        }
        else {
            // c not exists in map
            // loop constructing <c, s> mapping with various lenght of s, from 0 - len
            for (int k = si; k < str.length(); k++) {
                // construct the mapping string to the current c
                String s  = str.substring(si, k + 1);
                // if string already exists, continue 
                if (set.contains(s)) continue;
                map.put(c, s);
                set.add(s);
                // check if the rest of string matches
                if (isMatch(pat, pi + 1, str, k + 1, map, set)) return true;
                // backtrack map and set before entering next loop
                map.remove(c);
                set.remove(s);
            }
        }
        
        //we have checked all mapping
        return false;
    }
    
}