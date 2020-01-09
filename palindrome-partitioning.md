```java
// DFS Backtrack
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        DFS(res, new ArrayList<>(), 0, s);
        return res;
    }
    
    public void DFS(List<List<String>> res, List<String> sol, int i, String s) {
        if (i == s.length()) {
            res.add(new ArrayList<>(sol));
            return;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (isPalindrome(sub)) {
                sol.add(sub);
                DFS(res, sol, j, s);
                sol.remove(sol.size() - 1);
            }
        }  
    }
    
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

// DFS Backtrack + DP
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        // cache if s[j, i] is Palindrome
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                // must satisfy : s[i] == s[j] && (i is adjacent to j || neighbors of i,j is Palindrome)
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> sol, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(sol));
            return;
        }
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                sol.add(s.substring(pos,i+1));
                helper(res, sol, dp, s, i+1);
                sol.remove(sol.size()-1);
            }
        }
    }
}
```