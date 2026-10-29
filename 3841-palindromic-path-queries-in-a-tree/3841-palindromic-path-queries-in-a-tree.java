import java.util.*;

class Solution {
    class FenwickTree {
        int n;
        int[] tree;

        public FenwickTree(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        public void update(int i, int delta) {
            for (; i <= n; i += i & -i) {
                tree[i] ^= delta;
            }
        }

        public void rangeUpdate(int L, int R, int val) {
            update(L, val);
            update(R + 1, val);
        }

        public int query(int i) {
            int res = 0;
            for (; i > 0; i -= i & -i) {
                res ^= tree[i];
            }
            return res;
        }
    }

    int timer = 0;
    int[] in, out, depth;
    int[][] up;
    int LOG = 17; // log2(50000) is roughly 16

    public List<Boolean> palindromePath(int n, int[][] edges, String sStr, String[] queries) {
        char[] s = sStr.toCharArray();
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        in = new int[n];
        out = new int[n];
        depth = new int[n];
        int[] rootPath = new int[n];
        up = new int[n][LOG];

        // 1. DFS to compute Euler tour order, root-to-node paths, and binary lifting table
        dfs(0, -1, 0, 0, adj, rootPath, s);

        // 2. Initialize Fenwick Tree with initial root paths
        FenwickTree ft = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            ft.rangeUpdate(in[i], in[i], rootPath[i]);
        }

        // 3. Process queries
        List<Boolean> result = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char newC = parts[2].charAt(0);
                char oldC = s[u];
                if (oldC != newC) {
                    int delta = (1 << (oldC - 'a')) ^ (1 << (newC - 'a'));
                    s[u] = newC;
                    ft.rangeUpdate(in[u], out[u], delta);
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int lca = getLCA(u, v);
                int maskU = ft.query(in[u]);
                int maskV = ft.query(in[v]);
                int pathMask = maskU ^ maskV ^ (1 << (s[lca] - 'a'));
                // Check if at most one bit is set
                result.add(pathMask == 0 || (pathMask & (pathMask - 1)) == 0);
            }
        }
        return result;
    }

    private void dfs(int u, int p, int d, int currentPathMask, List<Integer>[] adj, int[] rootPath, char[] s) {
        timer++;
        in[u] = timer;
        depth[u] = d;
        up[u][0] = p;
        for (int i = 1; i < LOG; i++) {
            if (up[u][i - 1] != -1) {
                up[u][i] = up[up[u][i - 1]][i - 1];
            } else {
                up[u][i] = -1;
            }
        }

        currentPathMask ^= (1 << (s[u] - 'a'));
        rootPath[u] = currentPathMask;

        for (int v : adj[u]) {
            if (v != p) {
                dfs(v, u, d + 1, currentPathMask, adj, rootPath, s);
            }
        }
        out[u] = timer;
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = up[u][i];
            }
        }
        if (u == v) return u;
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }
}