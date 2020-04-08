# Substrings of size K with K distinct chars

Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.

Example 1:

Input: s = "abcabc", k = 3
Output: ["abc", "bca", "cab"]
Example 2:

Input: s = "abacab", k = 3
Output: ["bac", "cab"]
Example 3:

Input: s = "awaglknagawunagwkwagl", k = 4
Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
Explanation: 
Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl" 
"wagl" is repeated twice, but is included in the output once.
Constraints:

The input string consists of only lowercase English letters [a-z]
0 ≤ k ≤ 26

```java
/*
    a b c a b c
    0 1 2 3 4 5
*/
public class Main {
    
    public static List<String> kSubstring(String S, int k) {
        int distinct = 0,i = 0;
        int [] memo=new int[26];
        Set<String> set=new HashSet<>();
        for (; i < k; i++){ // store 0...k
            if (memo[S.charAt(i) - 'a'] == 0)
                distinct++;
            memo[S.charAt(i) - 'a']++;
        }
        if (distinct == k) { // if distinct == k, add to result
            set.add(S.substring(i - k, i));
        }
        while (i < S.length()){ 
            if (memo[S.charAt(i) - 'a'] == 0) // starting from k
                distinct++;
            memo[S.charAt(i)-'a']++; // char(i)++
            memo[S.charAt(i - k) - 'a']--; // char(i-k)--
            if (memo[S.charAt(i-k) - 'a'] == 0) // if char(i-k) was distinct
                distinct--;
            if (distinct == k) // if new distinct still k, add to result
                set.add(S.substring(i - k + 1, i + 1));
            i++; // move i
        }

        return new ArrayList<>(set);
    }
    
    public static void main(String[] args) {
        System.out.println(kSubstring("awaglknagawunagwkwagl", 4));
    }
}
```