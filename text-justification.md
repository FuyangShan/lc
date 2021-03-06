# Text Justification

Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

```java
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        // traverse the word in words
        for (int i = 0; i < words.length;) {
            List<String> curr = new ArrayList<>(); // collect as many words as possible in the current line 
            int size = 0; // maintain the size
            while (size < maxWidth && i < words.length) {
                if (curr.size() != 0) size++;
                curr.add(words[i]);
                size += words[i].length();
                i++;
            } // when total length of words + necessary space exceed max, exit loop
            if (size > maxWidth) {
                size -= (curr.get(curr.size() - 1).length() + 1); // remove the last one and leading space if size exceed the size
                curr.remove(curr.size() - 1);
                i--; // give back the last item
            }
            // get the nums of space needed to get maxWidth
            int spaces = curr.size() - 1 + (maxWidth - size);
            //construct the string of current line
            StringBuilder sb = new StringBuilder();

            // determine if this is last line
            if (i >= words.length) { //this is last line, left justify
                for (int j = 0; j < curr.size(); j++) {
                    if (j != 0) sb.append(" ");
                    sb.append(curr.get(j));
                }
                for (int j = 0; j < maxWidth - size; j++) sb.append(" ");
            } else { // this is not last line, distribute the space as evenly as possible
                // spaces : needed space, curr.size() : count of word
                // first several space get extra space
                int frontSpaces = curr.size() > 1 ? spaces % (curr.size() - 1) : 0;
                // construct the basic counts of spaces between word
                StringBuilder basicSpaces = new StringBuilder();
                if (curr.size() > 1)
                    for (int k = 0; k < spaces / (curr.size() - 1); k++) basicSpaces.append(" ");
                else 
                    for (int k = 0; k < spaces; k++) basicSpaces.append(" ");
                
                // append the extra spaces and basic spaces between words
                for (int j = 0; j < curr.size(); j++) {
                    if (j != 0 && j <= frontSpaces) sb.append(basicSpaces.toString() + " ");
                    else if (j != 0) sb.append(basicSpaces.toString());
                    sb.append(curr.get(j));
                }
                for (int j = 0; j < maxWidth - size - (curr.size() - 1) * basicSpaces.length(); j++) sb.append(" ");
            }   
            result.add(sb.toString());
        }
        
        return result;
    }
}
```