class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<2) return 0;
        int maxdiff=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            int diff = Math.abs(nums[i-1]-nums[i]);
            maxdiff=Math.max(diff,maxdiff);
        }
        return maxdiff;
    }
}