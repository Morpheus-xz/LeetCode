class Solution {
    static int dp[];
    public int climbStairs(int n, int[] costs) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,costs);
    }
    public int solve(int i,int[] costs){
        if(i==0) return 0;
        if(i<0) return 1000000000;
        if(dp[i]!=-1) return dp[i];
        int a = solve(i-1,costs)+1;
        int b = solve(i-2,costs)+4;
        int c = solve(i-3,costs)+9;
        return dp[i] = costs[i-1]+ Math.min(a,Math.min(b,c));
    }
}