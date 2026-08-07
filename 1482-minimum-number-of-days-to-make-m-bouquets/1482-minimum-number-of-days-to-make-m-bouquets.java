class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k)return -1;  //if m*k is greater than length of given array required bouquets can never be made 
        int max = Integer.MIN_VALUE; // we need to calculate max to get the max range thgis is the max all flower can take to bloom
        int min = Integer.MAX_VALUE; // similarly we need min as this could be the minimum possible answer
        for(int num:bloomDay){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        int low=min;int high=max;
        int ans=0;
        while(low<=high){
            int mid = (low+high)/2;
            if(possible(bloomDay,mid,m,k)){
                // ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public boolean possible(int[] arr, int day,int m,int k){
        int count=0; // counting number of adjacent flowers bloomed 
        int num=0; // number of bouquets that can be made using current count of adjacent flowers
        for(int ele:arr){
            if(ele<=day){ //  if element of array is bigger than the day flower is already bloomed
                count++;
                if(count==k){ // once count reaches value of k one bouquet if formed and count gets back to zero
                    num++;
                    count=0;
                }
            }
            else{
                count=0;
            }
        }
        return num>=m; // return by checking if the number of bouquets are equal or greater than m then only return true else it is false which is being returned
    }
}