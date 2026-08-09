class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        Arrays.sort(candidates);
        fc(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void fc(int idx,int[] arr,int target,List<List<Integer>>ans,List<Integer>ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1])continue;
            if(target<arr[i])break;
            ds.add(arr[i]);
            fc(i+1,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}