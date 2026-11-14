class Solution {
    public int maximumLength(int[] nums) {
        int odd=0,even=0;
        int change=1;
        for(int ele:nums){
            if(ele%2==0)even++;
            else odd++;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]%2!=nums[i-1]%2){
                change++;
            }
        }
        return Math.max(change,Math.max(odd,even));
    }
}