class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(words[j],words[i])){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
    public boolean check(String a,String b){
        if(b.length()!=a.length()+1)return false;
        int i=0,j=0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
                i++;
            }
            j++;
        }
        return i==a.length();
    }
}