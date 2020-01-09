```java
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(reverse(array[0]));
        
        for (int i = 1; i < array.length; i++) {
            sb.append(" ");
            sb.append(reverse(array[i]));
        }
        return sb.toString();
    }
    public String reverse(String s) {
        if (s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++; j--;
        }
        return new String(array);
    }
    public void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
```