class Solution {
    static final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long oddCount=n/2;
        long evenCount = (n+1)/2;
        long fivepower = pow(5,evenCount);
        long fourpower = pow(4,oddCount);
        return (int)((fivepower*fourpower)%MOD);
    }
    public long pow(long base,long exp){
        if(exp==0) return 1;
        return (exp%2==0)? pow((base*base)%MOD,exp/2) : (base*pow((base*base)%MOD,exp/2))%MOD;
    }
}