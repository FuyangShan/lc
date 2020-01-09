class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        
        for (int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            for (int row = 0; row < numRows && i < s.length(); row++)
                sbs[row].append(s.charAt(i++));
            for (int row = numRows - 2; row > 0 && i < s.length(); row--)
                sbs[row].append(s.charAt(i++));
        }
        
        StringBuilder res = new StringBuilder();
        
        for (StringBuilder sb : sbs) {
            res.append(sb);
        }
        
        return res.toString();
        
    }
}