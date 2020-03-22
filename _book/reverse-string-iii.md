class Solution {
    public String reverseWords(String s) {
        String[] sl = s.split(" ");
        StringBuilder ans = new StringBuilder();
        StringBuilder first = new StringBuilder(sl[0]);
        first.reverse();
        ans.append(first.toString());
        if (sl.length > 1){
            for (int i = 1; i < sl.length;i++){
                StringBuilder subSb = new StringBuilder(sl[i]);
                subSb.reverse();
                ans.append(" " + subSb.toString());
            }
        }
        return ans.toString();
    }
}