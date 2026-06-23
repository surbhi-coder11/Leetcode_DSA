class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        // Length = 2 initialization
        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;      // previous value < v
            down[v] = m - v;    // previous value > v
        }

        if (n == 2) {
            long ans = 0;
            for (int v = 1; v <= m; v++) {
                ans = (ans + up[v] + down[v]) % MOD;
            }
            return (int) ans;
        }

        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            long[] prefDown = new long[m + 1];
            long[] prefUp = new long[m + 1];

            for (int v = 1; v <= m; v++) {
                prefDown[v] = (prefDown[v - 1] + down[v]) % MOD;
                prefUp[v] = (prefUp[v - 1] + up[v]) % MOD;
            }

            long totalUp = prefUp[m];

            for (int v = 1; v <= m; v++) {
                // Last move becomes UP, so previous move must be DOWN
                newUp[v] = prefDown[v - 1];

                // Last move becomes DOWN, so previous move must be UP
                newDown[v] = (totalUp - prefUp[v] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }

        return (int) ans;
    }
}