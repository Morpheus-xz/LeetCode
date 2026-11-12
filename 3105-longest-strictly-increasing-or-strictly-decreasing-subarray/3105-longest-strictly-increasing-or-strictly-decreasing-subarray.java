class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int max=1;
        for(int i=0;i<n;i++){
            int inc=1,dec=1;
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[j-1]){
                    inc++;
                    dec=1;
                }
                else if(nums[j]<nums[j-1]){
                    dec++;
                    inc=1;
                }
                else{
                    inc=1;
                    dec=1;
                }
                max = Math.max(max,Math.max(inc,dec));
            }
        }
        return max;
    }
}