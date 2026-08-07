class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int num:piles){
            max = Math.max(max,num);
        }
        int low=1;
        int high=max;
        int ans=max;
        while(low<=high){
            int mid = (low+high)/2;
            long hour = calculatehour(piles,mid);
            if(hour<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public long calculatehour(int[] piles,int speed){
        long total=0;
        for(int num:piles){
            total+=(int)Math.ceil((double)num/speed);
        }
        return total;
    }
}