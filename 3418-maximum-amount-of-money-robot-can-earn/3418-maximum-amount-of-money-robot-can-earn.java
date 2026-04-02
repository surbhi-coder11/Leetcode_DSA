class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        
        // dp[i][j][k] represents max coins at (i, j) with k neutralizations remaining
        // Using 501 based on constraints m, n <= 500
        int[][][] dp = new int[m][n][3];
        
        // Initialize with a very small value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        
        // Base case: Starting point (0,0)
        // Option 1: Don't use neutralization
        dp[0][0][0] = coins[0][0];
        // Option 2: Use neutralization if it's a robber
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;
                    
                    // Possible moves: Right and Down
                    int[][] directions = {{0, 1}, {1, 0}};
                    
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        
                        if (ni < m && nj < n) {
                            // Path A: Don't neutralize the next cell
                            dp[ni][nj][k] = Math.max(dp[ni][nj][k], dp[i][j][k] + coins[ni][nj]);
                            
                            // Path B: Neutralize the next cell (if it's a robber and we have charges left)
                            if (k + 1 < 3 && coins[ni][nj] < 0) {
                                dp[ni][nj][k + 1] = Math.max(dp[ni][nj][k + 1], dp[i][j][k]);
                            }
                        }
                    }
                }
            }
        }
        
        // The answer is the max of reaching the bottom-right with 0, 1, or 2 neutralizations used
        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}