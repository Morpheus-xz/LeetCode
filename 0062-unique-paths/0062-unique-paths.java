// class Solution {
//     int dp[][];
//     public int uniquePaths(int m, int n) {
//         dp = new int[m+1][n+1];
//         return solve(m,n);
//     }
//     public int solve(int m,int n){
//         if(m==1 || n==1) return 1;
//         if(dp[m][n]!=0) return dp[m][n];
//         int right = solve(m,n-1);
//         int left = solve(m-1,n);
//         dp[m][n]=right+left;
//         return dp[m][n];

//     }
// }
class Solution{
    public int uniquePaths(int m,int n){
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            dp[i][1]=1;
        }
        for(int j=1;j<=n;j++){
            dp[1][j]=1;
        }
        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}