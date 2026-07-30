class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l=0;int r=0;int maxl=0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(!set.contains(ch)){
                set.add(ch);
                maxl=Math.max(maxl,r-l+1);
                r++;
            }
            else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        return maxl;
    }
}