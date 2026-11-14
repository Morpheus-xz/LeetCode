class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int a_count=0;
        int b_count=0;
        int c_count=0;
        int l=0,r=0;
        int count=0;
        while(r<n){
            if(s.charAt(r)=='a')a_count++;
            if(s.charAt(r)=='b')b_count++;
            if(s.charAt(r)=='c')c_count++;
            while(a_count>0 && b_count>0 && c_count>0){
                count+=n-r;
                if(s.charAt(l)=='a')a_count--;
                if(s.charAt(l)=='b')b_count--;
                if(s.charAt(l)=='c')c_count--;
                l++;
            }
            r++;
        }
        return count;
    }
}