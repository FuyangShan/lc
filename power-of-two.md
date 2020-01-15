class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while(n != 0){
            n &= (n-1);
            count++;
            if (count > 1) return false;
        }
        return true;
    }
}