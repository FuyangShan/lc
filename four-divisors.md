# 1390. Four Divisors

Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.

If there is no such integer in the array, return 0.


Example 1:

Input: nums = [21,4,7]
Output: 32
Explanation:
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.

```java
class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int n : nums) {
            int count = 0;
            int sum = 0;
            for (int i = 1; i <= n / i; i++) {
                if ((n / i) * i == n) {
                    // divided evenly
                    count += i * i == n ? 1 : 2;
                    sum += (i * i == n) ? i: (i + n / i);
                }
            }
            if (count == 4) res += sum;
        }
        return res;
    }
}
```