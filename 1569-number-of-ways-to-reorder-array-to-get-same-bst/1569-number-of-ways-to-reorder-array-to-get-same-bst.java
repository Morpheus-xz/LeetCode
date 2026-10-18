class Solution {
    long mod = 1000000007;
    long[][] comb;
    long solve(List<Integer> a){
        int n = a.size();
        if(n<3) return 1;
        List<Integer> left = new ArrayList(), right = new ArrayList();
        for(int i=1;i<n;i++){
            if(a.get(i)<a.get(0))left.add(a.get(i));
            else right.add(a.get(i));
        }
        return comb[n-1][left.size()]*solve(left)%mod*solve(right)%mod;
    }
    public int numOfWays(int[] nums) {
        int n=nums.length;
        comb = new long[(int)n+1][(int)n+1];
        for(int i=0;i<=n;i++){
            comb[i][0]=comb[i][i]=1;
            for(int j=1;j<i;j++){
                comb[i][j]=(comb[i-1][j-1]+comb[i-1][j])%mod;
            }
        }
        List<Integer> a = new ArrayList<>();
        for(int x:nums)a.add(x);
        return (int)((solve(a)-1+mod)%mod);
    }
}