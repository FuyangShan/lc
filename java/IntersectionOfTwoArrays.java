class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> mySet = new HashSet();
        Set<Integer> newSet = new HashSet();
        List<Integer> resList = new ArrayList();
        for (int num:nums1){
            mySet.add(num);
        }
        for (int num:nums2){
            if (mySet.contains(num)){
                newSet.add(num);
            }
        }
        for (int i:newSet){
            resList.add(i);
        }
        int[] finalList =new int[resList.length];
        for (int i = 0;i<resList.length;i++){
            finalList[i] = resList[i];
        }
        return finalList;
    }
}