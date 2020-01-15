class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0)
            return result;
        // get the count of words, length of concatenation, freq of word, size of word
        int count = 0, size = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            count++;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int start = 0; start < s.length() - (count * size) + 1; start++) { // enough to concatenation
            if (isValid(s, map, start, count, size))
                result.add(start);
        }
        return result;
    }

    public boolean isValid(String s, HashMap<String, Integer> map, int start, int count, int size) {
        String curr = s.substring(start, start + size);
        if (map.containsKey(curr) && map.get(curr) == 1 && count == 1)
            return true;
        else if (!(map.containsKey(curr) && map.get(curr) > 0))
            return false;
        map.put(curr, map.get(curr) - 1);
        boolean valid = isValid(s, map, start + size, count - 1, size);
        map.put(curr, map.get(curr) + 1);
        return valid;
    }
}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words.length == 0 || s.length() < words.length * words[0].length())
            return result;
        // get the count of words, length of concatenation, freq of word, size of word
        int count = words.length, size = words[0].length();
        int len = count * size;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) 
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        // loop from 0 ~ size
        for (int i = 0; i < size; i++) {
            HashMap<String, Integer> curMap = new HashMap<>();
            int num = 0; // how many words in curMap;
            for (int j = i; j < s.length() - len + 1; j += size) { // move size step everytime
                boolean hasRemoved = false; // mark if we have done setback
                while (num < count) { // add all words in concatenation
                    String word = s.substring(j + num * size, j + (num + 1) * size); // get each word in substring
                    if (map.containsKey(word)) { // if word in substring exists in words, add to curMap
                        curMap.put(word, curMap.getOrDefault(word, 0) + 1);
                        if (curMap.get(word) > map.get(word)) { // if word appears more than enough, set back from head
                            hasRemoved = true; // mark we have done setback
                            int removeNum = 0; // mark how many times we setback
                            while (curMap.get(word) > map.get(word)) { // keep setback 
                                String firstWord = s.substring(j + removeNum * size, j + (removeNum + 1) * size); // each head of the substring
                                curMap.put(firstWord, curMap.get(firstWord) - 1); // reduce the occurance 
                                removeNum++;
                            }
                            num -= (removeNum - 1); // setback too much, add the last one back
                            j += (removeNum - 1) * size; // pointer move forward to where we stop setback
                            break; // exit concatenation
                        }
                    } else { // if word in substring doesn't exist, pointer move to right before the word
                        curMap.clear();
                        j += num * size; // j += size in for-loop will help us move after the wrong word
                        num = 0; // reset num
                        break; // exit concatenation
                    }
                    num++; // keep adding num
                }
                if (num == count) {
                    result.add(j); // if substring matches, add into result
                    String head = s.substring(j , j + size);  // setback head for next loop
                    curMap.put(head, curMap.get(head) - 1);
                    num--;
                }
            }       
        }
        return result;
    }

}
