class Solution {

    public int helper(int i, int j,int[][] d , int[][] dp){
        if(i>=d.length || j>=d[0].length){
            return Integer.MAX_VALUE;
        }

        if(i== d.length-1 && j==d[0].length-1){
            return Math.max(1,1-d[i][j]);
        }
        if(dp[i][j] !=0){
            return dp[i][j];
        }
        int right = helper(i,j+1,d,dp);
        int down = helper(i+1,j,d,dp);

        int min = Math.min(right , down);

        dp[i][j] = Math.max(1,min - d[i][j]);

        return dp[i][j];



        
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        return helper(0,0,dungeon, dp);
    //     dp[m-1][n-1] = Math.max(1,1-dungeon[m-1][n-1]);

    //     for(int i=m-2;i>=0;i--){
    //         dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
    //     }

    //     for(int i=n-2;i>=0;i--){
    //         dp[m-1][i] =Math.max(1,dp[m-1][i+1]-dungeon[m-1][i]);
    //     }

    //     for(int i=m-2;i>=0;i--){
    //         for(int j=n-2;j>=0;j--){
    //             dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
    //         }
    //     }

    //    return dp[0][0];
    }
}