class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    public List<String> helper(int current, int target) {
        if (current == 0) return new ArrayList<String>(Arrays.asList(""));
        if (current == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> list = helper(current - 2, target);
        
        List<String> result = new ArrayList<>();
        
        for (String s : list) {
            if (current != target) result.add("0" + s + "0");
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        
        return result;
    }
}