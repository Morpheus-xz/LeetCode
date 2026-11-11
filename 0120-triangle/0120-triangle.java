class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n+1][n+1];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                int val = triangle .get(i).get(j);
                if(j==0){
                    dp[i][j]=val+dp[i-1][j];
                }
                else if(i==j){
                    dp[i][j]= val+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = val+Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans=Math.min(ans,dp[n-1][j]);
        }
        return ans;
    }
}