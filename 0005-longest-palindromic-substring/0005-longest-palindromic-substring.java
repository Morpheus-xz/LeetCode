class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int maxl=0;
        for(int i=0;i<s.length();i++){
            int l=i;
            int r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                int len = r-l+1;
                if(len>maxl){
                    maxl=len;
                    start=l;
                }
                // cannot use this because we need to also update start when we get a bigger lenth (maxl=Math.max(maxl,len));
                l--;r++;
            }
            l=i;r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                int len = r-l+1;
                if(len>maxl){
                    maxl=len;
                    start=l;
                }
                // cannot use this because we need to also update start when we get a bigger lenth (maxl=Math.max(maxl,len));
                l--;r++;
            }
        }
        return s.substring(start,start+maxl);
    }
}