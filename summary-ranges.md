# Summary Range
- Given a sorted integer array without duplicates, return the summary of its ranges.

> Example 1:

> Input:  [0,1,2,4,5,7]
> Output: ["0->2","4->5","7"]
> Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

> Example 2:

> Input:  [0,2,3,4,6,8,9]
> Output: ["0","2->4","6","8->9"]
> Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

```java
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int i = 0;
        int j = 1;
        int len = 1;
        StringBuilder prev = new StringBuilder();
        prev.append(nums[0]);
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[j] - nums[i] == 1) {
                j++;
                len++;
                continue;
            }
            if (len > 1) {
                prev.append("->");
                prev.append(nums[i]);
            }
            res.add(prev.toString());
            prev = new StringBuilder(String.valueOf(nums[j]));
            j++;
            len = 1;
        }
        if (len > 1) {
            prev.append("->");
            prev.append(nums[i]);
        }
        res.add(prev.toString());
        
        return res;
    }
}
```
