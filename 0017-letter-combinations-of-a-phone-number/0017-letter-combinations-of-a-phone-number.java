class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        combination(0, digits, map, ans, new StringBuilder());
        return ans;
    }
    public void combination(int idx,String digits,HashMap<Integer,String>map,List<String>ans,StringBuilder ds){
        if(idx==digits.length()){
            ans.add(ds.toString());
            return;
        }
        int digit = digits.charAt(idx)-'0';
        String letter = map.get(digit);
        for(int i=0;i<letter.length();i++){
            ds.append(letter.charAt(i));
            combination(idx+1,digits,map,ans,ds);
            ds.deleteCharAt(ds.length()-1);
        }
    }
}