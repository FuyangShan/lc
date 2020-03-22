class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Char> setJ = new HashSet();
        int res = 0;
        for (char j:J.toCharArray()) setJ.add(j);
        for (char s:S.toCharArray()) if (setJ.contains(s)) res++;
        return res;
    }
}