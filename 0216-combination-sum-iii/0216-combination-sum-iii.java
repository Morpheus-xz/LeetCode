class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(1,k,n,ans,new ArrayList<>());
        return ans;
    }
    public void combination(int idx,int k, int n, List<List<Integer>>ans,ArrayList<Integer>ds){
            if(ds.size()==k){
                if(n==0){
                    ans.add(new ArrayList<>(ds));
                }
                return;
            }
            for(int i=idx;i<=9;i++){
                if(i>n)break;
                ds.add(i);
                combination(i+1,k,n-i,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
}