class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fc=0;
        int tc=0;
        for(int ele:bills){
            if(ele==5)fc++;
            else if(ele==10){
                if (fc==0) return false;
                tc++;
                fc--;
            }
            else if(ele==20){
                if(fc>0 && tc>0){
                tc--;
                fc--;
                }
                else if(fc>=3)fc-=3;
                else return false;
            }
        }
        return true;
    }
}