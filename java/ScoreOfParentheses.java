class Solution {
    public int scoreOfParentheses(String S) {
        if (S == null || S.equals("")) return 0;
        int times = 0;
        int sum = 0;
        boolean open = true;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (times == 0) times++;
                else times *= 2;
                open = true;
            } else if (open){
                sum += times;
                open = false;
                if (times == 1) times--;
                else times /= 2;
            } else {
                if (times == 1) times--;
                times /= 2;
            }
        }
        return sum;
    }
}