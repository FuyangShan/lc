```java
public class Solution {
    public List<String> generateAbbreviations(String word){
        List<String> res = new ArrayList<String>();
        backtrack(res, new StringBuilder(), word, 0, 0);
        return res;
    }

    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void backtrack(List<String> res, StringBuilder sb, String word, int i, int k){
        int len = sb.length(); // keep the length of sb
        if(i == word.length()){
            if (k != 0) sb.append(k); // append the last k if non zero
            res.add(sb.toString());
        } else {
            // the branch that word.charAt(i) is abbreviated
            backtrack(res, sb, word, i + 1, k + 1);

            // the branch that word.charAt(i) is kept
            if (k != 0) sb.append(k);
            sb.append(word.charAt(i));
            backtrack(res, sb, word, i + 1, 0);
        }
        sb.setLength(len); // reset builder to the original state
    }
}
```