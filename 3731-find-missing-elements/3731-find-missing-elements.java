class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            min=Math.min(min,num);
        }
        for(int num:nums){
            max=Math.max(max,num);
        }
        HashSet<Integer> s = new HashSet<>();
        for(int i=min;i<=max;i++){
            s.add(i);
        }
        for(int num: nums){
            if(s.contains(num))s.remove(num);
        }
        for(int num:s){
            ans.add(num);
        }
        Collections.sort(ans);
        return ans;
    }
}