// ----------MEMOIZATION APPROACH------------
// class Solution {
//     // memoization approach
//     public int fib(int n) {
//         int dp[] = new int[n+1];
//         Arrays.fill(dp,-1);
//         return solve(n,dp);
//     }
//     public int solve (int n, int[]dp){
//         if(n<=1)return n;
//         if(dp[n]!=-1) return dp[n];
//         return dp[n]=solve(n-1,dp)+solve(n-2,dp);
//     }
// }

// ----------TABULATION APPROACH------------
class Solution{
    public int fib(int n){
        if(n<=1) return n;
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}