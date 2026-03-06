import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] c : connections) {
            graph.get(c[0]).add(new int[]{c[1], 1});
            graph.get(c[1]).add(new int[]{c[0], 0});
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] nei : graph.get(node)) {
            int next = nei[0], cost = nei[1];
            if (!visited[next]) {
                changes += cost + dfs(next, graph, visited);
            }
        }

        return changes;
    }
}
