# String

1. ASCII representation of a letter, A == 65, a = 97
2. Unicode, the latest version of Unicode contains a repertoire of more than 110,000 characters covering 100 scripts and various symbols

### 5 classic question
    1. Removal
        1.1 remove some paricular chars from a string
        1.2 remove all leading/trailing/duplicated empty spaces from a string.
    2. De-duplication aaaabbbb_ccc -> ab_c
    3. Replace empty space "_" with "20%"
    4. Reversal(swap) e.g. I love yahoo -> yahoo love i
    5. Substring -> strstr
        5.1 regular method
        5.2 Robin-Carp(hash based string matching) & KMP (Knuth-Morris-Pratt)

### Advanced Topics
    1. Move letters around e.g. ABCD1234 -> A1B2C3D4
    2. Permuation
    3. Decoding/Encoding aaaabcc -> a4b1c2
    4. Longest substring that contains only unique chars
    5. Matching(*.?)

## 5 classic question

### 1.1.(Char removal)Remove a/some particular chars from a string
> Example string input = "student", remove "u and n" -> "stdet"

- Solution: Two Pointers
    - **i: slow pointer ->** : all letters that not u or n (results to return) should be put to the left hand side of i;
    - **j: fast pointer ->** : j is the current index to move
    - when j points to non-"u or n" char, copy input(j) to input(j), move i
    - return input.substring(0, i);

### 1.2. (Char removal) Remove all leading/trailing and duplicate empty spaces(only leave one empty space if duplicated space happens) from the input string.
> Example input = "_ _ _ abc _ _ ed _ _ ef _ _" -> "abc_ed_ef"

- Solution: Two Pointers
    - **i: slow pointer ->** : all letters that are in results to return should be put to the left hand side of i;
    - **j: fast pointer ->** : j is the current index to move
    - skip leading "_", start from 1st char;
    - when j points to non-"_" element, copy "_" to i first(if not the 1st word), and then copy all chars to i, （move i at every copy)
    - return input.substring(0, i);
    > Check if i, j is out of boundary when moving

### 2. (Char De-duplication) Remove duplicated and adjacent letters (leave only one letter in each duplicated section) in a string
> Example input = "ab _ c _ _ cc" -> "ab_c"
- Solution: Two Pointers
    - **i: slow pointer ->** : all letters that are in results to return should be put to the left hand side of i;
    - **j: fast pointer ->** : j is the current index to move
    - i starts from 1, j starts from 1 (since we will always keep 1st char)
    - when j points to a char not equal to i - 1, copy j to i, and move i
    - return input.substring(0, i);

### 2.1. (Char de-duplication adjacent letters repeatedly) 
> Example input = "abbbbaz" -> aaz -> z
- Solution: Two Pointers
    - **i: slow pointer ->** : pointing to the top element of the stack
    - **j: fast pointer ->** : j is the current index to move
    - j starts from 1
    - when j is same with i, skip all same elements, setback i (pop from top)
    - when j is different than i, move i, then copy j to i
    - return input.substring(0, i+1)

### 3. (Strstr) Substring problem: how to determine whether a string is a substring of another string.
> Example: s = "a b c d e", t = "c d". return index or -1 if t is not in s
- Solution1: match every substring startsWith("c")
- Solution2: Robin-Carp: hash the window, update the hash while sliding, pop head, push tail
- Solution3: KMP

### 4. (String Reversal)
> Example: apple -> elppa
- Solution1: iteration, i++, j--
- Solution2: recursion, reverse(i+1, j-1)

> Example: I love yahoo -> yahoo love I
- Solution: 1. reverse who string. 2. reverse each word

> Example: abcd ef -> ef abcd
- Solution1: 1. shift K times
             2. I love yahoo

### 5. (Char Replacement)
> Example: "student" -> "stXXt" (den -> xx)
- Solution: find the substring, replace with XX

> Example: "www.yahoo.cim/?q=flower_market#flower_store"   "_" -> "%20"
- Solution: 1. scan the string and calculate how many "_" in total, resize the string
            2. replace from back to front



## Advanced Topics

### 1.1 (String Shuffling)
> Example: "A1B2C3D4" -> "ABCD1234"

### 1.2 (String Shuffling)
> Example: "ABCD1234" -> "A1B2C3D4"
- Solution: 1. Split input AB| CD12 | 34: Left "AB" lMid "CD" Mid "12" rMid "34'
            2. Reverse CD12 -> 12CD : reverse [lMid, Mid], reverse [Mid, rMid], reverse[lMid, rMid]
            3. Recursively convert AB12 | CD34 -> A1B2 | C3D4 : convert left, convert right

### 3 (String En/Decoding)
> Example "aaaaaazbbbwcc" -> "a4b1c2a5"
- Solution: 1. from left to right, we only deal with the pattern that become shorter, (ignore z or w),
                and in the meantime, we count how many single letter occurred in the string, resize the string
            2. from right to left, perform the pre-cacluation based on the count of single letter

### 4.1 (Sliding window) Longest substring that contains only unique char
> Example: the longest substring that contains only unique char of "BDEFGA DE" is "BDEFGA"
- Thought: We must maintain a hash_table that reflects the real-time information about the elements within the sliding window
           When we move the R border, we add information to hash_table
           When we move the L border, we delete information from the hash_table
