class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum=0;
        for(int ele:stones){
            sum+=ele;
        }
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j] = dp[i-1][j];
                if(stones[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-stones[i-1]];
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;i++){
            if(dp[n][i]){
                min=Math.min(min,sum-2*i);
            }
        }
        return min;
    }
}