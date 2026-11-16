class Solution {
    public int sumOfGoodSubsequences(int[] nums) {
        int max=100001;
        int mod=1000000007;
        long dp[] = new long[max];
        long sum[] = new long[max];
        for(int num:nums){
            dp[num]=(dp[num]+1)%mod;
            sum[num]=(sum[num]+num)%mod;
            if(num-1>=0 && dp[num-1]>0){
                dp[num]=(dp[num]+dp[num-1])%mod;
                sum[num]=(sum[num]+sum[num-1]+(dp[num-1]*num)%mod)%mod;
            }
            if(num+1<max && dp[num+1]>0){
                dp[num]=(dp[num]+dp[num+1])%mod;
                sum[num]=(sum[num]+sum[num+1]+(dp[num+1]*num)%mod)%mod;
            }
        }
        long ans=0;
        for(int i=0;i<max;i++){
            ans = (ans+sum[i])%mod;
        }
        return (int)ans;
    }
}