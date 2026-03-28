class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int st =0;
        int en = matrix[0].length-1;
        while(en>=0 && st<matrix.length){
            if(matrix[st][en]==target){
                return true;
            }
            else if(target<matrix[st][en]){
                en--;
            }else{
                st++;
            }
        }
        return false;
    }
}