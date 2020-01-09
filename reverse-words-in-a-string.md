```java
// S1
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        int i = 0;
        ArrayList<String> sl = new ArrayList();
        while (i < s.length()){
            if (s.charAt(i) != ' ') {
                StringBuilder word = new StringBuilder();
                while (i < s.length() && s.charAt(i) != ' '){
                    word.append(Character.toString(s.charAt(i)));
                    i++;
                }
                sl.add(word.toString());
                i--;
            }
            i++;
        }
        StringBuilder ans = new StringBuilder();
        if (sl.size() > 0){
            for (int j = sl.size() - 1; j > 0; j--){
                ans.append(sl.get(j));
                ans.append(" ");
            }
            ans.append(sl.get(0));
            return ans.toString();
        }
        return s;
        

    }
}
// S2
class Solution{
    public String reverseWords(String s){
        if (s == null|| s.length() == 0) return s;
        String[] sArray = s.split(" ");
        if (sArray.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(sArray[sArray.length - 1]);
        for (int i = sArray.length - 2; i >=0; i--){
            if (sArray[i].equals("")) continue;
            sb.append(" " + sArray[i]);
        }
        return sb.toString();
    }
}
// S3
public String reverseWords(String s) {
    if(s==null || s.length() == 0)
        return s;
    String[] sArray = s.split(" ");
    if(sArray.length == 0)
        return "";
    StringBuilder sb = new StringBuilder();
   sb.append(sArray[sArray.length-1]);
   for(int i=sArray.length-2; i>=0 ;i--)
   {
       if(sArray[i].equals(""))
           continue;
       sb.append(" "+sArray[i]);
   }
       
       
   return sb.toString();
   }
} 
```