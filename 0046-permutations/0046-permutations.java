class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        func(nums,ans,new ArrayList<>());
        return ans;
    }
    public void func(int[] arr,List<List<Integer>>ans,List<Integer>ds){
        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
        }
        else{
            for(int i=0;i<arr.length;i++){
                if(ds.contains(arr[i]))continue;
                ds.add(arr[i]);
                func(arr,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
}