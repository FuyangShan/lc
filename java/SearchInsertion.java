class SearchInsertion {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
    
        SearchInsertion mySearchInsertion = new SearchInsertion();
    
        System.out.println(mySearchInsertion.searchInsert(nums, target));
    }
}

