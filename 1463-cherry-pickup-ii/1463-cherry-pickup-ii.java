class Solution {
    static int dp[][][];
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(grid,0,0,n-1);
    }
    public int solve(int[][] grid,int i,int j1,int j2){
        int m = grid.length;
        int n = grid[0].length;
        if(j1<0 || j1>=n || j2<0 || j2>=n){
            return -100000000;
        }
        if(i==m-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int max = Integer.MIN_VALUE;
        for(int a=-1;a<=1;a++){
            for(int b=-1;b<=1;b++){
                int val=0;
                if(j1==j2){
                    val = grid[i][j1];
                }
                else{
                    val = grid[i][j1]+grid[i][j2];
                }
                val+=solve(grid,i+1,j1+a,j2+b);
                max=Math.max(max,val);
            }
        }
        return dp[i][j1][j2]=max;
    }
}