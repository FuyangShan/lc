class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0){
            return 1;
        } else if (n == 1 && Integer.parseInt(s) > 0) {
            return 1;
        } else if (n == 1 && Integer.parseInt(s) == 0){
            return 0;
        } else {
            int a = Character.getNumericValue(s.charAt(n - 1));
            int b = Character.getNumericValue(s.charAt(n - 2));
            if (a == 0){
                if (b ==0 || b >=3) return 0;
                return numDecodings(s.substring(0, n - 2));
            } else if (a <= 6){
                if (b == 0){
                    return numDecodings(s.substring(0, n - 1));
                } else if (b<=2){
                    return numDecodings(s.substring(0, n - 1)) + numDecodings(s.substring(0, n - 2));
                } else {
                    return numDecodings(s.substring(0, n - 1));
                }
            } else {
                if (b == 0){
                    return numDecodings(s.substring(0, n - 1));
                } else if (b == 1){
                    return numDecodings(s.substring(0, n - 1)) + numDecodings(s.substring(0, n - 2));
                } else {
                    return numDecodings(s.substring(0, n - 1));
                }
            }
        }
        
    }
}