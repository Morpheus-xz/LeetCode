// ---- This solution is correct but gives TLE -----
// class Solution {
//     static int dp[][];
//     public int minCut(String s) {
//         int n = s.length();
//         dp=new int[n+1][n+1];
//         for(int i=0;i<=n;i++){
//             for(int j=0;j<=n;j++){
//                 dp[i][j]=-1;
//             }
//         }
//         return solve(s,0,n-1);
//     }
//     public int solve(String s,int i,int j){
//         if(i>=j)return 0;
//         if(isPalindrome(s,i,j))return 0;
//         if(dp[i][j]!=-1)return dp[i][j];
//         int min = Integer.MAX_VALUE;
//         for(int k=i;k<j;k++){
//             int left,right;
//             if(dp[i][k]!=-1){
//                 left=dp[i][k];
//             }else{
//                 left=solve(s,i,k);
//             }
//             if(dp[k+1][j]!=-1){
//                 right=dp[k+1][j];
//             }else{
//                 right=solve(s,k+1,j);
//             }
//             int cost = 1+left+right;
//             min=Math.min(min,cost);
//         }
//         dp[i][j]=min;
//         return dp[i][j];
//     }
//     public boolean isPalindrome(String s,int i,int j){
//         while(i<j){
//             if(s.charAt(i)!=s.charAt(j)){
//                 return false;
//             }
//             i++;j--;
//         }
//         return true;
//     }
// }
class Solution {
    static int dp[][];
    static boolean pal[][];
    public int minCut(String s) {
        int n = s.length();
        dp=new int[n+1][n+1];
        pal = new boolean[n][n];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                if(j-i<=2 || pal[i+1][j-1]){
                    pal[i][j]=true;
                }
                }
            }
        }
        return solve(s,0,n-1);
    }
    public int solve(String s,int i,int j){
        if(i>=j)return 0;
        if(pal[i][j])return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            if(pal[i][k]){
            int right;
            if(dp[k+1][j]!=-1){
                right=dp[k+1][j];
            }else{
                right=solve(s,k+1,j);
            }
            
            int cost = 1+right;
            min=Math.min(min,cost);
            }
        }
        dp[i][j]=min;
        return dp[i][j];
    }
}