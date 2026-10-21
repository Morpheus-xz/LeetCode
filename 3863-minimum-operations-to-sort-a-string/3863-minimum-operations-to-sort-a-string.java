class Solution {
    public int minOperations(String s) {
        int n=s.length();
        if(sorted(s)) return 0;
        if(n==1) return 0;
        if(n==2) return -1;
        char max = s.charAt(0);
        char min = s.charAt(0);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(max<ch)max=ch;
            if(min>ch)min=ch;
        }
        char max_mid=s.charAt(1);
        char min_mid=s.charAt(1);
        for(int i=1;i<s.length()-1;i++){
            char ch = s.charAt(i);
            if(max_mid<ch)max_mid=ch;
            if(min_mid>ch)min_mid=ch;
        }
        if(s.charAt(0)==min || s.charAt(n-1)==max) return 1;
        if(s.charAt(0)>max_mid && s.charAt(n-1)<min_mid) return 3;
        return 2;
    }
    public boolean sorted(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<s.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}