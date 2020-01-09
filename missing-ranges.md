# Missing Ranges
- Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

> Example:

> Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
> Output: ["2", "4->49", "51->74", "76->99"]
```java
public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        int pre = lower - 1;
        for(int i = 0 ; i <= A.length  ; i++){
            int after = i == A.length ? upper + 1 : A[i]; 
            if(pre + 2 == after){
                result.add(String.valueOf(pre + 1));
            }else if(pre + 2 < after){
                result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
            }
            pre = after;
        }
        return result;
    }
}
```
