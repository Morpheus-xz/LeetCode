class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0')dp[i][j]=0;
                else if(i==0) dp[i][j]=1;
                else dp[i][j]=1+dp[i-1][j];
                int h = dp[i][j];
                for(int k=j;k>=0;k--){
                    h = Math.min(h,dp[i][k]);
                    int w = j-k+1;
                    max = Math.max(max,h*w);
                }
            }
        }
        return max;
    }
}