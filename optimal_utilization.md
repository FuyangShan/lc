
https://leetcode.com/playground/WFiAdXHj

```java
/*
Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.
*/

// "static void main" must be defined in a public class.
public class Main {
    
    public static List<int[]> optimal(int[][] a, int[][] b, int target) {
        Map<Integer, Integer> a_map = new HashMap<>(); // <value, id>        
        List<int[]> res = new ArrayList<>(); // {[a_id, b_id], [a_id, b_id]}
        
        int max_sum = 0;
        
        for (int[] a_pair : a) {
            a_map.put(a_pair[1], a_pair[0]); 
        }
        
        for (int[] b_pair : b) { // search value in a_map to pair with b
            if (a_map.containsKey(target - b_pair[1])) {
                if (max_sum < target) res = new ArrayList<>();
                res.add(new int[]{a_map.get(target - b_pair[1]), b_pair[0]});
                max_sum = target;
                continue;
            } // if a + b = target
            if (max_sum < target) { // if target not achieved
                for (int a_key : a_map.keySet()) { // search in a_map for pair
                    if (a_key + b_pair[1] < target && a_key + b_pair[1] > max_sum) { // a + b < target && a + b > max
                        res = new ArrayList<>(); // new max found, reset res
                        res.add(new int[]{a_map.get(a_key), b_pair[0]});
                        max_sum = a_key + b_pair[1];
                    } else if(a_key + b_pair[1] == max_sum) { // same pair found
                        res.add(new int[]{a_map.get(a_key), b_pair[0]}); // add to list
                    }
                }
            }
        }
        
        return res;
        
    }
    
    public static void main(String[] args) {
        
        int[][] a = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
        int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        
        int target = 10;
        List<int[]> res = optimal(a, b, target);
        
        for (int[] r : res) {
            System.out.println(r[0]);
            System.out.println(r[1]);
        }
        
        
    }
}
```