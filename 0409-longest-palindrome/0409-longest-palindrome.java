class Solution {
    private int getIndex(char ch) {
        return ch >= 'a' && ch <= 'z' ? 
            ch - 'a' : 
            ch - 'A' + 26;
    }
    public int longestPalindrome(String s) {
        boolean[] freq = new boolean[52];
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = getIndex(s.charAt(i));
            if (freq[index]) {
                freq[index] = false;
                n++;
            } else {
                freq[index] = true;
            }
        }
        return n * 2 == s.length() ? n * 2 : n * 2 + 1;
    }
}