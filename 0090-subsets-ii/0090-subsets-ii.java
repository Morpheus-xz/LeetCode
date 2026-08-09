class Solution {
    static List<List<Integer>> arr;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        arr = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        subset(0,nums,ans);
        return arr;
    }
    public void subset(int idx,int[] nums,List<Integer>ans){
        arr.add(new ArrayList<>(ans));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1])continue;
            ans.add(nums[i]);
            subset(i+1,nums,ans);
            ans.remove(ans.size()-1);
        }
    }
}