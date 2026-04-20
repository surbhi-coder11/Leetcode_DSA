class Solution {
    public int cherryPickup_memoBetter(int r1, int c1, int r2, int n, int[][] grid, int[][][] dp){
        int c2 = r1 + c1 - r2; 
        if(r1 == n-1 && c1 == n-1){
            return dp[r1][c1][r2] = grid[r1][c1];
        }

        if(dp[r1][c1][r2] != -1) return dp[r1][c1][r2];

        int currCherries = 0;

        if(r1 == r2 && c1 == c2){
            currCherries = grid[r1][c1];
        } else {
            currCherries = grid[r1][c1] + grid[r2][c2];
        }

        int nextCherries = Integer.MIN_VALUE;
        int[][] dirs = {{0,1,0,1},{0,1,1,0},{1,0,0,1},{1,0,1,0}};

        for(int[] dir: dirs){
            int nextR1 = r1 + dir[0];
            int nextC1 = c1 + dir[1];
            int nextR2 = r2 + dir[2];
            int nextC2 = c2 + dir[3];

            if(nextR1 < n && nextR2 < n && nextC1 < n && nextC2 < n && grid[nextR1][nextC1] != -1 && grid[nextR2][nextC2] != -1){
                nextCherries = Math.max(nextCherries, cherryPickup_memoBetter(nextR1, nextC1, nextR2, n, grid, dp));
            }
        }

        return dp[r1][c1][r2] = currCherries + nextCherries;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length; 
        int[][][] dp = new int[n][n][n];

        for(int[][] a: dp){
            for(int[] b: a){
                Arrays.fill(b, -1);
            }
        }
        return Math.max(cherryPickup_memoBetter(0,0,0,n,grid,dp),0);
    }
}