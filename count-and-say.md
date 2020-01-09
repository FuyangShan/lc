```java
class Solution {
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        } else {
            String lastStr = countAndSay(n-1);
            char prevChar = lastStr.charAt(0);
            int count = 1;
            StringBuilder res = new StringBuilder();
            for (int i = 1; i < lastStr.length();i++){
                char curChar = lastStr.charAt(i);
                if (curChar == prevChar){
                    count++;
                } else {
                    res.append(Integer.toString(count));
                    res.append(prevChar);
                    count = 1;
                    prevChar = curChar;
                }
            }
            res.append(Integer.toString(count));
            res.append(prevChar);
            return res.toString();
        }
    }
}
```