class Solution {
    public class Pair implements Comparable<Pair>{
        int ele;
        int freq;
        Pair(int ele, int freq){
            this.ele=ele;
            this.freq=freq;
        }
        public int compareTo(Pair p){
            return this.freq-p.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int ele : nums){
            if(mp.containsKey(ele)){
                mp.put(ele,mp.get(ele)+1);
            }
            else{
                mp.put(ele,1);
            }
        }
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        for(int ele:mp.keySet()){
            int freq = mp.get(ele);
            pq.add(new Pair(ele,freq));
            if(pq.size()>k) pq.remove();
        }
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            Pair p = pq.remove();
            ans[i]=p.ele;
        }
        return ans;
    }
}