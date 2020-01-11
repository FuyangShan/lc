# Keyboard Row.md

Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

![keyboard](https://assets.leetcode.com/uploads/2018/10/12/keyboard.png)


```java
class Solution {
    public String[] findWords(String[] words) {
        char[] firstRow = {'Q','q','W','w','E','e','R','r','T','t','Y','y','U','u','I','i','O','o','P','p'};
        char[] secondRow = {'A','a','S','s','D','d','F','f','G','g','H','h','J','j','K','k','L','l'};
        char[] thirdRow = {'Z','z','X','x','C','c','V','v','B','b','N','n','M','m'};
        Set setA = new HashSet();
        Set setB = new HashSet();
        Set setC = new HashSet();

        for (char a: firstRow ){
            setA.add(a);
        }
        for (char b: secondRow){
            setB.add(b);
        }
        for (char c: thirdRow){
            setC.add(c);
        }
        int res = 0;
        ArrayList<String> resStringList = new ArrayList();
        

        for (String word:words){
            for (char w:word.toCharArray()){
                if (setA.contains(w) == false) {
                    res = 0;
                    break;
                }
                res = 1;
            }
            if (res == 1) resStringList.add(word);
            for (char w:word.toCharArray()){
                if (setB.contains(w) == false) {
                    res = 0;
                    break;
                }
                res = 1;
            }
            if (res == 1) resStringList.add(word);
            for (char w:word.toCharArray()){
                if (setC.contains(w) == false){
                    res = 0;
                    break;
                }
                res = 1;
            }
            if (res == 1) resStringList.add(word);

        }
        String[] resString = new String[resStringList.size()]; 
        for (int i = 0;i < resStringList.size(); i++){
            resString[i] = resStringList.get(i);
        }
        return resString;
    }
}
```