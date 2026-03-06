import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(start, end, 1.0, new HashSet<>(), graph);
            }
        }

        return result;
    }

    private double dfs(String curr, String target, double product, Set<String> visited,
                       Map<String, Map<String, Double>> graph) {

        if (curr.equals(target)) return product;

        visited.add(curr);

        for (Map.Entry<String, Double> neighbor : graph.get(curr).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double res = dfs(neighbor.getKey(), target, product * neighbor.getValue(), visited, graph);
                if (res != -1.0) return res;
            }
        }

        return -1.0;
    }
}
