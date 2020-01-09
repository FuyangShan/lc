```java
class Solution {
    public String getPermutation(int n, int k) {
        // e.g. n = 4 : 1234, k = 9
        // 1st index is (k-1) / (3 * 2 * 1) = 1 -> n[1] = "2"
        // 2nd index is ((k-1) % (3 * 2 * 1)) / (2 * 1) = 1 -> n[1] = "3"
        // 3rd index is ... = 0 -> n[0] = "1"
        // 4th index is ... = 0 -> n[0] = "4"
        List<Integer> list = new ArrayList<>();
        k -= 1;
        for (int i = n; i >= 1; i--) { // get all indices of number
            int m = 1; // cache (n - 1)!
            for (int j = i - 1; j > 1; j--) {
                m = m * j;
            }
            list.add(k / m); // k / (n - 1)!
            k %= m; //  k % (n - 1)!
        } // list = {indices...} of each permutation
        
        List<Integer> myList = new ArrayList<>();
        for (int i = 1; i <= n; i++) myList.add(i); // get a full indices list {1, 2, ... n}
        
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(myList.get(i)); // append each index as result
            myList.remove(i); // remove the curr, proceed to next permutation
        }
        return sb.toString();
    }
}
```