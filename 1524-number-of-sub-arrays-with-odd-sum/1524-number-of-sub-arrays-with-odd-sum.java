class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int odd =0,even = 1;
        int ans=0, sum = 0;
        for(int ele:arr){
            sum+=ele;
            if(sum%2==0){
                ans=(ans+odd)%mod;
                even++;
            }else{
                ans=(ans+even)%mod;
                odd++;
            }
        }
        return ans;
    }
}