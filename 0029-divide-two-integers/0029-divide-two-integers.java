class Solution {
    public int divide(int dividend, int divisor) {
        int ans = 2147483647;
        if(dividend == -2147483648 && divisor == -1){
            return ans;
        }
        return dividend/divisor;
    }
}