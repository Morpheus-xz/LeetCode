class Solution {
    public long countCommas(long n) {
        long ct=0;
        long pow=1000;
        while(n>=pow){
            ct+=n-pow+1;
            pow*=1000;
        }
        return ct;
    }
}