- Solution: Two Pointer Sliding Window
    - **i: slow pointer ->** : pointing to the L border of window
    - **j: fast pointer ->** : pointing to the R border of window
    - update Window information when moving pointers
    - When window meets requirement, we add [L, R] to result

### 4.2 (Sliding window) Find all anagrams of a substring S2 in a long string S1
> Example: s2 = "aabc", s1 = "zzzzcdeb caabc yywww"
- Solution: Sliding Window

### 4.3 (Sliding window) Given a 0-1 array, you can flip at most K '0' to '1'. Please find the longest subarray that consists of all '1's
> Example: k = 4, arr = 0101100011000011110011001
- Solution: Sliding Window
    - Find the longest subarray contains at most K zeros
    - When to move R border: when the counter_of_zeros <= k
    - When to move L border: when the counter_of_zeros > k





* [String Basic]()
    * [8. String to Integer (atoi)](string-to-integer-atoi.md)
    * [28. Implement strStr](implement-strstr.md)
    * [58. Length of Last Word](length-of-last-word.md)
    * [344. Reverse Strings](reverse-string.md)
    * [541. Reverse Strings II](reverse-string-ii.md)
    * [151. Reverse Words in a String](reverse-words-in-a-string.md)
    * [186. Reverse Words in a String II](reverse-words-in-a-string-ii.md)
    * [557. Reverse Words in a String III](reverse-words-in-a-string-iii.md)
    * [242. Valid Anagram](valid-anagram.md)
    * [38. Count and Say](count-and-say.md)
    * [271. Encode and Decode Strings](encode-and-decode-strings.md)
    * [345. Reverse Vowels of a String](reverse-vowels-of-a-string.md)
    * [205. Isomorphic Strings](isomorphic-strings.md)
    * [293. Flip Game](flip-game.md)
    * [294. Flip Game II](flip-game-ii.md)
    * [290. Word Pattern](word-pattern.md)
    * [291. Word Pattern II](word-pattern-ii.md)
    * [49. Group Anagrams](group-anagrams.md)
    * [249. Group Shifted Strings](group-shifted-strings.md)
    * [6. ZigZag Conversion](zig-zag-conversion.md)
    * [161. One Edit Distance](one-edi-distance.md)
    * [358. Rearrange String k Distance Apart](rearrange-string-k-distance-apart.md)
    * [316. Remove Duplicate Letters](remove-duplicate-letters.md)
    * [449. SerializeAndDeserializeBST](serialize-and-deserialize-bst.md)
    * [168. Excel Sheet Column Title](excel-sheet-column-title.md)
    * [171. Excel Sheet Column Number](excel-sheet-column-number.md)
    * [246. Strobogrammatic Number](strobogrammatic-number.md)
    * [247. Strobogrammatic Number II](strobogrammatic-number-ii.md)
    * [248. Strobogrammatic Number III](strobogrammatic-number-iii.md)
    * [68. Text Justification](text-justification.md)
    * [65. Valid Number](valid-number.md)
    * [157. Read N Characters Given Read4](read-n-characters-given-read4.md)
    * [158. Read N Characters Given Read4 II - Call multiple times](read-n-characters-given-read4-ii-call-multiple-times.md)
    * [387. First Unique Character in a String]()
    * [383. Ransom Note]()

* [String Sliding Window](sliding-window.md)
	* [395. Longest Substring with At Least K Repeating Characters](longest-substring-with-at-least-k-repeating-characters.md)
	* [30. Substring with Concatenation of All Words](substring-with-concatenation-of-all-words.md)
    * [3. Longest Substring Without Repeating characters](longest-substring-without-repeating-characters.md)
    * [159. Longest Substring with at most two distinct characters](longest-substring-with-at-most-two-distinct-characters.md)
    * [340. Longest Substring with at most K distinct characters](longest-substring-with-at-most-k-distinct-characters.md)
    * [76. Minimum Substring](minimum-window-substring.md)
    * [209. Minimum Size Subarray Sum](minimum-size-subarray-sum.md)
    * [567. Permutation in String](permutation-in-string.md)
	* [239. Sliding Window Maximum没解决]()

* [String Palindrome](string-palindrome.md)
    * [125. Valid Palindrome](valid-palindrome.md)
    * [9. Palindrome Number](palindrome-number.md)
	* [241. Different Ways to Add Parentheses](different-ways-to-add-parentheses.md)
	* [5. Longest Palindromic Substring](longest-palindromic-subsequence.md)
	* [214. Shortest Palindrome](shortest-palindrome.md)
	* [336. Palindrome Pairs](palindrome-pairs.md)
	* [266. Palindrome Permutation](palindrome-permutation.md)
	* [267. Palindrome Permutation II](palindrome-permutation-ii.md)
	* [32. Longest Valid Parentheses](longest-valid-parentheses.md)
	* [301. Remove Invalid Parentheses](remove-invalid-parentheses.md)
	* [392. Is Subsequence](is-subsequence.md)
	* [187. Repeated DNA Sequences](repeated-dna-sequences.md)
