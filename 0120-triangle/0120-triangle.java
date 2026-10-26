class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[][] dp = new int[n][m];
        for(int i=0;i<m;i++){
            dp[n-1][i] = triangle.get(n-1).get(i); 
        }
        for (int row = n - 2; row >= 0; row--) {
            for(int col =0;col<=row;col++){
                dp[row][col] = triangle.get(row).get(col)+Math.min(dp[row+1][col],dp[row+1][col+1]);
                
            }
        }

        return dp[0][0];
    }
}