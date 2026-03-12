import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int low = 0, high = 2000000000, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (can(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(int n, int[][] edges, int k, int target) {
        DSU dsu = new DSU(n);
        int upgrades = 0;
        int used = 0;

        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < target) return false;
                if (!dsu.union(e[0], e[1])) return false;
                used++;
            }
        }

        List<int[]> optional = new ArrayList<>();
        for (int[] e : edges) {
            if (e[3] == 0) optional.add(e);
        }

        optional.sort((a, b) -> b[2] - a[2]);

        for (int[] e : optional) {
            if (used == n - 1) break;
            if (dsu.find(e[0]) == dsu.find(e[1])) continue;

            if (e[2] >= target) {
                dsu.union(e[0], e[1]);
                used++;
            } else if (e[2] * 2 >= target && upgrades < k) {
                upgrades++;
                dsu.union(e[0], e[1]);
                used++;
            }
        }

        return used == n - 1;
    }
}
