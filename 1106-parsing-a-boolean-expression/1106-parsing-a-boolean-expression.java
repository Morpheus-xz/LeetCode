class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        for(char ch:expression.toCharArray()){
            if(ch==',' || ch=='(')continue;
            if(ch=='t' || ch=='f' || ch=='!' || ch=='&' || ch=='|'){
                st.push(ch);
            }
            else if(ch==')'){
                boolean hasTrue=false,hasFalse=false;
                while(st.peek()!='!' && st.peek()!='&' && st.peek()!='|'){
                    char pvalue = st.pop();
                    if(pvalue=='t')hasTrue=true;
                    if(pvalue=='f')hasFalse=true;
                }
                char op=st.pop();
                if(op=='!'){
                    st.push(hasTrue?'f':'t');
                }
                else if(op=='&'){
                    st.push(hasFalse?'f':'t');
                }
                else{
                    st.push(hasTrue?'t':'f');
                }
            }
        }
        return st.peek()=='t';
    }
}