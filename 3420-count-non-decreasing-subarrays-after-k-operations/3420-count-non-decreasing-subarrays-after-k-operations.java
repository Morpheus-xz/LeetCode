class Solution {
    public int[] nge(int[] nums) {
        int n=nums.length;
        int[] nge=new int[n];
        Arrays.fill(nge,n);
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                nge[st.pop()]=i;
            }
            st.push(i);
        }
        return nge;
    }
    public long[] prefixsum(int[] nums) {
        int n=nums.length;
        long[] prefix=new long[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        return prefix;
    }
    public long rangesum(long[] prefix,int i,int j) {
        if(i>j)return 0;
        return prefix[j]-(i>0?prefix[i-1]:0);
    }
    public long[] calculateOperations(int[] nums,int[] nge,long[] prefix) {
        int n=nums.length;
        long[] operations=new long[n+1];
        for(int i=n-1;i>=0;i--){
            int m =nge[i];
            long cost =1L*nums[i]*(m-i)-rangesum(prefix,i,m-1);
            operations[i]=cost+operations[m];
        }
        return operations;
    }
    public long countNonDecreasingSubarrays(int[] nums,int k) {
        int n=nums.length;
        int[] nge=nge(nums);
        long[] prefix=prefixsum(nums);
        long[] operations=calculateOperations(nums,nge,prefix);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[0], a[0]));
        long ans =0;
        int i =0;
        for(int j=0;j<n;j++){
            pq.offer(new int[]{nums[j],j});
            while(i<=j){
                while(!pq.isEmpty() && pq.peek()[1]<i){
                    pq.poll();
                }
                int m =pq.peek()[1];
                long cost = operations[i]-operations[m]+1L*nums[m]*(j-m+1)-rangesum(prefix,m,j);
                if(cost<=k)break;
                i++;
            }
            ans+=j-i+1;
        }
        return ans;
    }
}