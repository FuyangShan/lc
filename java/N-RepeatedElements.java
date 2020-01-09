class Solution {
    public int repeatedNTimes(int[] A) {
        Set setA = new HashSet();
        for (int i: A){
            setA.add(i);
            if (setA.contains(i)) return i;
        }
        return -1;
    }
}