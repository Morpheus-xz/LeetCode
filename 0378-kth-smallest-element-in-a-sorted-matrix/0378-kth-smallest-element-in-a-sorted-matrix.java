class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int x=0;
        int nums[]=new int[n*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nums[x++]=matrix[i][j];
            }
        }
        Arrays.sort(nums);
        return nums[k-1];
    }
}