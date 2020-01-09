```java
// DP
class Solution {
    public int rob(int[] nums) {
        int rob = 0; // the gain you had if ended up robbing this house
        int preRob = 0;
        int temp;
        for (int num : nums) {
            temp = rob; 
            rob = Math.max(rob, preRob + num);
            preRob = temp;
        }
        return rob;
    }
}
```