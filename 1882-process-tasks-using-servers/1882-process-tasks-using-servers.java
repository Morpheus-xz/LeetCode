class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        PriorityQueue<int[]> free = new PriorityQueue<>((a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        PriorityQueue<long[]> busy = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])return Long.compare(a[0],b[0]);
            if(a[1]!=b[1])return Long.compare(a[1],b[1]);
            return Long.compare(a[2],b[2]);
        });
        for(int i=0;i<n;i++){
            free.add(new int[]{servers[i],i});
        }
        int ans[] = new int[m];
        for(int i=0;i<m;i++){
            // busy server got free 
            while(!busy.isEmpty() && busy.peek()[0]<=i){
                long cur[] = busy.poll();
                free.add(new int[]{(int)cur[1],(int)cur[2]});
            }
            // no free server available
            if(free.isEmpty()){
                long cur[] = busy.poll();
                ans[i]=(int)cur[2];
                busy.add(new long[]{cur[0]+tasks[i],cur[1],cur[2]});
            }
            // free server available
            else{
                int curr[] = free.poll();
                ans[i]=curr[1];
                busy.add(new long[]{(long)i+tasks[i],curr[0],curr[1]});
            }
        }
        return ans;
    }
}