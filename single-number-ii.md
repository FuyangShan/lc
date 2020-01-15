/*
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num:nums){
            ones = (ones ^ num) & (~twos);
            twos = (twos ^ num) & (~ones);
        }
        return ones;
    }
}
*/
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer> hash = new HashMap();
        for (int num: nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
            
        }
        for (int i: hash.keySet()){
            if(hash.get(i) == 1) return i;
        }
        return -1;
    }
}   