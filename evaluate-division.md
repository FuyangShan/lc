```java
// Union Find
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<String>> sPairs = new HashMap<>(); // String -> Strings
        HashMap<String, List<Double>> vPairs = new HashMap<>(); // String -> Values
        for (int i = 0; i < equations.size(); i++) { // construct a -> b -> c graph
            String str1 = equations.get(i).get(0); // a of a->b
            String str2 = equations.get(i).get(1);  // b of b -> a
            double value = values[i]; // node->node division
            if (!sPairs.containsKey(str1)) {
                sPairs.put(str1, new ArrayList<>());
                vPairs.put(str1, new ArrayList<>());
            }
            if (!sPairs.containsKey(str2)) {
                sPairs.put(str2, new ArrayList<>());
                vPairs.put(str2, new ArrayList<>());
            }
            sPairs.get(str1).add(str2);
            sPairs.get(str2).add(str1);
            vPairs.get(str1).add(value);
            vPairs.get(str2).add(1 / value);
        }
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {  // traverse the queries
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            double result = dfs(start, end, sPairs, vPairs, 1.0, new HashSet<String>());
            if (result == 0.0) // start/end not found 
                results[i] = -1.0;
            else
                results[i] = result;
        }
        return results;
    }

    public double dfs(String start, String end, HashMap<String, List<String>> sPairs,
            HashMap<String, List<Double>> vPairs, double value, HashSet<String> set) {
        if (set.contains(start)) // we have seen the string in the previous path, return 0.0
            return 0.0;
        if (!sPairs.containsKey(start)) // we can't find the string, return 0.0
            return 0.0;
        if (start.equals(end)) // we found the end string, return current value
            return value;
        set.add(start); // mark the start seen

        double tmp = 0.0;

        List<String> slist = sPairs.get(start);
        List<Double> vList = vPairs.get(start);
        for (int i = 0; i < slist.size(); i++) {
            tmp = dfs(slist.get(i), end, sPairs, vPairs, value * vList.get(i), set);
            if (tmp != 0.0) { // we found the end at current index, no need to continue
                break;
            }
        }
        set.remove(start); // backtrack the start from seen to unseen
        return tmp;
    }
}
```