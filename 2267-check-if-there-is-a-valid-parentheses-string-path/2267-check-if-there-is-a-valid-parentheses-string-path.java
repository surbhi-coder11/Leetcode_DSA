class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // A valid path must have an even length, start with '(', and end with ')'
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        int maxBalance = (m + n) / 2;
        // dp[i][j][b] represents whether we can reach cell (i, j) with a parenthesis balance of b
        boolean[][][] dp = new boolean[m][n][maxBalance + 1];

        if (grid[0][0] == '(') {
            dp[0][0][1] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int b = 0; b <= maxBalance; b++) {
                    if (!dp[i][j][b]) continue;

                    // Try moving down
                    if (i + 1 < m) {
                        int nextB = b + (grid[i + 1][j] == '(' ? 1 : -1);
                        if (nextB >= 0 && nextB <= maxBalance) {
                            dp[i + 1][j][nextB] = true;
                        }
                    }

                    // Try moving right
                    if (j + 1 < n) {
                        int nextB = b + (grid[i][j + 1] == '(' ? 1 : -1);
                        if (nextB >= 0 && nextB <= maxBalance) {
                            dp[i][j + 1][nextB] = true;
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}