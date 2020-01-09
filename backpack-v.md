# Backpack V
- Given **n** items with size **nums[i]** which is an integer array and all positive numbers. 
- An integer **target** denotes the size of a backpack. 
- Each item may only be used once
### Q: Find the number of possible fill the backpack.


>Example
>Given candidate items [1,2,3,3,7] and target 7,

>A solution set is: 
>[7]
>[1, 3, 3]
>return 

```java

// DP
public class Solution {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        int n = nums.length;
        if (n == 0) return 0;
        int[] f = new int[target + 1];
        f[0] = 1;
        // rolling array
        // num of possibilities to fill size i pack with previous nums
        // ... starts with 0 num:
        for (int i = 1; i <= target; i++) {
            f[i] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            // from target to 0
            for (int j = target; j >= 0; j--) {
                // f'[j] = f[j] + f[j - nums[i - 1]]
                // possibilities for target j with i items = 
                // possibilities for target j with i-1 items + 
                // possibilities for target j - currItem with i-1 items, plus currItem
                if (j >= nums[i - 1]) { // if current target larger than current Num
                    // f'[j] 
                    // override f[j]
                    f[j] += f[j - nums[i - 1]];
                }
            }
        }
        return f[target];
    }
}
```