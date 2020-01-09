class Solution {
    public int minAddToMakeValid(String S) {
        if (S.equals("")){
            return 0;
        }
        String[] sList = S.split("");
        Stack<String> stack = new Stack();
        int n = 0;
        for (int i = sList.length - 1; i >= 0; i--){
            if (stack.isEmpty()){
                stack.push(sList[i]);
                n++;
            } else{
                if (stack.peek().equals(")") && sList[i].equals("(")){
                    stack.pop();
                    n--;
                }else {
                    stack.push(sList[i]);
                    n++;
                }
            }
        }
        return n;
    }
}