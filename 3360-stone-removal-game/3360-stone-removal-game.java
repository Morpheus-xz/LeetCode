class Solution {
    public boolean canAliceWin(int n){
        return solve(n,10);
    }
    public boolean solve(int n,int st){
        if(n<st)return false;
        return !solve(n-st,st-1);
    }
}
