class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        func(nums,used,ans,new ArrayList<>());
        return ans;
    }
    public void func(int[] arr,boolean[] used,List<List<Integer>>ans, List<Integer> ds){
     if(ds.size()==arr.length){
        ans.add(new ArrayList<>(ds));
        return;
     }
     for(int i=0;i<arr.length;i++){
        if(used[i])continue;
        if(i>0 && arr[i]==arr[i-1] && !used[i-1]) continue;
        used[i]=true;
        ds.add(arr[i]);
        func(arr,used,ans,ds);
        ds.remove(ds.size()-1);
        used[i]=false;
     }  
    }
}