// class Solution {
//     int[][]dp;
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m=text1.length();
//         int n=text2.length();
//         dp = new int[m+1][n+1];
//         for(int i=0;i<=m;i++){
//             for(int j=0;j<=n;j++){
//                 dp[i][j]=-1;
//             }
//         }
//         return solve(text1,text2,m,n);
//     }
//     int solve(String x,String y,int m,int n){
//         if(m==0 || n==0)return 0;
//         if(dp[m][n]!=-1)return dp[m][n];
//         if(x.charAt(m-1)==y.charAt(n-1)){
//             dp[m][n]=1+solve(x,y,m-1,n-1);
//         }
//         else dp[m][n]= Math.max(solve(x,y,m-1,n),solve(x,y,m,n-1));
//         return dp[m][n];
//     }
// }
class Solution{
    public int longestCommonSubsequence(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        int[][]dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}