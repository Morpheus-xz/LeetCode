class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k)return -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num:bloomDay){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        int low=min;int high=max;
        int num=0;
        int ans=0;
        while(low<=high){
            int mid = (low+high)/2;
            if(possible(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int[] arr, int day,int m,int k){
        int count=0;
        int num=0;
        for(int ele:arr){
            if(ele<=day){
                count++;
                if(count==k){
                    num++;
                    count=0;
                }
            }
            else{
                count=0;
            }
        }
        return num>=m;
    }
}