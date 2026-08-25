class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean exist[] = new boolean[101];
        for(int num:nums){
            if(num%k==0){
                exist[num/k]=true;
            }
        }
        for(int i=1;i<=100;i++){
            if(exist[i]==false){
                return i*k;
            }
        }
        return 101*k;
    }
}