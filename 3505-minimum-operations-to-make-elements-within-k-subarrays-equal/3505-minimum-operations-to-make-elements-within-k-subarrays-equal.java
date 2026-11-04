import java.util.*;

class Solution {
    private static final long INF = (long) 1e18;

    static class WindowMedianTracker {
        TreeMap<Integer, Integer> lowerMap = new TreeMap<>();
        TreeMap<Integer, Integer> upperMap = new TreeMap<>();
        long lowerSum = 0, upperSum = 0;
        int lowerSize = 0, upperSize = 0;

        void add(int num) {
            if (lowerMap.isEmpty() || num <= lowerMap.lastKey()) {
                lowerMap.merge(num, 1, Integer::sum);
                lowerSum += num;
                lowerSize++;
            } else {
                upperMap.merge(num, 1, Integer::sum);
                upperSum += num;
                upperSize++;
            }
            balance();
        }

        void remove(int num) {
            if (lowerMap.containsKey(num)) {
                lowerMap.merge(num, -1, Integer::sum);
                if (lowerMap.get(num) == 0) lowerMap.remove(num);
                lowerSum -= num;
                lowerSize--;
            } else {
                upperMap.merge(num, -1, Integer::sum);
                if (upperMap.get(num) == 0) upperMap.remove(num);
                upperSum -= num;
                upperSize--;
            }
            balance();
        }

        private void balance() {
            if (lowerSize < upperSize) {
                int val = upperMap.firstKey();
                removeUpper(val);
                addLower(val);
            } else if (lowerSize - upperSize > 1) {
                int val = lowerMap.lastKey();
                removeLower(val);
                addUpper(val);
            }
        }

        private void addLower(int val) {
            lowerMap.merge(val, 1, Integer::sum);
            lowerSum += val;
            lowerSize++;
        }

        private void removeLower(int val) {
            lowerMap.merge(val, -1, Integer::sum);
            if (lowerMap.get(val) == 0) lowerMap.remove(val);
            lowerSum -= val;
            lowerSize--;
        }

        private void addUpper(int val) {
            upperMap.merge(val, 1, Integer::sum);
            upperSum += val;
            upperSize++;
        }

        private void removeUpper(int val) {
            upperMap.merge(val, -1, Integer::sum);
            if (upperMap.get(val) == 0) upperMap.remove(val);
            upperSum -= val;
            upperSize--;
        }

        long getCost() {
            int median = lowerMap.lastKey();
            return (long) median * lowerSize - lowerSum + upperSum - (long) median * upperSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] windowCosts = new long[n];
        Arrays.fill(windowCosts, INF);

        WindowMedianTracker tracker = new WindowMedianTracker();
        for (int i = 0; i < n; i++) {
            tracker.add(nums[i]);
            if (i >= x) {
                tracker.remove(nums[i - x]);
            }
            if (i >= x - 1) {
                windowCosts[i - x + 1] = tracker.getCost();
            }
        }

        long[][] memo = new long[n + 1][k + 1];
        for (long[] row : memo) Arrays.fill(row, -1);

        return dp(0, k, x, windowCosts, memo, n);
    }

    private long dp(int idx, int remK, int x, long[] windowCosts, long[][] memo, int n) {
        if (remK == 0) return 0;
        if (idx > n - remK * x) return INF;
        if (memo[idx][remK] != -1) return memo[idx][remK];

        long skip = dp(idx + 1, remK, x, windowCosts, memo, n);
        long pick = INF;
        if (windowCosts[idx] != INF) {
            long nextCost = dp(idx + x, remK - 1, x, windowCosts, memo, n);
            if (nextCost != INF) {
                pick = windowCosts[idx] + nextCost;
            }
        }

        return memo[idx][remK] = Math.min(skip, pick);
    }
}