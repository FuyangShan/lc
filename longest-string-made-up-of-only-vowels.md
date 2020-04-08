# Longest string made up of only vowels

You are given with a string . Your task is to remove atmost two substrings of any length from the given string such that the remaining string contains vowels('a','e','i','o','u') only. Your aim is the maximise the length of the remaining string. Output the length of remaining string after removal of atmost two substrings.
NOTE: The answer may be 0, i.e. removing the entire string.

Sample Input: "earthproblem" "letsgosomewhere"
Sample Output 3 2



```java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(getLength("earthproblem"));
        System.out.println(getLength("letsgosomewhere"));

    }
    public static int getLength(String s) {
        int cstart = 0, cend = s.length() - 1;
        while (cstart < s.length()) { // calculate the leading v
            if (!IsVowel(s.charAt(cstart))) break;
            cstart += 1;
        }

        while (cend >= 0) {  // calculate trailing v
            if (!IsVowel(s.charAt(cend))) break;
            cend -= 1;
        }

        int maxLen = 0, vstart = cstart;
        for (int i = cstart; i <= cend; i++) {
            if (IsVowel(s.charAt(i))) {
                int size = i - vstart + 1;
                if (size > maxLen)
                    maxLen = size;
            }
            vstart += 1;
        }
        return (cstart - 0) + maxLen + (s.length() - 1 - cend);
    }

    private static boolean IsVowel(char c) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels.contains(c);
    }
}
```