class Solution {

    class Pair implements Comparable<Pair> {
        String word;
        int freq;
        Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
        public int compareTo(Pair p) {
            if (this.freq == p.freq)
                return p.word.compareTo(this.word);
            return this.freq - p.freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (String word : map.keySet()) {
            pq.add(new Pair(word, map.get(word)));
            if (pq.size() > k)
                pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().word);
        }
        Collections.reverse(ans);
        return ans;
    }
}