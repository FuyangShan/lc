class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return false;
        
        HashSet<String> set = new HashSet<>();
        set.add("00");
        set.add("88");
        set.add("69");
        set.add("11");
        set.add("96");
        set.add("0");
        set.add("1");
        set.add("8");
        
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!set.contains(num.charAt(i) + "" + num.charAt(j))) return false;
        }
        
        return true;
    }
}