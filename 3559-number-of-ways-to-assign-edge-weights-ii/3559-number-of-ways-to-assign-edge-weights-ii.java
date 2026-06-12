class Solution {
    int M = 1000000007;
    int n;
    int cols;

    List<List<Integer>> adj;
    int[][] ancestorTable;
    int[] depth;

    void dfs(int root, int parent) {
        ancestorTable[root][0] = parent;

        for (int ngbr : adj.get(root)) {
            if (ngbr == parent) continue;

            depth[ngbr] = depth[root] + 1;

            dfs(ngbr, root);
        }
    }

    void buildAncestorTable() {
        for (int j = 1; j < cols; j++) {
            for (int node = 0; node < n; node++) {
                if (ancestorTable[node][j - 1] != -1)
                    ancestorTable[node][j] = ancestorTable[ancestorTable[node][j - 1]][j - 1];
            }
        }
    }

    int findLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int k = depth[u] - depth[v];

        for (int j = 0; j < cols; j++) {
            if ((k & (1 << j)) != 0) {
                u = ancestorTable[u][j];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = cols - 1; j >= 0; j--) {
            if (ancestorTable[u][j] == -1) {
                continue;
            }

            if (ancestorTable[u][j] != ancestorTable[v][j]) {
                u = ancestorTable[u][j];
                v = ancestorTable[v][j];
            }
        }

        return ancestorTable[u][0];
    }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        n = edges.length + 1;
        cols = (int) (Math.log(n) / Math.log(2)) + 1;

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        depth = new int[n];
        ancestorTable = new int[n][cols];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cols; j++) {
                ancestorTable[i][j] = -1;
            }
        }

        dfs(0, -1);
        buildAncestorTable();

        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (2L * pow2[i - 1]) % M;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0] - 1;
            int v = queries[i][1] - 1;

            int lca = findLCA(u, v);
            int d = depth[u] + depth[v] - 2 * depth[lca];

            if (d == 0) {
                result[i] = 0;
            } else {
                result[i] = (int) pow2[d - 1];
            }
        }

        return result;
    }
}