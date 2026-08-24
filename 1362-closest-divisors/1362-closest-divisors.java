// class Solution {
//     public int[] closestDivisors(int num) {
//         int dnum1=divisors(num + 1);
//         int dnum2= divisors(num + 2);
//         int diff1= (num + 1)/dnum1 - dnum1;
//         int diff2= (num + 2)/dnum2 - dnum2;
//         if (diff1<=diff2) {
//             return new int[]{dnum1,(num + 1)/dnum1};
//         } else {
//             return new int[]{dnum2,(num + 2)/dnum2};
//         }
//     }
//     public int divisors(int n) {
//         int ans = 1;
//         for (int i=1; i*i<=n;i++) {
//             if (n%i==0) {
//                 ans=i;
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int[] closestDivisors(int num) {
        int[] a = findFactors(num + 1);
        int[] b = findFactors(num + 2);
        int diffA = Math.abs(a[0] - a[1]);
        int diffB = Math.abs(b[0] - b[1]);
        if (diffA <= diffB) {
            return a;
        }
        return b;
    }
    public int[] findFactors(int n) {
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0) {
                return new int[]{i, n / i};
            }
        }
        return new int[0];
    }
}