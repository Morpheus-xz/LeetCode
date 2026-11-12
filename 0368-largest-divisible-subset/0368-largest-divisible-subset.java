class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        int max=1;
        int last=0;
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                last=i;
            }
        }
        List<Integer> ans= new ArrayList<>();
        while(hash[last]!=last){
            ans.add(nums[last]);
            last=hash[last];
        }
        ans.add(nums[last]);
        Collections.reverse(ans);
        return ans;
    }
}