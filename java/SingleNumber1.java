/*
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap();

        for (int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        for (int i:hash.keySet()){
            if (hash.get(i) == 1){
                return i;
            }
        }
    }
}
*/

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num:nums) res ^= num;
        return res;
    }
}