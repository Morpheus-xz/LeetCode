class Solution {
    public int digitsum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] sorted = new Integer[n];
        for(int i=0;i<n;i++){
            sorted[i]=nums[i];
        }
        Arrays.sort(sorted,(a,b)->{
            int x = digitsum(a),y=digitsum(b);
            if(x!=y)return Integer.compare(x,y);
            return Integer.compare(a,b);
        });
        HashMap<Integer,Integer> pos = new HashMap<>();
        for(int i=0;i<n;i++){
            pos.put(nums[i],i);
        }
        int swaps=0;
        for(int i=0;i<n;i++){
            if(nums[i]==sorted[i])continue;
            int val = sorted[i];
            int j = pos.get(val);
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            pos.put(nums[i],i);
            pos.put(nums[j],j);
            swaps++;
        }
        return swaps;
    }
}