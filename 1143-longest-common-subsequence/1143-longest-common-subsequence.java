class Solution {
    int[][]dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(text1,text2,m,n);
    }
    int solve(String x,String y,int m,int n){
        if(m==0 || n==0)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        if(x.charAt(m-1)==y.charAt(n-1)){
            dp[m][n]=1+solve(x,y,m-1,n-1);
        }
        else dp[m][n]= Math.max(solve(x,y,m-1,n),solve(x,y,m,n-1));
        return dp[m][n];
    }
}