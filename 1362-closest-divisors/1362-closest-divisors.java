class Solution {
    public int[] closestDivisors(int num) {
        int dnum1=divisors(num + 1);
        int dnum2= divisors(num + 2);
        int diff1= (num + 1)/dnum1 - dnum1;
        int diff2= (num + 2)/dnum2 - dnum2;
        if (diff1<=diff2) {
            return new int[]{dnum1,(num + 1)/dnum1};
        } else {
            return new int[]{dnum2,(num + 2)/dnum2};
        }
    }
    public int divisors(int n) {
        int ans = 1;
        for (int i=1; i*i<=n;i++) {
            if (n%i==0) {
                ans=i;
            }
        }
        return ans;
    }
}