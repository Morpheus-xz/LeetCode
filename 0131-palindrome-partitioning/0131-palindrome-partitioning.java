class Solution {
    static List<List<String>> dp[][];

    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new ArrayList[n][n];
        return solve(s,0,n-1);
    }

    public List<List<String>> solve(String s,int i,int j) {
        if(dp[i][j]!=null)return dp[i][j];

        Set<List<String>> ans = new LinkedHashSet<>();

        if(isPalindrome(s,i,j)){
            List<String> temp = new ArrayList<>();
            temp.add(s.substring(i,j+1));
            ans.add(temp);
        }

        for(int k=i;k<j;k++){
            List<List<String>> left = solve(s,i,k);
            List<List<String>> right = solve(s,k+1,j);

            for(List<String> l:left){
                for(List<String> r:right){
                    List<String> temp = new ArrayList<>();
                    temp.addAll(l);
                    temp.addAll(r);
                    ans.add(temp);
                }
            }
        }

        dp[i][j] = new ArrayList<>(ans);
        return dp[i][j];
    }

    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}