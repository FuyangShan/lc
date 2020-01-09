/* class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet();
        for (int i: nums){
            if (!mySet.add(i)){
                return true;
            }
        }
        return false;
    }
} */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        byte[] mark = new byte[268435456];
        for (int i : nums) {
            int j = i/8;
            int k = i%8;
            int check = 1 << k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            mark[j] |= check;
        }
        return false;
    }
}