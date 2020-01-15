class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        // store all anagrams in <s, list> map
        HashMap<String, List> map = new HashMap<>();
        
        for (String str : strs) {
            
            // store occurance of char in chars in int[]
            int[] count = new int[26];
            for (char c : str.toCharArray()) count[c - 'a']++;
            // construct a sb to represent the current str, using the count of letters
            StringBuilder sb = new StringBuilder("");
            for (int i : count) sb.append("#" + i);
            // add the current str to mapped list, create a new list if the representing key doesn't exist yet
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        
        return new ArrayList(map.values());
    }
}