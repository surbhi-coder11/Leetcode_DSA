import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int i = 0, j = costs.length - 1;

        for (int c = 0; c < candidates && i <= j; c++) {
            left.add(costs[i++]);
        }

        for (int c = 0; c < candidates && i <= j; c++) {
            right.add(costs[j--]);
        }

        long total = 0;

        for (int hired = 0; hired < k; hired++) {
            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {
                total += left.poll();
                if (i <= j) left.add(costs[i++]);
            } else {
                total += right.poll();
                if (i <= j) right.add(costs[j--]);
            }
        }

        return total;
    }
}
