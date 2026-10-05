class Solution {
    public int scoreOfParentheses(String s) {
        int score=0;
        int ans=0;
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){ // if we encounter an opening bracket
                lst.add(score);
                score=0;
            }else{ // when we encounter a closing bracket ")"
            if(s.charAt(i-1)=='('){
                score=lst.get(lst.size()-1)+1;
            }else{ //nested loop (A)
            score=lst.get(lst.size()-1)+2*score;
            }
            lst.remove(lst.size()-1);
            if(lst.isEmpty()){
                ans+=score;
                score=0;
            }
            }
        }
        return ans;
    }
}