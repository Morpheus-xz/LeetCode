class Solution {
    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        int[] sorted = new int[n];
        for(int i=0;i<n;i++){
            sorted[i]=nums[i];
        }
        Arrays.sort(sorted);
        int ans=0;
        for(int k=1;k<=n;k++){
            if(n%k!=0)continue;
            boolean valid=true;
            for(int start=0;start<n;start+=k){

                // This logic of mine failed becuase of duplicate cases edge case

                // int minIndex=start;
                // for(int j=start+1;j<start+k;j++){ // finding minimum index in block of k
                //     if(nums[j]<nums[minIndex]){
                //         minIndex=j;
                //     }
                // }
                // for(int i=0;i<k;i++){ // looking upto cyclicity
                //     int index = start+(minIndex-start+i)%k;
                //     if(nums[index]!=sorted[i+start]){
                //         valid=false;break;
                //     }
                // }
                int shift=0;
                for(int j=start;j<start+k-1;j++){
                    if(nums[j]>nums[j+1]){
                        shift=j+1-start;
                        break;
                    }
                }
                for(int i=0;i<k;i++){
                    int index = start+(shift+i)%k;
                    if(nums[index]!=sorted[start+i]){
                        valid=false;
                        break;
                    }
                }
                if(!valid)break;
            }
            if(valid)ans+=k;
        }
        return ans;
    }
}