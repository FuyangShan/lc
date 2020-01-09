# Sort Characters By Frequency
- Given a string, sort it in decreasing order based on the frequency of characters.

> Example 1:

> Input:
> "tree"
> Output:
> "eert"

> Explanation:
> 'e' appears twice while 'r' and 't' both appear once.
> So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

> Example 2:
> Input:
> "cccaaa"
> Output:
> "cccaaa"

> Explanation:
> Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
> Note that "cacaca" is incorrect, as the same characters must be together.

> Example 3:
> 
> Input:
> "Aabb"
> Output:
> "bbAa"
> 
> Explanation:
> "bbaA" is also a valid answer, but "Aabb" is incorrect.
- Note that 'A' and 'a' are treated as two different characters.

```java
class Solution {
    public String frequencySort(String s) {
        char[] myChar = s.toCharArray();
        HashMap<Character,Integer> myMap = new HashMap();
        String res;
        for (char c:myChar){
            myMap.put(c,myMap.getOrDefault(c,0)+1);
        }

        HashMap<Integer,List<Character>> newMap = new HashMap();
        for (Map.Entry<Character,Integer> entry: myMap.entrySet()){
            if(newMap.containsKey(entry.getValue())){
                newMap.get(entry.getValue()).add(entry.getKey());
            }
            else {
                List<Character> l = new ArrayList<>();
                l.add(entry.getKey());
                newMap.put(entry.getValue(),l);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = s.length(); i >=1; i--){
            if(!newMap.containsKey(i)) continue;
            List<Character> list = newMap.get(i);
            if (list == null) continue;
            for (char c:list){
                int repeat = i;
                while (repeat>0){
                    sb.append(c);
                    repeat--;
                }
            }
        }
        return sb.toString();
    }
}
```
