class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int b = 2; b <= n - 2; b++) {
            int num = n;
            String str = "";
            while (num > 0) {
                int rem = num % b;
                str = rem + str;
                num = num / b;
            }
            String rev = new StringBuilder(str).reverse().toString();
            if (!str.equals(rev)) {
                return false;
            }
        }
        return true;
    }
}