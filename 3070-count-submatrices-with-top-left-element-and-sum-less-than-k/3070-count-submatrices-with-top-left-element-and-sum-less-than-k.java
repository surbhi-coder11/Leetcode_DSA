class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] prefix = new int[n+1][m+1];
        int countmat = 0;
        for(int i=0;i<n ;i++){
            for(int j=0;j<m;j++){
                prefix[i+1][j+1] = grid[i][j] + prefix[i+1][j] + prefix[i][j+1]- prefix[i][j];
                if(prefix[i+1][j+1]<=k){
                    countmat++;
                }
            }
        }
        return countmat;
    }
}