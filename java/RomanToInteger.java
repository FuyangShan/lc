class Solution {
    public int romanToInt(String s) {
        if (s== null||s.length()==0) return 0;
        HashMap<Character,Integer> hash = new HashMap();
        hash.put('I',1);
        hash.put('V',5);
        hash.put('X',10);
        hash.put('L',50);
        hash.put('C',100);
        hash.put('D',500);
        hash.put('M',1000);
        int length = s.length();
        int result = hash.get(s.charAt(length - 1));
        for (int i = length - 2;i >= 0;i--){
            if (hash.get(s.charAt(i + 1))<=hash.get(s.charAt(i))){
                result += hash.get(s.charAt(i));
            }else{
                result -= hash.get(s.charAt(i));
            }
        }

        return result;
    }
}