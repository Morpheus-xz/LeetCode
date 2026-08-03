class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int required = t.length(); 
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (tmap.containsKey(ch)) {
                if (tmap.get(ch) > 0) {
                    required--;
                }
                tmap.put(ch, tmap.get(ch) - 1);
            }
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if (tmap.containsKey(leftChar)) {
                    tmap.put(leftChar, tmap.get(leftChar) + 1);
                    if (tmap.get(leftChar) > 0) {
                        required++;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}