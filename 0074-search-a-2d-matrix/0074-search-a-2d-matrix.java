class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            boolean find=false;
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target){
                    find=true;break;
                }
            }
            if(find){
                return true;
            }
            
        }
        return false;
    }
}