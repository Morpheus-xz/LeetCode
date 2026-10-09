class Solution {
    public int minInsertions(String s) {
        int ops=0;
        int open=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                open++;
            }else{
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    i++;
                }else{
                    ops++;
                }
                if(open>0){
                    open--;
                }else{
                    ops++;
                }
            }
        }
        ops+=open*2;
        return ops;
    }
}