# Russian Doll Envelopes
- You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
- One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

### Q: What is the maximum number of envelopes can you Russian doll? (put one inside other)

>Example:

>Input: [[5,4],[6,4],[6,7],[2,3]]
>Output: 3 
>Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

```java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        // sort the array to calculate in the right order
        Arrays.sort(envelopes, new Compartor<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            }
        });
        int n = envelopes.length;
        // f[i] = Maximum number of Russian Doll with [0 to i] envelopes
        int[] f = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            // init
            f[i] = 1;
            // enumerate 0 to i-1
            for (int j = 0; j < i; j++) {
                // corner condition
                // envelope j can be put inside envelope i
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    // f[i] = Max {f[j] + 1}
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
