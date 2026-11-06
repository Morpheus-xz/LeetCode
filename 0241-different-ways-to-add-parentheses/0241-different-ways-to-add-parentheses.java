class Solution {
    static List<Integer> dp[][];
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        dp = new ArrayList[n][n];
        return solve(expression,0,n-1);
    }
    public List<Integer> solve (String s,int i,int j){
        if(dp[i][j]!=null)return dp[i][j];
        List<Integer> ans = new ArrayList<>();
        boolean found = false;
        for(int k=i+1;k<j;k++){
            char ch = s.charAt(k);
            if(ch=='+'||ch=='-'||ch=='*'){
                found=true;
                List<Integer> left = solve(s,i,k-1);
                List<Integer> right = solve(s,k+1,j);
                for(int l:left){
                    for(int r:right){
                        if(ch=='+'){
                            ans.add(l+r);
                        }
                        else if(ch=='*'){
                            ans.add(l*r);
                        }
                        else if(ch=='-'){
                            ans.add(l-r);
                        }
                    }
                }
            }
        }
        if(!found){
            ans.add(Integer.parseInt(s.substring(i,j+1)));
        } 
        dp[i][j]=ans;
        return dp[i][j];
    }
}