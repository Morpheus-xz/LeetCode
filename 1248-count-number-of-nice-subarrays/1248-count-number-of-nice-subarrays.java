class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
    public int solve(int[] nums,int k){
        if(k<0)return 0;
        int l=0,count=0,ans=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]%2!=0)count++;
            while(count>k){
                if(nums[l]%2!=0)count--;
                l++;
            }
            ans+=r-l+1;
        }
        return ans;
    }
}