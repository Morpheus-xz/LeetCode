class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int ele:nums){
            max=Math.max(max,ele);
        }
        int ans=0;
        for(int ele:nums){
            ans = ans+(max-ele);
        }
        return ans;
    }
}