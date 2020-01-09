class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> myStack = new Stack<Integer>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++){
            if (ops[i].equals("C")){
                myStack.pop();
            } else if(ops[i].equals("D")){
                myStack.push(myStack.peek() * 2);
            } else if(ops[i].equals("+")){
                int temp = myStack.peek();
                myStack.pop();
                int temp2 = myStack.peek();
                myStack.push(temp);
                myStack.push(temp + temp2);
            } else {
                myStack.push(Integer.parseInt(ops[i]));
            }
        }
        while (! myStack.isEmpty()){
            sum = sum + myStack.pop();
        }
        return sum; 
    }

}
