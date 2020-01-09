class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0)
            return res;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i + 1));
                for (int m : list1) {
                    for (int n : list2) {
                        if (c == '+')
                            res.add(m + n);
                        else if (c == '-')
                            res.add(m - n);
                        else
                            res.add(m * n);
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }

}