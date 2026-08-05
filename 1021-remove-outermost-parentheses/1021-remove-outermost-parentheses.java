class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int level=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(level>0)res.append(ch);
                level++;
            }
            else{
                level--;
                if(level>0)res.append(ch);
            }
        }
        return res.toString();
    }
}