class Solution {
    static final int MOD = 1000000007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        Integer[][][] dp = new Integer[zero + 1][one + 1][2];
        return (dfs(zero, one, 0, limit, dp) + dfs(zero, one, 1, limit, dp)) % MOD;
    }

    private int dfs(int z, int o, int last, int limit, Integer[][][] dp) {
        if (z == 0 && o == 0) return 1;
        if (dp[z][o][last] != null) return dp[z][o][last];

        long res = 0;

        if (last == 0) {
            for (int i = 1; i <= Math.min(limit, z); i++) {
                res = (res + dfs(z - i, o, 1, limit, dp)) % MOD;
            }
        } else {
            for (int i = 1; i <= Math.min(limit, o); i++) {
                res = (res + dfs(z, o - i, 0, limit, dp)) % MOD;
            }
        }

        return dp[z][o][last] = (int) res;
    }
}
