class Solution {
    public int splitArray(int[] nums, int k) {
        // int n = nums.length;
        if(nums.length<k) return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0;i<nums.length;i++){
            low=Math.max(nums[i],low);
            high+=nums[i];
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            int sum = splitsum(nums,mid);
            if(sum>k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    public int splitsum(int[] arr,int num){
        int sum = 1,count=0;
        for(int i=0;i<arr.length;i++){
            if(count+arr[i]<=num){
                count+=arr[i];
            }
            else{
                sum++;
                count=arr[i];
            }
        }
        return sum;
    }
}