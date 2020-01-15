# Reverse Vowels of a String
- Write a function that takes a string as input and reverse only the vowels of a string.

> Example 1:
> 
> Input: "hello"
> Output: "holle"
> Example 2:
> 
> Input: "leetcode"
> Output: "leotcede"
>
> Note:
> The vowels does not include the letter "y".

```java
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
```
