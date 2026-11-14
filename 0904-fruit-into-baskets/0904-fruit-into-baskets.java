class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] freq = new int[n];
        int i=0,j=0;
        int max=0,cnt=0;
        while(j<n){
            if(freq[fruits[j]]==0)cnt++;
            freq[fruits[j]]++;
            while(cnt>2){
                freq[fruits[i]]--;
                if(freq[fruits[i]]==0)cnt--;
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}