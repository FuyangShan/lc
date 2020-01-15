class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        // use stack to store the result
        Stack<Character> stack = new Stack<>();
        // use hashset to store existence of c
        HashSet<Character> set = new HashSet<>();   
        // use hashmap to store last occurance of c
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && i < map.get(stack.peek())) {
                    set.remove(stack.pop());
                }
                set.add(c);
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}