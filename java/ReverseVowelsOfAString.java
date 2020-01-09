import java.util.List;

/* class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder vowelsChars = new StringBuilder();
        for (int i = s.length() - 1; i > 0; i++){
            char c = sb.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                vowelsChars.append(sb.charAt(i));
            }
        }
        int count = 0;
        for (int j = 0; j < s.length(); j++){
            char c = sb.charAt(j);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                sb.setCharAt(j, vowelsChars.charAt(count));
                count++;
            }
        }
        return sb.toString();
    }
} */

class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = Arrays.asList('a','e','o','u','i','A','E','O','U','I');
        int l = 0;
        int r = s.length() - 1;
        char[] ans = s.toCharArray();
        while (l < r){
            while (l < r && !vowels.contains(Character.valueOf(ans[l]))){
                l++;
            }
            while (l < r && !vowels.contains(Character.valueOf(ans[r]))){
                r--;
            }
            if (l < r){
                char c = ans[l];
                ans[l] = ans[r];
                ans[r] = c;
                l++;
                r--;
            }

            
        }
        return String.valueOf(ans);
    }
}