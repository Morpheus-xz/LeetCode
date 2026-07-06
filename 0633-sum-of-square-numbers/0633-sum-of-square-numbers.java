class Solution {
    public boolean judgeSquareSum(int c) {
        long start = 0;
        long end= (long)Math.sqrt(c);
        while(start<=end){
            long res = start*start + end*end;
            if(res==c){
                return true;
            }
            else if(res<c){
                start++;
            }
            else{
                end--;
            }
        }
        return false;
    }
}