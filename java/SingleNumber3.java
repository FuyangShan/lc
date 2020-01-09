class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i: nums) xor ^= i;
        int lastbit = xor & (-xor); // lastbit = xor - (xor & (xor - 1));
        int a = 0, b = 0;
        for (int i : nums){
            if ((lastbit & i) == 0) a ^= i;
            if ((lastbit & i) == lastbit) b ^= i;
        }
        return new int[]{a,b};
    }
}