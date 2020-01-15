# 24 Game

- You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through 'STAR', /, +, -, (, ) to get the value of 24.

> Example 1:
> Input: [4, 1, 8, 7]
> Output: True
> Explanation: (8-4) * (7-1) = 24

> Example 2:
> Input: [1, 2, 1, 2]
> Output: False

- Note:
- The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
- Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
- You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.

```java
// DFS backtrack
class Solution {
    public boolean judgePoint24(int[] nums) {
        ArrayList A = new ArrayList<Double>();
        for (int v: nums) A.add((double) v);
        return solve(A);
    }
    private boolean solve(ArrayList<Double> nums) {
        if (nums.size() == 0) return false;
		// Double type number should be 1e-6 close to 24
        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;

		// pick two numbers from curr array
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
				// enumerate ways of picking two different nums
                if (i != j) {
					// construct new array
                    ArrayList<Double> nums2 = new ArrayList<Double>();
					// add rest of nums in new array
                    for (int k = 0; k < nums.size(); k++) if (k != i && k != j) {
                        nums2.add(nums.get(k));
                    }

					// perform 4 operations between these 2 nums
                    for (int k = 0; k < 4; k++) {

						// A + B = B + A, A * B = B * A, de-duplicate ways
                        if (k < 2 && j > i) continue;

						// add the result(A, B) to new array
                        if (k == 0) nums2.add(nums.get(i) + nums.get(j));
                        if (k == 1) nums2.add(nums.get(i) * nums.get(j));
                        if (k == 2) nums2.add(nums.get(i) - nums.get(j));
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }

						// recursively verify if final result is 24
                        if (solve(nums2)) return true;

						// backtrack the result(A, B) before next iteration
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
```
