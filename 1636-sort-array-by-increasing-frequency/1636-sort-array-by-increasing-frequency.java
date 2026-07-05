class Solution {

    public class Pair implements Comparable<Pair> {

        int ele;
        int freq;

        Pair(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }

        public int compareTo(Pair p) {

            if (this.freq == p.freq)
                return p.ele - this.ele;   // Larger element first

            return this.freq - p.freq;     // Smaller frequency first
        }
    }

    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (int ele : nums) {
            mp.put(ele, mp.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int ele : mp.keySet()) {
            pq.add(new Pair(ele, mp.get(ele)));
        }

        int[] ans = new int[nums.length];
        int idx = 0;

        while (!pq.isEmpty()) {

            Pair p = pq.remove();

            while (p.freq-- > 0) {
                ans[idx++] = p.ele;
            }
        }

        return ans;
    }
}