class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] freq = new int[201];
        for (int num : nums) {
            int row = freq[num]++;
            if (row == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(row).add(num);
        }
        return result;
    }
}