class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long ts=0;
        int nc = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int value = matrix[i][j];
                ts+=Math.abs(value);
                if(value<0) nc++;
                min = Math.min(min,Math.abs(value));
            }
        }
        if(nc%2==0) return ts;
        else return ts-2*min;
    }
}