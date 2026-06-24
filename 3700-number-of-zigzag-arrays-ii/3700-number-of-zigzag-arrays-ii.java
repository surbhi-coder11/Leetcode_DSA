class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;

        long[][] mat = new long[size][size];

        // up(x) -> down(y), y > x
        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) {
                mat[x][m + y] = 1;
            }
        }

        // down(x) -> up(y), y < x
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < x; y++) {
                mat[m + x][y] = 1;
            }
        }

        long[][] p = matPow(mat, n - 1);

        long[] start = new long[size];

        // Initial vectors combined
        for (int i = 0; i < m; i++) {
            start[i] = 1;
            start[m + i] = 1;
        }

        long ans = 0;

        for (int i = 0; i < size; i++) {
            long cur = 0;
            for (int j = 0; j < size; j++) {
                cur = (cur + p[i][j] * start[j]) % MOD;
            }
            ans = (ans + cur) % MOD;
        }

        return (int) ans;
    }

    private long[][] matPow(long[][] a, long exp) {
        int n = a.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, a);
            }
            a = multiply(a, a);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                long val = a[i][k];

                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;

                    c[i][j] = (c[i][j] + val * b[k][j]) % MOD;
                }
            }
        }

        return c;
    }
}