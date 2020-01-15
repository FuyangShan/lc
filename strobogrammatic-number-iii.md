class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int min = low.length();
        int max = high.length();
        List<String> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.addAll(helper(i, i));
        }
        int count = 0;
        for (String s : result) {
            if ((s.length() == min && s.compareTo(low) < 0) || (s.length() == max && s.compareTo(high) > 0))
                continue;
            count++;
        }
        return count;
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