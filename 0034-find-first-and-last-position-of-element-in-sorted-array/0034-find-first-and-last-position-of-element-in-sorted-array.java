class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[] {first,last};
    }
    public int findFirst(int[] nums, int target){
        int index=-1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>=target){
                high = mid-1;
            }
            else{
                low=mid+1;
            }
            if(nums[mid]==target) index=mid;
        }
        return index;
    }
    public int findLast(int[]nums, int target){
        int index=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<=target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
            if(nums[mid]==target) index=mid;
        }
        return index;
    }
}