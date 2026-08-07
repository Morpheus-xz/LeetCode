class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        int low=1;int high=max;int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(divisible(nums,mid,threshold)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean divisible(int[] nums,int mid,int th){
        long ans=0;
        for(int num:nums){
            ans+=(int)Math.ceil((double)num/mid);
        }
        return ans<=th;
    }
}